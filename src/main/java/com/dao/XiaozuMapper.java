package com.dao;

import com.entity.Xiaozu;
import com.entity.XiaozuExample;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * @ClassName XiaozuMapper
 * @Description 小组模块数据持久层
 */
public interface XiaozuMapper {

    //根据条件获取小组表xiaozu的数据数量
    int countByExample(XiaozuExample example);

    //根据条件删除小组表xiaozu的数据
    int deleteByExample(XiaozuExample example);

    //根据主键ID列删除小组表xiaozu的数据
    int deleteByPrimaryKey(Integer id);

    //插入小组表xiaozu的实体数据（包含null值）
    int insert(Xiaozu record);

    //插入小组表xiaozu的实体数据（不包含null值）
    int insertSelective(Xiaozu record);

    //根据条件获取小组表xiaozu的数据列表
    List<Xiaozu> selectByExample(XiaozuExample example);

    //根据主键ID列获取小组表xiaozu的数据实体
    Xiaozu selectByPrimaryKey(Integer id);

    //根据条件更新小组表xiaozu的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Xiaozu record, @Param("example") XiaozuExample example);

    //根据条件更新小组表xiaozu的实体数据（包含null值）
    int updateByExample(@Param("record") Xiaozu record, @Param("example") XiaozuExample example);

    //根据主键ID列更新小组表xiaozu的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Xiaozu record);

    //根据主键ID列更新小组表xiaozu的实体数据（包含null值）
    int updateByPrimaryKey(Xiaozu record);

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
