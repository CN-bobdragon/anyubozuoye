package com.dao;

import com.entity.Users;
import com.entity.UsersExample;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UsersMapper
 * @Description 用户模块数据持久层
 */
public interface UsersMapper {

    //根据条件获取用户表users的数据数量
    int countByExample(UsersExample example);

    //根据条件删除用户表users的数据
    int deleteByExample(UsersExample example);

    //根据主键ID列删除用户表users的数据
    int deleteByPrimaryKey(Integer id);

    //插入用户表users的实体数据（包含null值）
    int insert(Users record);

    //插入用户表users的实体数据（不包含null值）
    int insertSelective(Users record);

    //根据条件获取用户表users的数据列表
    List<Users> selectByExample(UsersExample example);

    //根据主键ID列获取用户表users的数据实体
    Users selectByPrimaryKey(Integer id);

    //根据条件更新用户表users的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    //根据条件更新用户表users的实体数据（包含null值）
    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    //根据主键ID列更新用户表users的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Users record);

    //根据主键ID列更新用户表users的实体数据（包含null值）
    int updateByPrimaryKey(Users record);

    //按字段分组统计数量count
    List<Map<String, Object>> selectCountGroup(Map<String, Object> params);

    //按字段分组求和sum
    List<Map<String, Object>> selectSumGroup(Map<String, Object> params);

    //按日期或时间统计数量count
    List<Map<String, Object>> selectCountGroupByDate(Map<String, Object> params);

    //按日期或时间求和sum
    List<Map<String, Object>> selectSumGroupByDate(Map<String, Object> params);

    //关联父表按父表列统计数量count
    List<Map<String, Object>> selectCountGroupByFatherId(Map<String, Object> params);

    //关联父表按父表列求和sum
    List<Map<String, Object>> selectSumGroupByFatherId(Map<String, Object> params);
}
