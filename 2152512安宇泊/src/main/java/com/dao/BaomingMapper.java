package com.dao;

import com.entity.Baoming;
import com.entity.BaomingExample;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BaomingMapper
 * @Description 报名模块数据持久层
 */
public interface BaomingMapper {

    //根据条件获取报名表baoming的数据数量
    int countByExample(BaomingExample example);

    //根据条件删除报名表baoming的数据
    int deleteByExample(BaomingExample example);

    //根据主键ID列删除报名表baoming的数据
    int deleteByPrimaryKey(Integer id);

    //插入报名表baoming的实体数据（包含null值）
    int insert(Baoming record);

    //插入报名表baoming的实体数据（不包含null值）
    int insertSelective(Baoming record);

    //根据条件获取报名表baoming的数据列表
    List<Baoming> selectByExample(BaomingExample example);

    //根据主键ID列获取报名表baoming的数据实体
    Baoming selectByPrimaryKey(Integer id);

    //根据条件更新报名表baoming的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Baoming record, @Param("example") BaomingExample example);

    //根据条件更新报名表baoming的实体数据（包含null值）
    int updateByExample(@Param("record") Baoming record, @Param("example") BaomingExample example);

    //根据主键ID列更新报名表baoming的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Baoming record);

    //根据主键ID列更新报名表baoming的实体数据（包含null值）
    int updateByPrimaryKey(Baoming record);

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
