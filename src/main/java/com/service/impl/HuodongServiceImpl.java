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
 * @ClassName HuodongServiceImpl
 * @Description 活动模块业务实现层
 */
@Service
public class HuodongServiceImpl implements HuodongService {

    @Autowired
    private HuodongMapper huodongMapper;

    @Autowired
    private UsersMapper usersMapper;


    //保存或更新活动表huodong
    @Override
    public Integer saveOrUpdate(Huodong instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            huodongMapper.updateByPrimaryKeySelective(instance);
        }else {
            huodongMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询活动表huodong
    @Override
    public List<Huodong> findAll() {
        List<Huodong> list = huodongMapper.selectByExample(null);
        for (Huodong info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询活动表huodong
    @Override
    public List<Huodong> find(Huodong instance) {
        HuodongExample huodongExample = getHuodongExampleByLike(instance);
        huodongExample.setOrderByClause(" id desc");
        List<Huodong> list = huodongMapper.selectByExample(huodongExample);
        for (Huodong info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询活动表huodong
    @Override
    public List<Huodong> findByEqualTo(Huodong instance) {
        HuodongExample huodongExample = getHuodongExampleByEqualTo(instance);
        huodongExample.setOrderByClause(" id desc");
        List<Huodong> list = huodongMapper.selectByExample(huodongExample);
        for (Huodong info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询活动表huodong最后一条数据
    @Override
    public Huodong findOne(Huodong instance) {
        List<Huodong> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询活动表huodong最后一条数据
    @Override
    public Huodong findOneByEqualTo(Huodong instance) {
        List<Huodong> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询活动表huodong数据
    @Override
    public Huodong findById(Integer id) {
        Huodong info = huodongMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除活动表huodong数据
    @Override
    public int deleteById(Integer id) {
        return huodongMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询活动表huodong数据
    @Override
    public PageData<Huodong> findPage(PageWrap<Huodong> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        HuodongExample huodongExample = getHuodongExampleByLike(pageWrap.getModel());
        huodongExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Huodong> list = huodongMapper.selectByExample(huodongExample);
        for (Huodong info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询活动表huodong数据
    @Override
    public PageData<Huodong> findPageByEqualTo(PageWrap<Huodong> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        HuodongExample huodongExample = getHuodongExampleByEqualTo(pageWrap.getModel());
        huodongExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Huodong> list = huodongMapper.selectByExample(huodongExample);
        for (Huodong info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //按字段分组统计活动表count
    @Override
    public List<Map<String, Object>> selectCountGroup(Map<String, Object> params) {
        return huodongMapper.selectCountGroup(params);
    }

    //按字段分组求和活动表sum
    @Override
    public List<Map<String, Object>> selectSumGroup(Map<String, Object> params) {
        return huodongMapper.selectSumGroup(params);
    }

    //按日期或时间统计活动表count
    @Override
    public List<Map<String, Object>> selectCountGroupByDate(Map<String, Object> params) {
        return huodongMapper.selectCountGroupByDate(params);
    }

    //按日期或时间求和活动表sum
    @Override
    public List<Map<String, Object>> selectSumGroupByDate(Map<String, Object> params) {
        return huodongMapper.selectSumGroupByDate(params);
    }

    //关联父表按父表列统计活动表count
    @Override
    public List<Map<String, Object>> selectCountGroupByFatherId(Map<String, Object> params) {
        return huodongMapper.selectCountGroupByFatherId(params);
    }

    //关联父表按父表列求和活动表sum
    @Override
    public List<Map<String, Object>> selectSumGroupByFatherId(Map<String, Object> params) {
        return huodongMapper.selectSumGroupByFatherId(params);
    }

    //父表信息
    private void setFatherInfo(Huodong info){
        if (null != info){
            Users users= usersMapper.selectByPrimaryKey(info.getUsersid());
            info.setUsers(users);

        }
    }

    //字符类型模糊查询条件构造器
    private HuodongExample getHuodongExampleByLike(Huodong instance) {
        HuodongExample huodongExample = new HuodongExample();
        HuodongExample.Criteria criteria = huodongExample.createCriteria();
        //活动id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //名称mingcheng模糊匹配
        if (null != instance.getMingcheng() && !instance.getMingcheng().equals("")) {
            criteria.andMingchengLike("%" + instance.getMingcheng() + "%");
        }
        //图片tupian模糊匹配
        if (null != instance.getTupian() && !instance.getTupian().equals("")) {
            criteria.andTupianLike("%" + instance.getTupian() + "%");
        }
        //日常内容neirong模糊匹配
        if (null != instance.getNeirong() && !instance.getNeirong().equals("")) {
            criteria.andNeirongLike("%" + instance.getNeirong() + "%");
        }
        //用户idusersid完全匹配
        if (null != instance.getUsersid()) {
            criteria.andUsersidEqualTo(instance.getUsersid());
        }

        return huodongExample;
    }

    //字符类型完全相等查询条件构造器
    private HuodongExample getHuodongExampleByEqualTo(Huodong instance) {
        HuodongExample huodongExample = new HuodongExample();
        HuodongExample.Criteria criteria = huodongExample.createCriteria();
        //活动id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //名称mingcheng完全匹配
        if (null != instance.getMingcheng() && !instance.getMingcheng().equals("")) {
            criteria.andMingchengEqualTo(instance.getMingcheng());
        }
        //图片tupian完全匹配
        if (null != instance.getTupian() && !instance.getTupian().equals("")) {
            criteria.andTupianEqualTo(instance.getTupian());
        }
        //日常内容neirong完全匹配
        if (null != instance.getNeirong() && !instance.getNeirong().equals("")) {
            criteria.andNeirongEqualTo(instance.getNeirong());
        }
        //用户idusersid完全匹配
        if (null != instance.getUsersid()) {
            criteria.andUsersidEqualTo(instance.getUsersid());
        }

        return huodongExample;
    }
}
