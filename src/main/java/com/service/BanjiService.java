package com.service;

import com.entity.Banji;
import com.util.PageData;
import com.util.PageWrap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BanjiService
 * @Description 班级模块业务层
 */
public interface BanjiService {

    //保存或更新班级表数据
    Integer saveOrUpdate(Banji instance);

    //查询所有班级表数据
    List<Banji> findAll();

    //根据条件(字符类型模糊)查询班级表数据
    List<Banji> find(Banji instance);

    //根据条件(字符类型完全匹配)查询班级表数据
    List<Banji> findByEqualTo(Banji instance);

    //根据条件(字符类型模糊)查询查询第一条班级表数据
    Banji findOne(Banji instance);

    //根据条件(字符类型完全匹配)查询查询第一条班级表数据
    Banji findOneByEqualTo(Banji instance);

    //根据id列查询班级表数据
    Banji findById(Integer id);

    //根据id列删除班级表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询班级表数据
    PageData<Banji> findPage(PageWrap<Banji> pageWrap);

    //根据条件(字符类型完全匹配)分页查询班级表数据
    PageData<Banji> findPageByEqualTo(PageWrap<Banji> pageWrap);

    //按字段分组统计班级表count
    List<Map<String, Object>> selectCountGroup(Map<String, Object> params);

    //按字段分组求和班级表sum
    List<Map<String, Object>> selectSumGroup(Map<String, Object> params);

    //按日期或时间统计班级表count
    List<Map<String, Object>> selectCountGroupByDate(Map<String, Object> params);

    //按日期或时间求和班级表sum
    List<Map<String, Object>> selectSumGroupByDate(Map<String, Object> params);

    //关联父表按父表列统计班级表count
    List<Map<String, Object>> selectCountGroupByFatherId(Map<String, Object> params);

    //关联父表按父表列求和班级表sum
    List<Map<String, Object>> selectSumGroupByFatherId(Map<String, Object> params);
}
