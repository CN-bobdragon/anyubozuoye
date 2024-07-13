package com.dao;

import com.entity.Leixing;
import com.entity.LeixingExample;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LeixingMapper
 * @Description 类型模块数据持久层
 */
public interface LeixingMapper {

    //根据条件获取类型表leixing的数据数量
    int countByExample(LeixingExample example);

    //根据条件删除类型表leixing的数据
    int deleteByExample(LeixingExample example);

    //根据主键ID列删除类型表leixing的数据
    int deleteByPrimaryKey(Integer id);

    //插入类型表leixing的实体数据（包含null值）
    int insert(Leixing record);

    //插入类型表leixing的实体数据（不包含null值）
    int insertSelective(Leixing record);

    //根据条件获取类型表leixing的数据列表
    List<Leixing> selectByExample(LeixingExample example);

    //根据主键ID列获取类型表leixing的数据实体
    Leixing selectByPrimaryKey(Integer id);

    //根据条件更新类型表leixing的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Leixing record, @Param("example") LeixingExample example);

    //根据条件更新类型表leixing的实体数据（包含null值）
    int updateByExample(@Param("record") Leixing record, @Param("example") LeixingExample example);

    //根据主键ID列更新类型表leixing的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Leixing record);

    //根据主键ID列更新类型表leixing的实体数据（包含null值）
    int updateByPrimaryKey(Leixing record);

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
