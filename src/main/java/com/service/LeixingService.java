package com.service;

import com.entity.Leixing;
import com.util.PageData;
import com.util.PageWrap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LeixingService
 * @Description 类型模块业务层
 */
public interface LeixingService {

    //保存或更新类型表数据
    Integer saveOrUpdate(Leixing instance);

    //查询所有类型表数据
    List<Leixing> findAll();

    //根据条件(字符类型模糊)查询类型表数据
    List<Leixing> find(Leixing instance);

    //根据条件(字符类型完全匹配)查询类型表数据
    List<Leixing> findByEqualTo(Leixing instance);

    //根据条件(字符类型模糊)查询查询第一条类型表数据
    Leixing findOne(Leixing instance);

    //根据条件(字符类型完全匹配)查询查询第一条类型表数据
    Leixing findOneByEqualTo(Leixing instance);

    //根据id列查询类型表数据
    Leixing findById(Integer id);

    //根据id列删除类型表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询类型表数据
    PageData<Leixing> findPage(PageWrap<Leixing> pageWrap);

    //根据条件(字符类型完全匹配)分页查询类型表数据
    PageData<Leixing> findPageByEqualTo(PageWrap<Leixing> pageWrap);

    //按字段分组统计类型表count
    List<Map<String, Object>> selectCountGroup(Map<String, Object> params);

    //按字段分组求和类型表sum
    List<Map<String, Object>> selectSumGroup(Map<String, Object> params);

    //按日期或时间统计类型表count
    List<Map<String, Object>> selectCountGroupByDate(Map<String, Object> params);

    //按日期或时间求和类型表sum
    List<Map<String, Object>> selectSumGroupByDate(Map<String, Object> params);

    //关联父表按父表列统计类型表count
    List<Map<String, Object>> selectCountGroupByFatherId(Map<String, Object> params);

    //关联父表按父表列求和类型表sum
    List<Map<String, Object>> selectSumGroupByFatherId(Map<String, Object> params);
}
