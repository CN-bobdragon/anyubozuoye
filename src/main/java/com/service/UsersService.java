package com.service;

import com.entity.Users;
import com.util.PageData;
import com.util.PageWrap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UsersService
 * @Description 用户模块业务层
 */
public interface UsersService {

    //保存或更新用户表数据
    Integer saveOrUpdate(Users instance);

    //查询所有用户表数据
    List<Users> findAll();

    //根据条件(字符类型模糊)查询用户表数据
    List<Users> find(Users instance);

    //根据条件(字符类型完全匹配)查询用户表数据
    List<Users> findByEqualTo(Users instance);

    //根据条件(字符类型模糊)查询查询第一条用户表数据
    Users findOne(Users instance);

    //根据条件(字符类型完全匹配)查询查询第一条用户表数据
    Users findOneByEqualTo(Users instance);

    //根据id列查询用户表数据
    Users findById(Integer id);

    //根据id列删除用户表数据
    int deleteById(Integer id);

    //根据条件(字符类型模糊)分页查询用户表数据
    PageData<Users> findPage(PageWrap<Users> pageWrap);

    //根据条件(字符类型完全匹配)分页查询用户表数据
    PageData<Users> findPageByEqualTo(PageWrap<Users> pageWrap);

    //按字段分组统计用户表count
    List<Map<String, Object>> selectCountGroup(Map<String, Object> params);

    //按字段分组求和用户表sum
    List<Map<String, Object>> selectSumGroup(Map<String, Object> params);

    //按日期或时间统计用户表count
    List<Map<String, Object>> selectCountGroupByDate(Map<String, Object> params);

    //按日期或时间求和用户表sum
    List<Map<String, Object>> selectSumGroupByDate(Map<String, Object> params);

    //关联父表按父表列统计用户表count
    List<Map<String, Object>> selectCountGroupByFatherId(Map<String, Object> params);

    //关联父表按父表列求和用户表sum
    List<Map<String, Object>> selectSumGroupByFatherId(Map<String, Object> params);
}
