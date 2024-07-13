package com.service;

import com.entity.Dx;
import com.util.PageData;
import com.util.PageWrap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName DxService
 * @Description 介绍模块业务层
 */
public interface DxService {

    //保存或更新介绍表数据
    Integer saveOrUpdate(Dx instance);

    //查询所有介绍表数据
    List<Dx> findAll();

    //根据条件(字符类型模糊)查询介绍表数据
    List<Dx> find(Dx instance);

    //根据条件(字符类型完全匹配)查询介绍表数据
    List<Dx> findByEqualTo(Dx instance);

    //根据条件(字符类型模糊)查询查询第一条介绍表数据
    Dx findOne(Dx instance);

    //根据条件(字符类型完全匹配)查询查询第一条介绍表数据
    Dx findOneByEqualTo(Dx instance);

    //根据id列查询介绍表数据
    Dx findById(Integer id);

    //根据id列删除介绍表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询介绍表数据
    PageData<Dx> findPage(PageWrap<Dx> pageWrap);

    //根据条件(字符类型完全匹配)分页查询介绍表数据
    PageData<Dx> findPageByEqualTo(PageWrap<Dx> pageWrap);

    //按字段分组统计介绍表count
    List<Map<String, Object>> selectCountGroup(Map<String, Object> params);

    //按字段分组求和介绍表sum
    List<Map<String, Object>> selectSumGroup(Map<String, Object> params);

    //按日期或时间统计介绍表count
    List<Map<String, Object>> selectCountGroupByDate(Map<String, Object> params);

    //按日期或时间求和介绍表sum
    List<Map<String, Object>> selectSumGroupByDate(Map<String, Object> params);

    //关联父表按父表列统计介绍表count
    List<Map<String, Object>> selectCountGroupByFatherId(Map<String, Object> params);

    //关联父表按父表列求和介绍表sum
    List<Map<String, Object>> selectSumGroupByFatherId(Map<String, Object> params);
}
