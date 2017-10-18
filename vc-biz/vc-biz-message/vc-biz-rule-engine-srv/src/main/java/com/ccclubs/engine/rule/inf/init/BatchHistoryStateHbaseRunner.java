package com.ccclubs.engine.rule.inf.init;

import com.alibaba.fastjson.JSON;
import com.ccclubs.common.BatchProperties;
import com.ccclubs.common.modify.UpdateStateService;
import com.ccclubs.common.utils.EnvironmentUtils;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.engine.rule.inf.util.HistoryStateUtils;
import com.ccclubs.pub.orm.model.CsState;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * CsState 当前状态数据更新
 *
 * @author qsxiaogang
 * @create 2017-10-14
 **/
@Component
@Order(2)
public class BatchHistoryStateHbaseRunner implements CommandLineRunner {

  @Autowired
  RedisTemplate redisTemplate;
  @Autowired
  UpdateStateService updateStateService;

  @Autowired
  HistoryStateUtils historyStateUtils;
  @Autowired
  EnvironmentUtils environmentUtils;
  @Autowired
  BatchProperties batchProperties;

  private static final Logger logger = LoggerFactory.getLogger(BatchHistoryStateHbaseRunner.class);

  @SuppressWarnings("unchecked")
  @Override
  public void run(String... strings) throws Exception {
    ExecutorService fixedThreadPool = Executors
        .newFixedThreadPool(batchProperties.getHbaseInsertThreads());
    fixedThreadPool.execute(() -> {
      while (true) {
        logger.debug("BatchHistoryStateHbaseRunner start. {}");
        List<CsState> waitList = new ArrayList();
        try {
          Long startTime = System.currentTimeMillis();
          //取出队列中所有等待更新的数据
          Long stateListSrcSize = redisTemplate.opsForList()
              .size(RuleEngineConstant.REDIS_KEY_HISTORY_STATE_BATCH_INSERT_QUEUE);
          if (stateListSrcSize > 0) {
            long redisListStartTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - redisListStartTime < batchProperties
                .getHbaseInsertMaxDurTime()) {
              int stateListWaitSize = waitList.size();
              if (stateListWaitSize > batchProperties.getHbaseInsertBatchSize()) {
                break;
              }
              //取出队列中 等待写入的数据
              Object item = redisTemplate.opsForList()
                  .rightPop(RuleEngineConstant.REDIS_KEY_HISTORY_STATE_BATCH_INSERT_QUEUE);
              if (null == item) {
                break;
              } else {
                waitList.add((CsState) item);
              }
            }
          }

          // 等待更新的队列
          logger.debug("size:{},time:{} check from redis list ", waitList.size(),
              System.currentTimeMillis() - startTime);

          if (waitList.size() > 0) {
              //TODO: HBase 批量写入
            historyStateUtils.saveHistoryDataToHbase(waitList);
//            updateStateService.batchUpdate(waitList);
            logger.info("size:{},time:{} BatchHistoryStateHbaseRunner batch insert  ", waitList.size(),
                System.currentTimeMillis() - startTime);

          }
        } catch (Exception ex) {
          ex.printStackTrace();
          logger.error(ex.getMessage());
          if (waitList.size() > 0) {
            logger.error("batch insert current stateList error. error list content : {}",
                JSON.toJSONString(waitList));
          }
        } finally {
          waitList = null;
        }
      }
    });
  }
}
