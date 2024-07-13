package com.service;

import com.entity.Baoming;
import com.util.PageData;
import com.util.PageWrap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BaomingService
 * @Description 报名模块业务层
 */
public interface BaomingService {

    //保存或更新报名表数据
    Integer saveOrUpdate(Baoming instance);

    //查询所有报名表数据
    List<Baoming> findAll();

    //根据条件(字符类型模糊)查询报名表数据
    List<Baoming> find(Baoming instance);

    //根据条件(字符类型完全匹配)查询报名表数据
    List<Baoming> findByEqualTo(Baoming instance);

    //根据条件(字符类型模糊)查询查询第一条报名表数据
    Baoming findOne(Baoming instance);

    //根据条件(字符类型完全匹配)查询查询第一条报名表数据
    Baoming findOneByEqualTo(Baoming instance);

    //根据id列查询报名表数据
    Baoming findById(Integer id);

    //根据id列删除报名表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询报名表数据
    PageData<Baoming> findPage(PageWrap<Baoming> pageWrap);

    //根据条件(字符类型完全匹配)分页查询报名表数据
    PageData<Baoming> findPageByEqualTo(PageWrap<Baoming> pageWrap);

    //按字段分组统计报名表count
    List<Map<String, Object>> selectCountGroup(Map<String, Object> params);

    //按字段分组求和报名表sum
    List<Map<String, Object>> selectSumGroup(Map<String, Object> params);

    //按日期或时间统计报名表count
    List<Map<String, Object>> selectCountGroupByDate(Map<String, Object> params);

    //按日期或时间求和报名表sum
    List<Map<String, Object>> selectSumGroupByDate(Map<String, Object> params);

    //关联父表按父表列统计报名表count
    List<Map<String, Object>> selectCountGroupByFatherId(Map<String, Object> params);

    //关联父表按父表列求和报名表sum
    List<Map<String, Object>> selectSumGroupByFatherId(Map<String, Object> params);
}
