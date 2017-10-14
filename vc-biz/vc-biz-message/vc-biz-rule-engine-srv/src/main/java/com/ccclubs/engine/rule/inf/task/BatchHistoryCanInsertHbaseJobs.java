package com.ccclubs.engine.rule.inf.task;

import com.alibaba.fastjson.JSON;
import com.ccclubs.common.BatchProperties;
import com.ccclubs.common.modify.UpdateCanService;
import com.ccclubs.common.utils.EnvironmentUtils;
import com.ccclubs.engine.core.util.RuleEngineConstant;
import com.ccclubs.mongo.orm.model.CsHistoryCan;
import com.ccclubs.protocol.util.StringUtils;
import com.ccclubs.pub.orm.model.CsState;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * {@link CsState} 状态数据定时任务<br/> 包含当前状态批量更新，历史状态数据批量写入
 **/
@Component
public class BatchHistoryCanInsertHbaseJobs implements ApplicationContextAware {

  private static final Logger logger = LoggerFactory
      .getLogger(BatchHistoryCanInsertHbaseJobs.class);

  @Autowired
  RedisTemplate redisTemplate;
  @Autowired
  UpdateCanService updateCanService;

  @Autowired
  EnvironmentUtils environmentUtils;

  protected static ApplicationContext context;

  private String WAIT_QUEUE_NAME;

  @Autowired
  BatchProperties batchProperties;

  /**
   * 扫描请求队列
   */
//  @Scheduled(fixedRate = 15*1000)
  public void fixedRateJob() {
    logger.debug(" BatchHistoryCanInsertHbaseJobs start. {}");
    Long startTime = System.currentTimeMillis();
    if (StringUtils.empty(WAIT_QUEUE_NAME)) {
      WAIT_QUEUE_NAME = getWaiteQueueName();
      if (StringUtils.empty(WAIT_QUEUE_NAME)) {
        logger.error(" host ip not found. WAIT_QUEUE_NAME is null");
        return;
      }
    }
    //取出队列中所有等待更新的数据
    Long canListSrcSize = redisTemplate.opsForList()
        .size(RuleEngineConstant.REDIS_KEY_HISTORY_CAN_BATCH_INSERT_QUEUE);
    if (canListSrcSize > 0) {
      long redisListStartTime = System.currentTimeMillis();
      while (System.currentTimeMillis() - redisListStartTime < batchProperties
          .getHbaseInsertMaxDurTime()) {
        Long canListWaitSize = redisTemplate.opsForList().size(WAIT_QUEUE_NAME);
        if (canListWaitSize > batchProperties.getHbaseInsertBatchSize()) {
          break;
        }
        //取出队列中 等待写入的数据
        redisTemplate.opsForList()
            .rightPopAndLeftPush(RuleEngineConstant.REDIS_KEY_HISTORY_CAN_BATCH_INSERT_QUEUE,
                WAIT_QUEUE_NAME);
        try {
          Thread.sleep(5L);
        } catch (InterruptedException e) {
          logger.error(e.getMessage(), e);
        }
      }
    }

    logger.debug(" foeach redis list time {} ", System.currentTimeMillis() - startTime);

    // 等待更新的队列
    List<CsHistoryCan> canListWait = redisTemplate.opsForList()
        .range(WAIT_QUEUE_NAME, 0, -1);

    if (canListWait.size() > 0) {
      try {
        // 通过hbase批量写入
//        updateCanService.batchInsertHistory(canListWait);
        // 删除
        redisTemplate.delete(WAIT_QUEUE_NAME);
        logger.info("current batch insert hbase canHistory size : {} ,time {}", canListWait.size(),
            System.currentTimeMillis() - startTime);
      } catch (Exception ex) {
        ex.printStackTrace();
        logger.error("batch insert history canHistoryList error. error list content : {}",
            JSON.toJSONString(canListWait));
      }
    }
  }

  private String getWaiteQueueName() {
    String hostIp = environmentUtils.getCurrentIp();
    if (!StringUtils.empty(hostIp)) {
      return RuleEngineConstant.REDIS_KEY_HISTORY_CAN_BATCH_INSERT_QUEUE + ":" +
          environmentUtils.getCurrentIp().replaceAll("\\.", "#");
    }
    return hostIp;
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.context = applicationContext;
  }
}