package com.dao;

import com.entity.Banji;
import com.entity.BanjiExample;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BanjiMapper
 * @Description 班级模块数据持久层
 */
public interface BanjiMapper {

    //根据条件获取班级表banji的数据数量
    int countByExample(BanjiExample example);

    //根据条件删除班级表banji的数据
    int deleteByExample(BanjiExample example);

    //根据主键ID列删除班级表banji的数据
    int deleteByPrimaryKey(Integer id);

    //插入班级表banji的实体数据（包含null值）
    int insert(Banji record);

    //插入班级表banji的实体数据（不包含null值）
    int insertSelective(Banji record);

    //根据条件获取班级表banji的数据列表
    List<Banji> selectByExample(BanjiExample example);

    //根据主键ID列获取班级表banji的数据实体
    Banji selectByPrimaryKey(Integer id);

    //根据条件更新班级表banji的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Banji record, @Param("example") BanjiExample example);

    //根据条件更新班级表banji的实体数据（包含null值）
    int updateByExample(@Param("record") Banji record, @Param("example") BanjiExample example);

    //根据主键ID列更新班级表banji的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Banji record);

    //根据主键ID列更新班级表banji的实体数据（包含null值）
    int updateByPrimaryKey(Banji record);

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
