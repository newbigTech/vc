package com.ccclubs.admin.controller.gb;

import com.ccclubs.admin.entity.VerModuleRelationCrieria;
import com.ccclubs.admin.model.VerModule;
import com.ccclubs.admin.model.VerModuleRelation;
import com.ccclubs.admin.query.VerModuleRelationQuery;
import com.ccclubs.admin.service.IVerModuleRelationService;
import com.ccclubs.admin.service.IVerModuleService;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.admin.vo.VoResult;
import com.ccclubs.admin.vo.version.VerModuleRelationVo;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 版本模块关系Controller
 * @category generated by NovaV1.0
 * 
 * @author 
 * @since V1.0
 */
@RestController
@RequestMapping("/version/vermodule")
public class VerModuleRelationController {

	@Autowired
	IVerModuleRelationService verModuleRelationService;

	@Autowired
	private IVerModuleService verModuleService;

	/**
	 * 获取分页列表数据
	 * @param query
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public TableResult<VerModuleRelation> list(VerModuleRelationQuery query, @RequestParam(defaultValue = "0") Integer page,
                                               @RequestParam(defaultValue = "10") Integer rows) {
		PageInfo<VerModuleRelation> pageInfo = verModuleRelationService.getPage(query.getCrieria(), page, rows);
		List<VerModuleRelation> list = pageInfo.getList();
		for(VerModuleRelation data : list){
			registResolvers(data);
		}
		
		TableResult<VerModuleRelation> r = new TableResult<>(pageInfo);
		return r;
	}

	/**
	 * 获取版本号对应的模块列表
	 * @param verId
	 * @return
	 */
	@GetMapping("/{verId}/details")
	public VoResult<?> relationList(@PathVariable("verId") Integer verId) {
		if(null == verId || verId == 0) {
			return VoResult.error("20010",String.format("请求参数存在空"));
		}
		List<VerModuleRelationVo> relationVos = verModuleRelationService.selectRelationsByVerId(verId);
		return VoResult.success().setValue(relationVos);
	}

	/**
	 * 创建保存版本模块关系
	 * @return
	 */
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public VoResult<?> add(@RequestBody() List<VerModuleRelation> relationList){
		//---------------
		if (null == relationList ||
				0  == relationList.size()) {
			return VoResult.error("20010",String.format("请求参数存在空"));
		}
		verModuleRelationService.insertRelationByList(relationList);
		return VoResult.success();
	}
	
	/**
	 * 更新版本模块关系
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public VoResult<?> update(@RequestBody List<VerModuleRelation> data){
		if (data != null && data.size() > 0) {
			Integer verId = data.get(0).getVerId();
			if (verId == null || verId == 0) {
				return VoResult.error("20010", String.format("版本ID为空"));
			}
			verModuleRelationService.updateByList(data);
		}
		return VoResult.success();
	}
	
	/**
	 * 删除版本模块关系
	 * @return
	 */
	@RequestMapping(value="delete", method = RequestMethod.DELETE)
	public VoResult<?> delete(@RequestParam(required=true)final Integer[] ids){
		verModuleRelationService.batchDelete(ids);
		return VoResult.success();
	}
	
	/**
	 * 注册属性内容解析器
	 */
	void registResolvers(VerModuleRelation data){
		if(data!=null){
			data.registResolver(com.ccclubs.admin.resolver.VerModuleRelationResolver.是否支持.getResolver());
		}
	}
	
	/**
	 * 获取单条版本模块关系信息
	 */
	@RequestMapping(value="/detail/{id}", method = RequestMethod.GET)
	public VoResult<Map<String, VerModuleRelation>> detail(@PathVariable(required = true) Integer id){
		VerModuleRelation data = verModuleRelationService.selectByPrimaryKey( id.intValue());
		Map<String, VerModuleRelation> map = new HashMap<String, VerModuleRelation>();
		registResolvers(data);
		map.put("tbody", data);
		return VoResult.success().setValue(map);
	}
	
	
	/**
	 * 根据文本检索版本模块关系信息
	 */
	@RequestMapping(value="/query", method = RequestMethod.GET)
	public VoResult<Map<String, List<Map<String, Object>>>> query(String text , String where , VerModuleRelation queryRecord){
		VerModuleRelationCrieria query = new VerModuleRelationCrieria();
		VerModuleRelationCrieria.Criteria c = query.createCriteria();
		if(!StringUtils.isEmpty(text)){
			Integer val = Integer.valueOf(text);
			c.andidEqualTo(val);
		}
		if(!StringUtils.isEmpty(where)){
			Integer val = Integer.valueOf(where);
			c.andidEqualTo(val);
		}
		PageInfo<VerModuleRelation> pageInfo = verModuleRelationService.getPage(query, 0, 10);
		List<VerModuleRelation> list = pageInfo.getList();

		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>(list.size());
		Map<String, Object> map ;
		for (VerModuleRelation data : list) {
			map = new HashMap<String, Object>();
			map.put("value", data.getid());
			map.put("text", data.getid());
			mapList.add(map);
		}
		return VoResult.success().setValue(mapList);
	}

	/**
	 * 根据类型提供模块列表
	 * @param type
	 * @return
	 */
	@GetMapping("/modules/{type}")
	public VoResult<List<VerModule>> queryVerModule(@PathVariable("type")String type) {
		VerModule moduleQuery = new VerModule();
		moduleQuery.settype(Short.parseShort(type));
		List<VerModule> modules = verModuleService.select(moduleQuery);
		// 排序
		modules.stream().sorted(Comparator.comparing(VerModule::getsort));
		return VoResult.success().setValue(modules);
	}
	
}