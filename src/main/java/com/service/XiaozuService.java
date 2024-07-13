package com.service;

import com.entity.Xiaozu;
import com.util.PageData;
import com.util.PageWrap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName XiaozuService
 * @Description 小组模块业务层
 */
public interface XiaozuService {

    //保存或更新小组表数据
    Integer saveOrUpdate(Xiaozu instance);

    //查询所有小组表数据
    List<Xiaozu> findAll();

    //根据条件(字符类型模糊)查询小组表数据
    List<Xiaozu> find(Xiaozu instance);

    //根据条件(字符类型完全匹配)查询小组表数据
    List<Xiaozu> findByEqualTo(Xiaozu instance);

    //根据条件(字符类型模糊)查询查询第一条小组表数据
    Xiaozu findOne(Xiaozu instance);

    //根据条件(字符类型完全匹配)查询查询第一条小组表数据
    Xiaozu findOneByEqualTo(Xiaozu instance);

    //根据id列查询小组表数据
    Xiaozu findById(Integer id);

    //根据id列删除小组表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询小组表数据
    PageData<Xiaozu> findPage(PageWrap<Xiaozu> pageWrap);

    //根据条件(字符类型完全匹配)分页查询小组表数据
    PageData<Xiaozu> findPageByEqualTo(PageWrap<Xiaozu> pageWrap);

    //按字段分组统计小组表count
    List<Map<String, Object>> selectCountGroup(Map<String, Object> params);

    //按字段分组求和小组表sum
    List<Map<String, Object>> selectSumGroup(Map<String, Object> params);

    //按日期或时间统计小组表count
    List<Map<String, Object>> selectCountGroupByDate(Map<String, Object> params);

    //按日期或时间求和小组表sum
    List<Map<String, Object>> selectSumGroupByDate(Map<String, Object> params);

    //关联父表按父表列统计小组表count
    List<Map<String, Object>> selectCountGroupByFatherId(Map<String, Object> params);

    //关联父表按父表列求和小组表sum
    List<Map<String, Object>> selectSumGroupByFatherId(Map<String, Object> params);
}
