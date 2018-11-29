package com.ccclubs.admin.controller.gb;

import com.ccclubs.admin.entity.VerUpgradeCrieria;
import com.ccclubs.admin.model.VerUpgrade;
import com.ccclubs.admin.query.VerUpgradeQuery;
import com.ccclubs.admin.service.IVerUpgradeService;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.admin.vo.VoResult;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 升级版本管理Controller
 * @category generated by NovaV1.0
 * 
 * @author 
 * @since V1.0
 */
@RestController
@RequestMapping("/version/upgrade")
public class VerUpgradeController {

	@Autowired
	IVerUpgradeService verUpgradeService;

	/**
	 * 获取分页列表数据
	 * @param query
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public TableResult<VerUpgrade> list(VerUpgradeQuery query, @RequestParam(defaultValue = "0") Integer page,
                                        @RequestParam(defaultValue = "10") Integer rows) {
		PageInfo<VerUpgrade> pageInfo = verUpgradeService.getPage(query.getCrieria(), page, rows);
		List<VerUpgrade> list = pageInfo.getList();
		for(VerUpgrade data : list){
			registResolvers(data);
		}
		
		TableResult<VerUpgrade> r = new TableResult<>(pageInfo);
		return r;
	}

	/**
	 * 创建保存升级版本管理
	 * @return
	 */
	@RequestMapping(value="/add", method = RequestMethod.POST)
	public VoResult<?> add(VerUpgrade data){
		verUpgradeService.insert(data);
		return VoResult.success();
	}
	
	/**
	 * 更新升级版本管理
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public VoResult<?> update(VerUpgrade data){
		verUpgradeService.updateByPrimaryKeySelective(data);
		return VoResult.success();
	}
	
	/**
	 * 删除升级版本管理
	 * @return
	 */
	@RequestMapping(value="delete", method = RequestMethod.DELETE)
	public VoResult<?> delete(@RequestParam(required=true)final Integer[] ids){
		verUpgradeService.batchDelete(ids);
		return VoResult.success();
	}
	
	/**
	 * 注册属性内容解析器
	 */
	void registResolvers(VerUpgrade data){
		if(data!=null){
			data.registResolver(com.ccclubs.admin.resolver.VerUpgradeResolver.软件版本号.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.VerUpgradeResolver.硬件版本号.getResolver());
            data.registResolver(com.ccclubs.admin.resolver.VerUpgradeResolver.蓝牙版本.getResolver());
            data.registResolver(com.ccclubs.admin.resolver.VerUpgradeResolver.主版本.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.VerUpgradeResolver.车型.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.VerUpgradeResolver.终端类型.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.VerUpgradeResolver.是否对外开放.getResolver());
            data.registResolver(com.ccclubs.admin.resolver.VerUpgradeResolver.是否为拐点版本.getResolver());
			data.registResolver(com.ccclubs.admin.resolver.VerUpgradeResolver.文件服务器名称.getResolver());
		}
	}
	
	/**
	 * 获取单条升级版本管理信息
	 */
	@RequestMapping(value="/detail/{id}", method = RequestMethod.GET)
	public VoResult<Map<String, VerUpgrade>> detail(@PathVariable(required = true) Integer id){
		VerUpgrade data = verUpgradeService.selectByPrimaryKey( id.intValue());
		Map<String, VerUpgrade> map = new HashMap<String, VerUpgrade>();
		registResolvers(data);
		map.put("tbody", data);
		return VoResult.success().setValue(map);
	}
	
	
	/**
	 * 根据文本检索升级版本管理信息
	 */
	@RequestMapping(value="/query", method = RequestMethod.GET)
	public VoResult<Map<String, List<Map<String, Object>>>> query(String text , String where , VerUpgrade queryRecord){
		VerUpgradeCrieria query = new VerUpgradeCrieria();
		VerUpgradeCrieria.Criteria c = query.createCriteria();
		if(!StringUtils.isEmpty(text)){
			Integer val = Integer.valueOf(text);
			c.andidEqualTo(val);
		}
		if(!StringUtils.isEmpty(where)){
			Integer val = Integer.valueOf(where);
			c.andidEqualTo(val);
		}
		PageInfo<VerUpgrade> pageInfo = verUpgradeService.getPage(query, 0, 10);
		List<VerUpgrade> list = pageInfo.getList();

		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>(list.size());
		Map<String, Object> map ;
		for (VerUpgrade data : list) {
			map = new HashMap<String, Object>();
			map.put("value", data.getid());
//			map.put("text", data.getid());

            // 2018-4-20 加入描述 andaren
            map.put("text", data.getid() + "(" + data.getUpVerNo() + ")");
			mapList.add(map);
		}
		return VoResult.success().setValue(mapList);
	}
	
}
