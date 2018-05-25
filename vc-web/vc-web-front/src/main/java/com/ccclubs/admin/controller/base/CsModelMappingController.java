package com.ccclubs.admin.controller.base;

import com.ccclubs.admin.entity.CsModelMappingCrieria;
import com.ccclubs.admin.model.CsModelMapping;
import com.ccclubs.admin.query.CsModelMappingQuery;
import com.ccclubs.admin.service.ICsModelMappingService;
import com.ccclubs.admin.vo.TableResult;
import com.ccclubs.admin.vo.VoResult;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 主机厂用户车型管理Controller
 *
 * @author
 * @category generated by NovaV1.0
 * @since V1.0
 */
@RestController
@RequestMapping("/auth/modelMapping")
public class CsModelMappingController {

    @Autowired
    ICsModelMappingService csModelMappingService;

    /**
     * 获取分页列表数据
     *
     * @param query
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public TableResult<CsModelMapping> list(CsModelMappingQuery query, @RequestParam(defaultValue = "0") Integer page,
                                            @RequestParam(defaultValue = "10") Integer rows) {
        PageInfo<CsModelMapping> pageInfo = csModelMappingService.getPage(query.getCrieria(), page, rows);
        List<CsModelMapping> list = pageInfo.getList();
        for (CsModelMapping data : list) {
            registResolvers(data);
        }

        TableResult<CsModelMapping> r = new TableResult<>(pageInfo);
        return r;
    }

    /**
     * 创建保存主机厂用户车型管理
     *
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public VoResult<?> add(CsModelMapping data) {
        if (null == data.getAddTime()) {
            data.setAddTime(new Date());
        }
        if (null == data.getUpdateTime()) {
            data.setUpdateTime(new Date());
        }
        csModelMappingService.insert(data);
        return VoResult.success();
    }

    /**
     * 更新主机厂用户车型管理
     *
     * @param data
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public VoResult<?> update(CsModelMapping data) {
        if (null == data.getUpdateTime()) {
            data.setUpdateTime(new Date());
        }
        csModelMappingService.updateByPrimaryKeySelective(data);
        return VoResult.success();
    }

    /**
     * 删除主机厂用户车型管理
     *
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public VoResult<?> delete(@RequestParam(required = true) final Long[] ids) {
        csModelMappingService.batchDelete(ids);
        return VoResult.success();
    }

    /**
     * 注册属性内容解析器
     */
    void registResolvers(CsModelMapping data) {
        if (data != null) {
            data.registResolver(com.ccclubs.admin.resolver.CsModelMappingResolver.主机厂用户.getResolver());
            data.registResolver(com.ccclubs.admin.resolver.CsModelMappingResolver.车型.getResolver());
        }
    }

    /**
     * 获取单条主机厂用户车型管理信息
     */
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public VoResult<Map<String, CsModelMapping>> detail(@PathVariable(required = true) Long id) {
        CsModelMapping data = csModelMappingService.selectByPrimaryKey(id.intValue());
        Map<String, CsModelMapping> map = new HashMap<String, CsModelMapping>();
        registResolvers(data);
        map.put("tbody", data);
        return VoResult.success().setValue(map);
    }


    /**
     * 根据文本检索主机厂用户车型管理信息
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public VoResult<Map<String, List<Map<String, Object>>>> query(String text, String where, CsModelMapping queryRecord) {
        CsModelMappingCrieria query = new CsModelMappingCrieria();
        CsModelMappingCrieria.Criteria c = query.createCriteria();
        if (!StringUtils.isEmpty(text)) {
            Integer val = Integer.valueOf(text);
            c.andidEqualTo(val);
        }
        if (!StringUtils.isEmpty(where)) {
            Integer val = Integer.valueOf(where);
            c.andidEqualTo(val);
        }
        PageInfo<CsModelMapping> pageInfo = csModelMappingService.getPage(query, 0, 10);
        List<CsModelMapping> list = pageInfo.getList();

        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>(list.size());
        Map<String, Object> map;
        for (CsModelMapping data : list) {
            map = new HashMap<String, Object>();
            map.put("value", data.getid());
            map.put("text", data.getid());
            mapList.add(map);
        }
        return VoResult.success().setValue(mapList);
    }

}
