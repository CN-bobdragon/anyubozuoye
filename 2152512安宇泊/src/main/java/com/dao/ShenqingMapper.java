package com.dao;

import com.entity.Shenqing;
import com.entity.ShenqingExample;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ShenqingMapper
 * @Description 申请模块数据持久层
 */
public interface ShenqingMapper {

    //根据条件获取申请表shenqing的数据数量
    int countByExample(ShenqingExample example);

    //根据条件删除申请表shenqing的数据
    int deleteByExample(ShenqingExample example);

    //根据主键ID列删除申请表shenqing的数据
    int deleteByPrimaryKey(Integer id);

    //插入申请表shenqing的实体数据（包含null值）
    int insert(Shenqing record);

    //插入申请表shenqing的实体数据（不包含null值）
    int insertSelective(Shenqing record);

    //根据条件获取申请表shenqing的数据列表
    List<Shenqing> selectByExample(ShenqingExample example);

    //根据主键ID列获取申请表shenqing的数据实体
    Shenqing selectByPrimaryKey(Integer id);

    //根据条件更新申请表shenqing的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Shenqing record, @Param("example") ShenqingExample example);

    //根据条件更新申请表shenqing的实体数据（包含null值）
    int updateByExample(@Param("record") Shenqing record, @Param("example") ShenqingExample example);

    //根据主键ID列更新申请表shenqing的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Shenqing record);

    //根据主键ID列更新申请表shenqing的实体数据（包含null值）
    int updateByPrimaryKey(Shenqing record);

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
