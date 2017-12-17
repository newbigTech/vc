package com.ccclubs.admin.controller;

import java.util.*;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccclubs.admin.resolver.CsIndexReportResolver;
import com.ccclubs.frm.spring.entity.DateTimeUtil;
import com.ccclubs.quota.inf.CsIndexQuotaInf;
import com.ccclubs.quota.vo.CsIndexReportInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;

import com.ccclubs.admin.vo.TableResult;

import com.ccclubs.admin.entity.CsIndexReportCrieria;
import com.ccclubs.admin.model.CsIndexReport;
import com.ccclubs.admin.service.ICsIndexReportService;
import com.ccclubs.admin.query.CsIndexReportQuery;
import com.ccclubs.admin.vo.VoResult;
import com.github.pagehelper.PageInfo;

/**
 * 指标统计Controller
 * @category generated by NovaV1.0
 * 
 * @author 
 * @since V1.0
 */
@RestController
@RequestMapping("/monitor/analysis/quota")
public class CsIndexReportController {

	@Autowired
	ICsIndexReportService csIndexReportService;

	@Reference(version="1.0.0")
	private CsIndexQuotaInf csIndexQuotaInf;


	/**
	 * 获取分页列表数据
	 * @param query
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public TableResult<CsIndexReport> list(CsIndexReportQuery query, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		//PageInfo<CsIndexReport> pageInfo = csIndexReportService.getPage(query.getCrieria(), page, rows);
		CsIndexReportInput csIndexReportInput=new CsIndexReportInput();
		csIndexReportInput.setCsNumber(query.getCsNumberEquals());
		csIndexReportInput.setCsVin(query.getCsVinEquals());
		csIndexReportInput.setPageNum(page);
		csIndexReportInput.setPageSize(rows);
		PageInfo<com.ccclubs.quota.orm.model.CsIndexReport> pageInfoFromQuota=csIndexQuotaInf.bizQuota(csIndexReportInput);
		List<com.ccclubs.quota.orm.model.CsIndexReport> csIndexReportFromQuotaList=pageInfoFromQuota.getList();
		PageInfo<CsIndexReport> pageInfo =new PageInfo<>();
		copyPageInfo(pageInfo,pageInfoFromQuota);

		List<CsIndexReport> list = new ArrayList<>();//pageInfo.getList();
		if (null!=csIndexReportFromQuotaList&&csIndexReportFromQuotaList.size()>0){
			for (int i=0;i<csIndexReportFromQuotaList.size();i++) {
				CsIndexReport csIndexReport=new CsIndexReport();
				dealCsIndexReportFromQuotaToThis(csIndexReport,csIndexReportFromQuotaList.get(i));
				list.add(csIndexReport);
			}
		}
		pageInfo.setList(list);
		for(CsIndexReport data : list){
			registResolvers(data);
		}
		
		TableResult<CsIndexReport> r = new TableResult<>(pageInfo);
		return r;
	}

	/**
	 * 拷贝除了List<T> list的PageInfo对象的所有字段。
	 * @param pageInfo 被拷贝的PageInfo对象
	 * @param pageInfoCpoy  接受拷贝值的PageInfo对象。
	 *     注意：本方法不会拷贝list！ 注意空值检查！
	 * */
	private static void copyPageInfo(PageInfo pageInfoCpoy,PageInfo pageInfo){
		if(null!=pageInfo&&null!=pageInfoCpoy){
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
	 * @param csIndexReport   此参数来自于quota项目 的com.ccclubs.quota.orm.model包
	 *                        它是被转换的对象
	 * @param csIndexReportCopy 此参数来自于本项目
	 *                          他是最后接受转换值的对象。
	 *       注意：区分两个形参的类型，注意空值检查！
	 * */
	private static void dealCsIndexReportFromQuotaToThis(CsIndexReport csIndexReportCopy,com.ccclubs.quota.orm.model.CsIndexReport csIndexReport){
		if (null!=csIndexReportCopy&&null!=csIndexReport){
			//csIndexReportCopy.setid();
			csIndexReportCopy.setAvgDriveTimePerDay(csIndexReport.getAvgDriveTimePerDay().doubleValue());
			//csIndexReportCopy.setcreateTime();
			csIndexReportCopy.setCsNumber(csIndexReport.getCsNumber());
			csIndexReportCopy.setCsVin(csIndexReport.getCsVin());
			csIndexReportCopy.setCumulativeCharge(csIndexReport.getCumulativeCharge().doubleValue());
			csIndexReportCopy.setCumulativeMileage(csIndexReport.getCumulativeMileage().doubleValue());
			csIndexReportCopy.setDataType(csIndexReport.getDataType());
			csIndexReportCopy.setElectricRange(csIndexReport.getElectricRange().doubleValue());
			System.out.println("时间是"+DateTimeUtil.getDateByFormat(csIndexReport.getFacTime(),DateTimeUtil.FORMAT5));
			csIndexReportCopy.setFacTime(DateTimeUtil.getDateByFormat(csIndexReport.getFacTime(),DateTimeUtil.FORMAT5));
			csIndexReportCopy.setMaxChargePower(csIndexReport.getMaxChargePower().doubleValue());
			csIndexReportCopy.setMinChargeTime(csIndexReport.getMinChargeTime().doubleValue());

			csIndexReportCopy.setmodifyDate(DateTimeUtil.getDateByFormat(csIndexReport.getModifyDate(),DateTimeUtil.FORMAT5));
			csIndexReportCopy.setMonthlyAvgMile(csIndexReport.getMonthlyAvgMile().doubleValue());
			csIndexReportCopy.setPowerConsumePerHundred(csIndexReport.getPowerConsumePerHundred().doubleValue());
		}
	}
	
	
	
	/**
	 * 注册属性内容解析器
	 */
	void registResolvers(CsIndexReport data){
		if(data!=null){
			data.registResolver(CsIndexReportResolver.车辆VIN码.getResolver());
			data.registResolver(CsIndexReportResolver.车机号.getResolver());
			data.registResolver(CsIndexReportResolver.数据类型.getResolver());
		}
	}
	
	/**
	 * 获取单条指标统计信息
	 */
	/*@RequestMapping(value="/detail/{id}", method = RequestMethod.GET)
	public VoResult<Map<String, CsIndexReport>> detail(@PathVariable(required = true) Long id){
		CsIndexReport data = csIndexReportService.selectByPrimaryKey( id.intValue());
		Map<String, CsIndexReport> map = new HashMap<String, CsIndexReport>();
		registResolvers(data);
		map.put("tbody", data);
		return VoResult.success().setValue(map);
	}*/
	
	
	/**
	 * 根据文本检索指标统计信息
	 */
	/*@RequestMapping(value="/query", method = RequestMethod.GET)
	public VoResult<Map<String, List<Map<String, Object>>>> query(String text , String where , CsIndexReport queryRecord){
		CsIndexReportCrieria query = new CsIndexReportCrieria();
		CsIndexReportCrieria.Criteria c = query.createCriteria();
		if(!StringUtils.isEmpty(text)){
			Long val = Long.valueOf(text);
			c.andidEqualTo(val);
		}
		if(!StringUtils.isEmpty(where)){
			Long val = Long.valueOf(where);
			c.andidEqualTo(val);
		}
		PageInfo<CsIndexReport> pageInfo = csIndexReportService.getPage(query, 0, 10);
		List<CsIndexReport> list = pageInfo.getList();

		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>(list.size());
		Map<String, Object> map ;
		for (CsIndexReport data : list) {
			map = new HashMap<String, Object>();
			map.put("value", data.getid());
			map.put("text", data.getid());
			mapList.add(map);
		}
		return VoResult.success().setValue(mapList);
	}*/
	
}