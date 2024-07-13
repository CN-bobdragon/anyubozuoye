package com.service;

import com.entity.Liuyan;
import com.util.PageData;
import com.util.PageWrap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LiuyanService
 * @Description 留言咨询模块业务层
 */
public interface LiuyanService {

    //保存或更新留言咨询表数据
    Integer saveOrUpdate(Liuyan instance);

    //查询所有留言咨询表数据
    List<Liuyan> findAll();

    //根据条件(字符类型模糊)查询留言咨询表数据
    List<Liuyan> find(Liuyan instance);

    //根据条件(字符类型完全匹配)查询留言咨询表数据
    List<Liuyan> findByEqualTo(Liuyan instance);

    //根据条件(字符类型模糊)查询查询第一条留言咨询表数据
    Liuyan findOne(Liuyan instance);

    //根据条件(字符类型完全匹配)查询查询第一条留言咨询表数据
    Liuyan findOneByEqualTo(Liuyan instance);

    //根据id列查询留言咨询表数据
    Liuyan findById(Integer id);

    //根据id列删除留言咨询表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询留言咨询表数据
    PageData<Liuyan> findPage(PageWrap<Liuyan> pageWrap);

    //根据条件(字符类型完全匹配)分页查询留言咨询表数据
    PageData<Liuyan> findPageByEqualTo(PageWrap<Liuyan> pageWrap);

    //按字段分组统计留言咨询表count
    List<Map<String, Object>> selectCountGroup(Map<String, Object> params);

    //按字段分组求和留言咨询表sum
    List<Map<String, Object>> selectSumGroup(Map<String, Object> params);

    //按日期或时间统计留言咨询表count
    List<Map<String, Object>> selectCountGroupByDate(Map<String, Object> params);

    //按日期或时间求和留言咨询表sum
    List<Map<String, Object>> selectSumGroupByDate(Map<String, Object> params);

    //关联父表按父表列统计留言咨询表count
    List<Map<String, Object>> selectCountGroupByFatherId(Map<String, Object> params);

    //关联父表按父表列求和留言咨询表sum
    List<Map<String, Object>> selectSumGroupByFatherId(Map<String, Object> params);
}
