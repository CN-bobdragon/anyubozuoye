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
 * @ClassName LunboServiceImpl
 * @Description 轮播图模块业务实现层
 */
@Service
public class LunboServiceImpl implements LunboService {

    @Autowired
    private LunboMapper lunboMapper;



    //保存或更新轮播图表lunbo
    @Override
    public Integer saveOrUpdate(Lunbo instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            lunboMapper.updateByPrimaryKeySelective(instance);
        }else {
            lunboMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询轮播图表lunbo
    @Override
    public List<Lunbo> findAll() {
        List<Lunbo> list = lunboMapper.selectByExample(null);
        for (Lunbo info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询轮播图表lunbo
    @Override
    public List<Lunbo> find(Lunbo instance) {
        LunboExample lunboExample = getLunboExampleByLike(instance);
        lunboExample.setOrderByClause(" id desc");
        List<Lunbo> list = lunboMapper.selectByExample(lunboExample);
        for (Lunbo info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询轮播图表lunbo
    @Override
    public List<Lunbo> findByEqualTo(Lunbo instance) {
        LunboExample lunboExample = getLunboExampleByEqualTo(instance);
        lunboExample.setOrderByClause(" id desc");
        List<Lunbo> list = lunboMapper.selectByExample(lunboExample);
        for (Lunbo info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询轮播图表lunbo最后一条数据
    @Override
    public Lunbo findOne(Lunbo instance) {
        List<Lunbo> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询轮播图表lunbo最后一条数据
    @Override
    public Lunbo findOneByEqualTo(Lunbo instance) {
        List<Lunbo> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询轮播图表lunbo数据
    @Override
    public Lunbo findById(Integer id) {
        Lunbo info = lunboMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除轮播图表lunbo数据
    @Override
    public int deleteById(Integer id) {
        return lunboMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询轮播图表lunbo数据
    @Override
    public PageData<Lunbo> findPage(PageWrap<Lunbo> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        LunboExample lunboExample = getLunboExampleByLike(pageWrap.getModel());
        lunboExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Lunbo> list = lunboMapper.selectByExample(lunboExample);
        for (Lunbo info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询轮播图表lunbo数据
    @Override
    public PageData<Lunbo> findPageByEqualTo(PageWrap<Lunbo> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        LunboExample lunboExample = getLunboExampleByEqualTo(pageWrap.getModel());
        lunboExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Lunbo> list = lunboMapper.selectByExample(lunboExample);
        for (Lunbo info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //按字段分组统计轮播图表count
    @Override
    public List<Map<String, Object>> selectCountGroup(Map<String, Object> params) {
        return lunboMapper.selectCountGroup(params);
    }

    //按字段分组求和轮播图表sum
    @Override
    public List<Map<String, Object>> selectSumGroup(Map<String, Object> params) {
        return lunboMapper.selectSumGroup(params);
    }

    //按日期或时间统计轮播图表count
    @Override
    public List<Map<String, Object>> selectCountGroupByDate(Map<String, Object> params) {
        return lunboMapper.selectCountGroupByDate(params);
    }

    //按日期或时间求和轮播图表sum
    @Override
    public List<Map<String, Object>> selectSumGroupByDate(Map<String, Object> params) {
        return lunboMapper.selectSumGroupByDate(params);
    }

    //关联父表按父表列统计轮播图表count
    @Override
    public List<Map<String, Object>> selectCountGroupByFatherId(Map<String, Object> params) {
        return lunboMapper.selectCountGroupByFatherId(params);
    }

    //关联父表按父表列求和轮播图表sum
    @Override
    public List<Map<String, Object>> selectSumGroupByFatherId(Map<String, Object> params) {
        return lunboMapper.selectSumGroupByFatherId(params);
    }

    //父表信息
    private void setFatherInfo(Lunbo info){
        if (null != info){

        }
    }

    //字符类型模糊查询条件构造器
    private LunboExample getLunboExampleByLike(Lunbo instance) {
        LunboExample lunboExample = new LunboExample();
        LunboExample.Criteria criteria = lunboExample.createCriteria();
        //轮播图id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //标题biaoti模糊匹配
        if (null != instance.getBiaoti() && !instance.getBiaoti().equals("")) {
            criteria.andBiaotiLike("%" + instance.getBiaoti() + "%");
        }
        //图片image模糊匹配
        if (null != instance.getImage() && !instance.getImage().equals("")) {
            criteria.andImageLike("%" + instance.getImage() + "%");
        }

        return lunboExample;
    }

    //字符类型完全相等查询条件构造器
    private LunboExample getLunboExampleByEqualTo(Lunbo instance) {
        LunboExample lunboExample = new LunboExample();
        LunboExample.Criteria criteria = lunboExample.createCriteria();
        //轮播图id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //标题biaoti完全匹配
        if (null != instance.getBiaoti() && !instance.getBiaoti().equals("")) {
            criteria.andBiaotiEqualTo(instance.getBiaoti());
        }
        //图片image完全匹配
        if (null != instance.getImage() && !instance.getImage().equals("")) {
            criteria.andImageEqualTo(instance.getImage());
        }

        return lunboExample;
    }
}
