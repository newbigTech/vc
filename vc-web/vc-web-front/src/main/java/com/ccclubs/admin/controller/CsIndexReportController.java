package com.ccclubs.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.aliyun.oss.OSSClient;
import com.ccclubs.admin.model.CsIndexReport;
import com.ccclubs.admin.model.ReportModel;
import com.ccclubs.admin.model.ReportParam;
import com.ccclubs.admin.query.CsIndexReportQuery;
import com.ccclubs.admin.resolver.CsIndexReportResolver;
import com.ccclubs.admin.service.ICsIndexReportService;
import com.ccclubs.admin.service.IReportService;
import com.ccclubs.admin.task.threads.CsIndexReportThread;
import com.ccclubs.admin.util.EvManageContext;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.admin.vo.VoResult;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.quota.inf.CsIndexQuotaInf;
import com.ccclubs.quota.vo.CsIndexReportInput;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 指标统计Controller
 *
 * @author
 * @category generated by NovaV1.0
 * @since V1.0
 */
@RestController
@RequestMapping("/monitor/analysis/quota")
public class CsIndexReportController {

  //Fixme 后期请将此对象存储在redis中。以便加强程序健壮性。
  //public static final Map<String,String> ossFileMap=new HashMap<>();
  private static final Logger logger = LoggerFactory.getLogger(CsIndexReportController.class);

  @Autowired
  ICsIndexReportService csIndexReportService;

  @Reference(version = "1.0.0")
  private CsIndexQuotaInf csIndexQuotaInf;
  @Autowired
  IReportService reportService;

  @Autowired
  private OSSClient ossClient;


  /**
   * 获取分页列表数据
   */
  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public TableResult<CsIndexReport> list(CsIndexReportQuery query,
      @RequestParam(defaultValue = "0") Integer page,
      @RequestParam(defaultValue = "10") Integer rows) {
    //PageInfo<CsIndexReport> pageInfo = csIndexReportService.getPage(query.getCrieria(), page, rows);
    CsIndexReportInput csIndexReportInput = new CsIndexReportInput();
    csIndexReportInput.setCsNumber(query.getCsNumberEquals());
    csIndexReportInput.setCsVin(query.getCsVinEquals());
    csIndexReportInput.setPageNum(page);
    csIndexReportInput.setPageSize(rows);
    PageInfo<com.ccclubs.quota.orm.model.CsIndexReport> pageInfoFromQuota = csIndexQuotaInf
        .bizQuota(csIndexReportInput);
    List<com.ccclubs.quota.orm.model.CsIndexReport> csIndexReportFromQuotaList = pageInfoFromQuota
        .getList();
    PageInfo<CsIndexReport> pageInfo = new PageInfo<>();
    copyPageInfo(pageInfo, pageInfoFromQuota);

    List<CsIndexReport> list = new ArrayList<>();//pageInfo.getList();
    if (null != csIndexReportFromQuotaList && csIndexReportFromQuotaList.size() > 0) {
      for (int i = 0; i < csIndexReportFromQuotaList.size(); i++) {
        CsIndexReport csIndexReport = new CsIndexReport();
        dealCsIndexReportFromQuotaToThis(csIndexReport, csIndexReportFromQuotaList.get(i));
        list.add(csIndexReport);
      }
    }
    pageInfo.setList(list);
    for (CsIndexReport data : list) {
      registResolvers(data);
    }

    TableResult<CsIndexReport> r = new TableResult<>(pageInfo);
    return r;
  }

  /**
   * 拷贝除了List<T> list的PageInfo对象的所有字段。
   *
   * @param pageInfo 被拷贝的PageInfo对象
   * @param pageInfoCpoy 接受拷贝值的PageInfo对象。 注意：本方法不会拷贝list！ 注意空值检查！
   */
  public static void copyPageInfo(PageInfo pageInfoCpoy, PageInfo pageInfo) {
    if (null != pageInfo && null != pageInfoCpoy) {
      pageInfoCpoy.setTotal(pageInfo.getTotal());
      pageInfoCpoy.setPageNum(pageInfo.getPageNum());
      pageInfoCpoy.setPageSize(pageInfo.getPageSize());
      pageInfoCpoy.setSize(pageInfo.getSize());
      pageInfoCpoy.setStartRow(pageInfo.getStartRow());
      pageInfoCpoy.setEndRow(pageInfo.getEndRow());
      pageInfoCpoy.setHasNextPage(pageInfo.isHasNextPage());
      pageInfoCpoy.setHasPreviousPage(pageInfo.isHasPreviousPage());
      pageInfoCpoy.setIsFirstPage(pageInfo.isIsFirstPage());
      pageInfoCpoy.setIsLastPage(pageInfo.isIsLastPage());
      pageInfoCpoy.setNavigateFirstPage(pageInfo.getNavigateFirstPage());
      pageInfoCpoy.setNavigateLastPage(pageInfo.getNavigateLastPage());
      pageInfoCpoy.setNavigatepageNums(pageInfo.getNavigatepageNums());
      pageInfoCpoy.setNavigatePages(pageInfo.getNavigatePages());
      pageInfoCpoy.setNextPage(pageInfo.getNextPage());
      pageInfoCpoy.setPages(pageInfo.getPages());
      pageInfoCpoy.setPrePage(pageInfo.getPrePage());
      pageInfoCpoy.setFirstPage(pageInfo.getFirstPage());
      pageInfoCpoy.setLastPage(pageInfo.getLastPage());
    }

  }

  /**
   * 转换两个同名类的方法
   *
   * @param csIndexReport 此参数来自于quota项目 的com.ccclubs.quota.orm.model包 它是被转换的对象
   * @param csIndexReportCopy 此参数来自于本项目 他是最后接受转换值的对象。 注意：区分两个形参的类型，注意空值检查！
   */
  public static void dealCsIndexReportFromQuotaToThis(CsIndexReport csIndexReportCopy,
      com.ccclubs.quota.orm.model.CsIndexReport csIndexReport) {
    if (null != csIndexReportCopy && null != csIndexReport) {
      //csIndexReportCopy.setid();
      if (null != csIndexReport.getAvgDriveTimePerDay()) {
        csIndexReportCopy
            .setAvgDriveTimePerDay(csIndexReport.getAvgDriveTimePerDay().doubleValue());
      }
      //csIndexReportCopy.setcreateTime();
      csIndexReportCopy.setCsNumber(csIndexReport.getCsNumber());
      csIndexReportCopy.setCsVin(csIndexReport.getCsVin());
      if (null != csIndexReport.getCumulativeCharge()) {
        csIndexReportCopy.setCumulativeCharge(csIndexReport.getCumulativeCharge().doubleValue());
      }
      if (null != csIndexReport.getCumulativeMileage()) {
        csIndexReportCopy.setCumulativeMileage(csIndexReport.getCumulativeMileage().doubleValue());
      }
      csIndexReportCopy.setDataType(csIndexReport.getDataType());
      if (null != csIndexReport.getElectricRange()) {
        csIndexReportCopy.setElectricRange(csIndexReport.getElectricRange().doubleValue());
      }
      //System.out.println("时间是"+DateTimeUtil.getDateByTimestemp(csIndexReport.getFacTime(),DateTimeUtil.FORMAT5));
      if (null != csIndexReport.getFacTime()) {
        csIndexReportCopy.setFacTime(DateTimeUtil.getDateByTimestemp(csIndexReport.getFacTime()));
      }
      if (null != csIndexReport.getMaxChargePower()) {
        csIndexReportCopy.setMaxChargePower(csIndexReport.getMaxChargePower().doubleValue());
      }
      if (null != csIndexReport.getMinChargeTime()) {
        csIndexReportCopy.setMinChargeTime(csIndexReport.getMinChargeTime().doubleValue());
      }
      if (null != csIndexReport.getModifyDate()) {
        csIndexReportCopy
            .setModifyDate(DateTimeUtil.getDateByTimestemp(csIndexReport.getModifyDate()));
      }
      if (null != csIndexReport.getMonthlyAvgMile()) {
        csIndexReportCopy.setMonthlyAvgMile(csIndexReport.getMonthlyAvgMile().doubleValue());
      }
      if (null != csIndexReport.getPowerConsumePerHundred()) {
        csIndexReportCopy
            .setPowerConsumePerHundred(csIndexReport.getPowerConsumePerHundred().doubleValue());
      }
    }
  }


  /**
   * 注册属性内容解析器
   */
  public static void registResolvers(CsIndexReport data) {
    if (data != null) {
      data.registResolver(CsIndexReportResolver.车辆VIN码.getResolver());
      data.registResolver(CsIndexReportResolver.车机号.getResolver());
      data.registResolver(CsIndexReportResolver.数据类型.getResolver());
    }
  }

  @RequestMapping(value = "/report", method = RequestMethod.POST)
  public VoResult<String> report(@RequestBody ReportParam<CsIndexReportQuery> reportParam) {

    CsIndexReportInput csIndexReportInput = new CsIndexReportInput();
    if (null != reportParam.getQuery()) {
      csIndexReportInput.setCsNumber(reportParam.getQuery().getCsNumberEquals());
      csIndexReportInput.setCsVin(reportParam.getQuery().getCsVinEquals());
    }
    csIndexReportInput.setPageNum(reportParam.getPage());
    csIndexReportInput.setPageSize(reportParam.getRows());

    String uuid = UUID.randomUUID().toString();
    CsIndexReportThread csIndexReportThread = CsIndexReportThread.getFromApplication();
    csIndexReportThread.setAllReport(reportParam.getAllReport() == 1);
    csIndexReportThread.setCsIndexReportInput(csIndexReportInput);
    csIndexReportThread.setUserUuid(uuid);
    HashMap<String, String> headMap = new HashMap<>();
    for (ReportModel reportModel : reportParam.getClms()) {
      headMap.put(reportModel.getField(), reportModel.getTitle());
    }
    csIndexReportThread.setHeadMap(headMap);
    logger.info("start running report CsIndexReport thread.");
    EvManageContext.getThreadPool().execute(csIndexReportThread);

    VoResult<String> r = new VoResult<>();
    r.setSuccess(true).setMessage("导出任务已经开始执行，请稍候。");
    r.setValue(uuid);
    return r;

  }


}
