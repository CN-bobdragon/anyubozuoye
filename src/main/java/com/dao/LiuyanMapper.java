package com.dao;

import com.entity.Liuyan;
import com.entity.LiuyanExample;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LiuyanMapper
 * @Description 留言咨询模块数据持久层
 */
public interface LiuyanMapper {

    //根据条件获取留言咨询表liuyan的数据数量
    int countByExample(LiuyanExample example);

    //根据条件删除留言咨询表liuyan的数据
    int deleteByExample(LiuyanExample example);

    //根据主键ID列删除留言咨询表liuyan的数据
    int deleteByPrimaryKey(Integer id);

    //插入留言咨询表liuyan的实体数据（包含null值）
    int insert(Liuyan record);

    //插入留言咨询表liuyan的实体数据（不包含null值）
    int insertSelective(Liuyan record);

    //根据条件获取留言咨询表liuyan的数据列表
    List<Liuyan> selectByExample(LiuyanExample example);

    //根据主键ID列获取留言咨询表liuyan的数据实体
    Liuyan selectByPrimaryKey(Integer id);

    //根据条件更新留言咨询表liuyan的实体数据（不包含null值）
    int updateByExampleSelective(@Param("record") Liuyan record, @Param("example") LiuyanExample example);

    //根据条件更新留言咨询表liuyan的实体数据（包含null值）
    int updateByExample(@Param("record") Liuyan record, @Param("example") LiuyanExample example);

    //根据主键ID列更新留言咨询表liuyan的实体数据（不包含null值）
    int updateByPrimaryKeySelective(Liuyan record);

    //根据主键ID列更新留言咨询表liuyan的实体数据（包含null值）
    int updateByPrimaryKey(Liuyan record);

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
