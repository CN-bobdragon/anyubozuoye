package com.service;

import com.entity.Lunbo;
import com.util.PageData;
import com.util.PageWrap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LunboService
 * @Description 轮播图模块业务层
 */
public interface LunboService {

    //保存或更新轮播图表数据
    Integer saveOrUpdate(Lunbo instance);

    //查询所有轮播图表数据
    List<Lunbo> findAll();

    //根据条件(字符类型模糊)查询轮播图表数据
    List<Lunbo> find(Lunbo instance);

    //根据条件(字符类型完全匹配)查询轮播图表数据
    List<Lunbo> findByEqualTo(Lunbo instance);

    //根据条件(字符类型模糊)查询查询第一条轮播图表数据
    Lunbo findOne(Lunbo instance);

    //根据条件(字符类型完全匹配)查询查询第一条轮播图表数据
    Lunbo findOneByEqualTo(Lunbo instance);

    //根据id列查询轮播图表数据
    Lunbo findById(Integer id);

    //根据id列删除轮播图表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询轮播图表数据
    PageData<Lunbo> findPage(PageWrap<Lunbo> pageWrap);

    //根据条件(字符类型完全匹配)分页查询轮播图表数据
    PageData<Lunbo> findPageByEqualTo(PageWrap<Lunbo> pageWrap);

    //按字段分组统计轮播图表count
    List<Map<String, Object>> selectCountGroup(Map<String, Object> params);

    //按字段分组求和轮播图表sum
    List<Map<String, Object>> selectSumGroup(Map<String, Object> params);

    //按日期或时间统计轮播图表count
    List<Map<String, Object>> selectCountGroupByDate(Map<String, Object> params);

    //按日期或时间求和轮播图表sum
    List<Map<String, Object>> selectSumGroupByDate(Map<String, Object> params);

    //关联父表按父表列统计轮播图表count
    List<Map<String, Object>> selectCountGroupByFatherId(Map<String, Object> params);

    //关联父表按父表列求和轮播图表sum
    List<Map<String, Object>> selectSumGroupByFatherId(Map<String, Object> params);
}
