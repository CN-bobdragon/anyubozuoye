package com.service;

import com.entity.Huodong;
import com.util.PageData;
import com.util.PageWrap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HuodongService
 * @Description 活动模块业务层
 */
public interface HuodongService {

    //保存或更新活动表数据
    Integer saveOrUpdate(Huodong instance);

    //查询所有活动表数据
    List<Huodong> findAll();

    //根据条件(字符类型模糊)查询活动表数据
    List<Huodong> find(Huodong instance);

    //根据条件(字符类型完全匹配)查询活动表数据
    List<Huodong> findByEqualTo(Huodong instance);

    //根据条件(字符类型模糊)查询查询第一条活动表数据
    Huodong findOne(Huodong instance);

    //根据条件(字符类型完全匹配)查询查询第一条活动表数据
    Huodong findOneByEqualTo(Huodong instance);

    //根据id列查询活动表数据
    Huodong findById(Integer id);

    //根据id列删除活动表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询活动表数据
    PageData<Huodong> findPage(PageWrap<Huodong> pageWrap);

    //根据条件(字符类型完全匹配)分页查询活动表数据
    PageData<Huodong> findPageByEqualTo(PageWrap<Huodong> pageWrap);

    //按字段分组统计活动表count
    List<Map<String, Object>> selectCountGroup(Map<String, Object> params);

    //按字段分组求和活动表sum
    List<Map<String, Object>> selectSumGroup(Map<String, Object> params);

    //按日期或时间统计活动表count
    List<Map<String, Object>> selectCountGroupByDate(Map<String, Object> params);

    //按日期或时间求和活动表sum
    List<Map<String, Object>> selectSumGroupByDate(Map<String, Object> params);

    //关联父表按父表列统计活动表count
    List<Map<String, Object>> selectCountGroupByFatherId(Map<String, Object> params);

    //关联父表按父表列求和活动表sum
    List<Map<String, Object>> selectSumGroupByFatherId(Map<String, Object> params);
}
