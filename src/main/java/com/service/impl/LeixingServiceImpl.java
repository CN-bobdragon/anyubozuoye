package com.service.impl;

import com.dao.*;
import com.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.*;
import com.util.ExampleBuilder;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LeixingServiceImpl
 * @Description 类型模块业务实现层
 */
@Service
public class LeixingServiceImpl implements LeixingService {

    @Autowired
    private LeixingMapper leixingMapper;



    //保存或更新类型表leixing
    @Override
    public Integer saveOrUpdate(Leixing instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            leixingMapper.updateByPrimaryKeySelective(instance);
        }else {
            leixingMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询类型表leixing
    @Override
    public List<Leixing> findAll() {
        List<Leixing> list = leixingMapper.selectByExample(null);
        for (Leixing info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询类型表leixing
    @Override
    public List<Leixing> find(Leixing instance) {
        LeixingExample leixingExample = getLeixingExampleByLike(instance);
        leixingExample.setOrderByClause(" id desc");
        List<Leixing> list = leixingMapper.selectByExample(leixingExample);
        for (Leixing info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询类型表leixing
    @Override
    public List<Leixing> findByEqualTo(Leixing instance) {
        LeixingExample leixingExample = getLeixingExampleByEqualTo(instance);
        leixingExample.setOrderByClause(" id desc");
        List<Leixing> list = leixingMapper.selectByExample(leixingExample);
        for (Leixing info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询类型表leixing最后一条数据
    @Override
    public Leixing findOne(Leixing instance) {
        List<Leixing> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询类型表leixing最后一条数据
    @Override
    public Leixing findOneByEqualTo(Leixing instance) {
        List<Leixing> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询类型表leixing数据
    @Override
    public Leixing findById(Integer id) {
        Leixing info = leixingMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除类型表leixing数据
    @Override
    public int deleteById(Integer id) {
        return leixingMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询类型表leixing数据
    @Override
    public PageData<Leixing> findPage(PageWrap<Leixing> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        LeixingExample leixingExample = getLeixingExampleByLike(pageWrap.getModel());
        leixingExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Leixing> list = leixingMapper.selectByExample(leixingExample);
        for (Leixing info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询类型表leixing数据
    @Override
    public PageData<Leixing> findPageByEqualTo(PageWrap<Leixing> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        LeixingExample leixingExample = getLeixingExampleByEqualTo(pageWrap.getModel());
        leixingExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Leixing> list = leixingMapper.selectByExample(leixingExample);
        for (Leixing info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //按字段分组统计类型表count
    @Override
    public List<Map<String, Object>> selectCountGroup(Map<String, Object> params) {
        return leixingMapper.selectCountGroup(params);
    }

    //按字段分组求和类型表sum
    @Override
    public List<Map<String, Object>> selectSumGroup(Map<String, Object> params) {
        return leixingMapper.selectSumGroup(params);
    }

    //按日期或时间统计类型表count
    @Override
    public List<Map<String, Object>> selectCountGroupByDate(Map<String, Object> params) {
        return leixingMapper.selectCountGroupByDate(params);
    }

    //按日期或时间求和类型表sum
    @Override
    public List<Map<String, Object>> selectSumGroupByDate(Map<String, Object> params) {
        return leixingMapper.selectSumGroupByDate(params);
    }

    //关联父表按父表列统计类型表count
    @Override
    public List<Map<String, Object>> selectCountGroupByFatherId(Map<String, Object> params) {
        return leixingMapper.selectCountGroupByFatherId(params);
    }

    //关联父表按父表列求和类型表sum
    @Override
    public List<Map<String, Object>> selectSumGroupByFatherId(Map<String, Object> params) {
        return leixingMapper.selectSumGroupByFatherId(params);
    }

    //父表信息
    private void setFatherInfo(Leixing info){
        if (null != info){

        }
    }

    //字符类型模糊查询条件构造器
    private LeixingExample getLeixingExampleByLike(Leixing instance) {
        LeixingExample leixingExample = new LeixingExample();
        LeixingExample.Criteria criteria = leixingExample.createCriteria();
        //类型id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //名称mingcheng模糊匹配
        if (null != instance.getMingcheng() && !instance.getMingcheng().equals("")) {
            criteria.andMingchengLike("%" + instance.getMingcheng() + "%");
        }

        return leixingExample;
    }

    //字符类型完全相等查询条件构造器
    private LeixingExample getLeixingExampleByEqualTo(Leixing instance) {
        LeixingExample leixingExample = new LeixingExample();
        LeixingExample.Criteria criteria = leixingExample.createCriteria();
        //类型id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //名称mingcheng完全匹配
        if (null != instance.getMingcheng() && !instance.getMingcheng().equals("")) {
            criteria.andMingchengEqualTo(instance.getMingcheng());
        }

        return leixingExample;
    }
}
