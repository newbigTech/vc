package com.ccclubs.admin.controller.gb;

import com.ccclubs.admin.entity.VerSoftHardwareCrieria;
import com.ccclubs.admin.model.VerModule;
import com.ccclubs.admin.model.VerSoftHardware;
import com.ccclubs.admin.query.VerSoftHardwareQuery;
import com.ccclubs.admin.service.IVerModuleRelationService;
import com.ccclubs.admin.service.IVerModuleService;
import com.ccclubs.admin.service.IVerSoftHardwareService;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.admin.vo.VoResult;
import com.ccclubs.admin.vo.version.VerModuleRelationVo;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 软硬件版本管理Controller
 * @category generated by NovaV1.0
 * 
 * @author 
 * @since V1.0
 */
@RestController
@RequestMapping("/version/softhardware")
public class VerSoftHardwareController {

	@Autowired
	IVerSoftHardwareService verSoftHardwareService;

	@Autowired
	private IVerModuleRelationService verModuleRelationService;

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
	public TableResult<VerSoftHardware> list(VerSoftHardwareQuery query, @RequestParam(defaultValue = "0") Integer page,
                                             @RequestParam(defaultValue = "10") Integer rows) {
		PageInfo<VerSoftHardware> pageInfo = verSoftHardwareService.getPage(query.getCrieria(), page, rows);
		List<VerSoftHardware> list = pageInfo.getList();
		for(VerSoftHardware data : list){
			registResolvers(data);
		}
		
		TableResult<VerSoftHardware> r = new TableResult<>(pageInfo);
		return r;
	}

	/**
	 * 创建保存软硬件版本管理
	 * @return
	 */
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public VoResult<?> add(VerSoftHardware data){
		if (null==data.gettype()||
				null==data.getVerNo()){
			return VoResult.error("20010",String.format("存在不能为空的参数为空值。"));
		}
		// 新增软硬件版本
		verSoftHardwareService.insert(data);
		return VoResult.success();
	}


	
	/**
	 * 更新软硬件版本管理
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public VoResult<?> update(VerSoftHardware data){
		verSoftHardwareService.updateByPrimaryKeySelective(data);
		return VoResult.success();
	}
	
	/**
	 * 删除软硬件版本管理
	 * @return
	 */
	@RequestMapping(value="delete", method = RequestMethod.DELETE)
	public VoResult<?> delete(@RequestParam(required=true)final Integer[] ids){
		// 先删除版本对应的模块映射
		List<Integer> idList = new ArrayList<>();
		for (Integer id: ids) {
			idList.add(id);
		}
		verModuleRelationService.batchDeleteByVerId(idList);
		// 删除软硬件版本
		verSoftHardwareService.batchDelete(ids);
		return VoResult.success();
	}
	
	/**
	 * 注册属性内容解析器
	 */
	void registResolvers(VerSoftHardware data){
		if(data!=null){
			data.registResolver(com.ccclubs.admin.resolver.VerSoftHardwareResolver.版本类型.getResolver());
		}
	}
	
	/**
	 * 获取单条软硬件版本管理信息
	 */
	@RequestMapping(value="/detail/{id}", method = RequestMethod.GET)
	public VoResult<Map<String, VerSoftHardware>> detail(@PathVariable(required = true) Integer id){
		VerSoftHardware data = verSoftHardwareService.selectByPrimaryKey( id);
		Map<String, VerSoftHardware> map = new HashMap<String, VerSoftHardware>();
		registResolvers(data);
		map.put("tbody", data);
		return VoResult.success().setValue(map);
	}
	
	
	/**
	 * 根据文本检索软硬件版本管理信息
	 * type
	 * 		0：硬件版本
	 * 		1：软件版本
	 */
	@RequestMapping(value="/query/{type}", method = RequestMethod.GET)
	public VoResult<Map<String, List<Map<String, Object>>>> query(String text , String where , VerSoftHardware queryRecord,
                                                                  @PathVariable("type")String type){
		VerSoftHardwareCrieria query = new VerSoftHardwareCrieria();
		VerSoftHardwareCrieria.Criteria c = query.createCriteria();
		if(!StringUtils.isEmpty(text)){
			String val = String.valueOf(text);
			c.andverNoLike(val);
		}
		if(!StringUtils.isEmpty(where)){
			Integer val = Integer.valueOf(where);
			c.andidEqualTo(val);
		}
		c.andtypeEqualTo(Short.parseShort(type));
		PageInfo<VerSoftHardware> pageInfo = verSoftHardwareService.getPage(query, 0, 10);
		List<VerSoftHardware> list = pageInfo.getList();

		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>(list.size());
		Map<String, Object> map ;
		for (VerSoftHardware data : list) {
			map = new HashMap<String, Object>();
			map.put("value", data.getid());
			// 将版本号拼装成 版本号（版本描述）的格式展示
			StringBuilder desSb = new StringBuilder();
			desSb.append(data.getVerNo())
					.append("\n（")
					.append(data.getdes())
					.append("）");
			map.put("text", desSb.toString());
			mapList.add(map);
		}
		return VoResult.success().setValue(mapList);
	}

	/**
	 * 绑定模块
	 * @return
	 */
	@GetMapping(value="/bind/{verId}")
	public VoResult<?> getAllModuleTableByType(@PathVariable("verId") int verId){
		VerSoftHardware softHardware = verSoftHardwareService.selectByPrimaryKey(verId);
		if (null == softHardware) {
			return VoResult.error("20010",String.format("请求的‘版本’不存在"));
		}
		// 获取版本号对应的软硬件映射
		List<VerModuleRelationVo> relations = verModuleRelationService.selectRelationsByVerId(verId);
		if (relations.size() == 0) {
			VerModule moduleQuery = new VerModule();
			moduleQuery.settype(softHardware.gettype());
			List<VerModule> modules = verModuleService.select(moduleQuery);
			return VoResult.success().setValue(modules);
		}
		return VoResult.success().setValue(relations);
	}
}
