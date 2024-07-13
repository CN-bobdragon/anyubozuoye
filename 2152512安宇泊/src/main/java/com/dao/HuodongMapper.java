package com.dao;

import com.entity.Huodong;
import com.entity.HuodongExample;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HuodongMapper
 * @Description 活动模块数据持久层
 */
public interface HuodongMapper {

    //根据条件获取活动表huodong的数据数量
    int countByExample(HuodongExample example);

    //根据条件删除活动表huodong的数据
    int deleteByExample(HuodongExample example);

    //根据主键ID列删除活动表huodong的数据
    int deleteByPrimaryKey(Integer id);

    //插入活动表huodong的实体数据（包含null值）
    int insert(Huodong record);

    //插入活动表huodong的实体数据（不包含null值）
    int insertSelective(Huodong record);

    //根据条件获取活动表huodong的数据列表
    List<Huodong> selectByExample(HuodongExample example);

    //根据主键ID列获取活动表huodong的数据实体
    Huodong selectByPrimaryKey(Integer id);

    //根据条件更新活动表huodong的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Huodong record, @Param("example") HuodongExample example);

    //根据条件更新活动表huodong的实体数据（包含null值）
    int updateByExample(@Param("record") Huodong record, @Param("example") HuodongExample example);

    //根据主键ID列更新活动表huodong的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Huodong record);

    //根据主键ID列更新活动表huodong的实体数据（包含null值）
    int updateByPrimaryKey(Huodong record);

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
