package com.service;

import com.entity.Shenqing;
import com.util.PageData;
import com.util.PageWrap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ShenqingService
 * @Description 申请模块业务层
 */
public interface ShenqingService {

    //保存或更新申请表数据
    Integer saveOrUpdate(Shenqing instance);

    //查询所有申请表数据
    List<Shenqing> findAll();

    //根据条件(字符类型模糊)查询申请表数据
    List<Shenqing> find(Shenqing instance);

    //根据条件(字符类型完全匹配)查询申请表数据
    List<Shenqing> findByEqualTo(Shenqing instance);

    //根据条件(字符类型模糊)查询查询第一条申请表数据
    Shenqing findOne(Shenqing instance);

    //根据条件(字符类型完全匹配)查询查询第一条申请表数据
    Shenqing findOneByEqualTo(Shenqing instance);

    //根据id列查询申请表数据
    Shenqing findById(Integer id);

    //根据id列删除申请表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询申请表数据
    PageData<Shenqing> findPage(PageWrap<Shenqing> pageWrap);

    //根据条件(字符类型完全匹配)分页查询申请表数据
    PageData<Shenqing> findPageByEqualTo(PageWrap<Shenqing> pageWrap);

    //按字段分组统计申请表count
    List<Map<String, Object>> selectCountGroup(Map<String, Object> params);

    //按字段分组求和申请表sum
    List<Map<String, Object>> selectSumGroup(Map<String, Object> params);

    //按日期或时间统计申请表count
    List<Map<String, Object>> selectCountGroupByDate(Map<String, Object> params);

    //按日期或时间求和申请表sum
    List<Map<String, Object>> selectSumGroupByDate(Map<String, Object> params);

    //关联父表按父表列统计申请表count
    List<Map<String, Object>> selectCountGroupByFatherId(Map<String, Object> params);

    //关联父表按父表列求和申请表sum
    List<Map<String, Object>> selectSumGroupByFatherId(Map<String, Object> params);
}
