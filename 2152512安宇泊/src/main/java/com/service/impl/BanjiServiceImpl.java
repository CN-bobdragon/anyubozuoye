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
 * @ClassName BanjiServiceImpl
 * @Description 班级模块业务实现层
 */
@Service
public class BanjiServiceImpl implements BanjiService {

    @Autowired
    private BanjiMapper banjiMapper;



    //保存或更新班级表banji
    @Override
    public Integer saveOrUpdate(Banji instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            banjiMapper.updateByPrimaryKeySelective(instance);
        }else {
            banjiMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询班级表banji
    @Override
    public List<Banji> findAll() {
        List<Banji> list = banjiMapper.selectByExample(null);
        for (Banji info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询班级表banji
    @Override
    public List<Banji> find(Banji instance) {
        BanjiExample banjiExample = getBanjiExampleByLike(instance);
        banjiExample.setOrderByClause(" id desc");
        List<Banji> list = banjiMapper.selectByExample(banjiExample);
        for (Banji info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询班级表banji
    @Override
    public List<Banji> findByEqualTo(Banji instance) {
        BanjiExample banjiExample = getBanjiExampleByEqualTo(instance);
        banjiExample.setOrderByClause(" id desc");
        List<Banji> list = banjiMapper.selectByExample(banjiExample);
        for (Banji info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询班级表banji最后一条数据
    @Override
    public Banji findOne(Banji instance) {
        List<Banji> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询班级表banji最后一条数据
    @Override
    public Banji findOneByEqualTo(Banji instance) {
        List<Banji> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询班级表banji数据
    @Override
    public Banji findById(Integer id) {
        Banji info = banjiMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除班级表banji数据
    @Override
    public int deleteById(Integer id) {
        return banjiMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询班级表banji数据
    @Override
    public PageData<Banji> findPage(PageWrap<Banji> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        BanjiExample banjiExample = getBanjiExampleByLike(pageWrap.getModel());
        banjiExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Banji> list = banjiMapper.selectByExample(banjiExample);
        for (Banji info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询班级表banji数据
    @Override
    public PageData<Banji> findPageByEqualTo(PageWrap<Banji> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        BanjiExample banjiExample = getBanjiExampleByEqualTo(pageWrap.getModel());
        banjiExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Banji> list = banjiMapper.selectByExample(banjiExample);
        for (Banji info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //按字段分组统计班级表count
    @Override
    public List<Map<String, Object>> selectCountGroup(Map<String, Object> params) {
        return banjiMapper.selectCountGroup(params);
    }

    //按字段分组求和班级表sum
    @Override
    public List<Map<String, Object>> selectSumGroup(Map<String, Object> params) {
        return banjiMapper.selectSumGroup(params);
    }

    //按日期或时间统计班级表count
    @Override
    public List<Map<String, Object>> selectCountGroupByDate(Map<String, Object> params) {
        return banjiMapper.selectCountGroupByDate(params);
    }

    //按日期或时间求和班级表sum
    @Override
    public List<Map<String, Object>> selectSumGroupByDate(Map<String, Object> params) {
        return banjiMapper.selectSumGroupByDate(params);
    }

    //关联父表按父表列统计班级表count
    @Override
    public List<Map<String, Object>> selectCountGroupByFatherId(Map<String, Object> params) {
        return banjiMapper.selectCountGroupByFatherId(params);
    }

    //关联父表按父表列求和班级表sum
    @Override
    public List<Map<String, Object>> selectSumGroupByFatherId(Map<String, Object> params) {
        return banjiMapper.selectSumGroupByFatherId(params);
    }

    //父表信息
    private void setFatherInfo(Banji info){
        if (null != info){

        }
    }

    //字符类型模糊查询条件构造器
    private BanjiExample getBanjiExampleByLike(Banji instance) {
        BanjiExample banjiExample = new BanjiExample();
        BanjiExample.Criteria criteria = banjiExample.createCriteria();
        //班级id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //名称mingcheng模糊匹配
        if (null != instance.getMingcheng() && !instance.getMingcheng().equals("")) {
            criteria.andMingchengLike("%" + instance.getMingcheng() + "%");
        }

        return banjiExample;
    }

    //字符类型完全相等查询条件构造器
    private BanjiExample getBanjiExampleByEqualTo(Banji instance) {
        BanjiExample banjiExample = new BanjiExample();
        BanjiExample.Criteria criteria = banjiExample.createCriteria();
        //班级id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //名称mingcheng完全匹配
        if (null != instance.getMingcheng() && !instance.getMingcheng().equals("")) {
            criteria.andMingchengEqualTo(instance.getMingcheng());
        }

        return banjiExample;
    }
}
