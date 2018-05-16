package com.ccclubs.admin.controller.can;

import com.ccclubs.admin.model.HistoryCan;
import com.ccclubs.admin.model.ReportParam;
import com.ccclubs.admin.query.HistoryCanQuery;
import com.ccclubs.admin.service.IHistoryCanService;
import com.ccclubs.admin.task.threads.ReportThread;
import com.ccclubs.admin.util.EvManageContext;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.admin.vo.VoResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * 车辆CAN历史数据Controller
 *
 * @author
 * @category generated by NovaV1.0
 * @since V1.0
 */
@RestController
@RequestMapping("/monitor/historyCan")
public class HistoryCanController {

    Logger logger = LoggerFactory.getLogger(HistoryCanController.class);

    @Autowired
    IHistoryCanService historyCanService;

    @Autowired
    ReportThread reportThread;

    /**
     * 获取分页列表数据
     *
     * @param query
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public TableResult<HistoryCan> list(HistoryCanQuery query, @RequestParam(defaultValue = "0") Integer page,
                                        @RequestParam(defaultValue = "10") Integer rows,
                                        @RequestParam(defaultValue = "desc") String order,
                                        @RequestParam(defaultValue = "true") Boolean isResolve) {
        if (null == query.getCsNumberEquals()) {
            return new TableResult<HistoryCan>();
        }
        TableResult<HistoryCan> pageInfo = historyCanService.getPage(query, page, rows, order);
        List<HistoryCan> list = pageInfo.getData();
        for (HistoryCan data : list) {
            registResolvers(data);
        }
        return pageInfo;
    }


    /**
     * 注册属性内容解析器
     */
    void registResolvers(HistoryCan data) {
        if (data != null) {
        }
    }


    /**
     * 根据文本检索车辆历史状态信息并导出。
     */
    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public VoResult<String> getReport(@RequestBody ReportParam<HistoryCanQuery> reportParam) {
        List<HistoryCan> list;
        if (null == reportParam.getQuery().getCsNumberEquals() ||
                null == reportParam.getQuery().getCurrentTimeStart() ||
                null == reportParam.getQuery().getCurrentTimeEnd()) {
            //TODO 需要Phoenix支持只使用时间的查询。
            VoResult<String> r = new VoResult<>();
            r.setSuccess(false).setMessage("导出任务需要足够的参数。");
            return r;
        }
        TableResult<HistoryCan> pageInfo = historyCanService.getPage(
                reportParam.getQuery(),
                -1,//reportParam.getPage(),
                reportParam.getRows(),
                reportParam.getOrder());
        list = pageInfo.getData();


        for (HistoryCan data : list) {
            registResolvers(data);
        }

        String uuid = UUID.randomUUID().toString();
        reportThread.setBaseName("History_Can");
        reportThread.setList(list);
        reportThread.setUserUuid(uuid);
        reportThread.setReportParam(reportParam);
        logger.info("start running report History_Can thread.");
        EvManageContext.getThreadPool().execute(reportThread);

        VoResult<String> r = new VoResult<>();
        r.setSuccess(true).setMessage("导出任务已经开始执行，请稍候。");
        r.setValue(uuid);
        return r;

    }

}
