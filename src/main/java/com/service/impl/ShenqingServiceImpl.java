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
 * @ClassName ShenqingServiceImpl
 * @Description 申请模块业务实现层
 */
@Service
public class ShenqingServiceImpl implements ShenqingService {

    @Autowired
    private ShenqingMapper shenqingMapper;

    @Autowired
    private XiaozuMapper xiaozuMapper;
    @Autowired
    private UsersMapper usersMapper;


    //保存或更新申请表shenqing
    @Override
    public Integer saveOrUpdate(Shenqing instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            shenqingMapper.updateByPrimaryKeySelective(instance);
        }else {
            shenqingMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询申请表shenqing
    @Override
    public List<Shenqing> findAll() {
        List<Shenqing> list = shenqingMapper.selectByExample(null);
        for (Shenqing info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询申请表shenqing
    @Override
    public List<Shenqing> find(Shenqing instance) {
        ShenqingExample shenqingExample = getShenqingExampleByLike(instance);
        shenqingExample.setOrderByClause(" id desc");
        List<Shenqing> list = shenqingMapper.selectByExample(shenqingExample);
        for (Shenqing info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询申请表shenqing
    @Override
    public List<Shenqing> findByEqualTo(Shenqing instance) {
        ShenqingExample shenqingExample = getShenqingExampleByEqualTo(instance);
        shenqingExample.setOrderByClause(" id desc");
        List<Shenqing> list = shenqingMapper.selectByExample(shenqingExample);
        for (Shenqing info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询申请表shenqing最后一条数据
    @Override
    public Shenqing findOne(Shenqing instance) {
        List<Shenqing> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询申请表shenqing最后一条数据
    @Override
    public Shenqing findOneByEqualTo(Shenqing instance) {
        List<Shenqing> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询申请表shenqing数据
    @Override
    public Shenqing findById(Integer id) {
        Shenqing info = shenqingMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除申请表shenqing数据
    @Override
    public int deleteById(Integer id) {
        return shenqingMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询申请表shenqing数据
    @Override
    public PageData<Shenqing> findPage(PageWrap<Shenqing> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        ShenqingExample shenqingExample = getShenqingExampleByLike(pageWrap.getModel());
        shenqingExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Shenqing> list = shenqingMapper.selectByExample(shenqingExample);
        for (Shenqing info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询申请表shenqing数据
    @Override
    public PageData<Shenqing> findPageByEqualTo(PageWrap<Shenqing> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        ShenqingExample shenqingExample = getShenqingExampleByEqualTo(pageWrap.getModel());
        shenqingExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Shenqing> list = shenqingMapper.selectByExample(shenqingExample);
        for (Shenqing info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //按字段分组统计申请表count
    @Override
    public List<Map<String, Object>> selectCountGroup(Map<String, Object> params) {
        return shenqingMapper.selectCountGroup(params);
    }

    //按字段分组求和申请表sum
    @Override
    public List<Map<String, Object>> selectSumGroup(Map<String, Object> params) {
        return shenqingMapper.selectSumGroup(params);
    }

    //按日期或时间统计申请表count
    @Override
    public List<Map<String, Object>> selectCountGroupByDate(Map<String, Object> params) {
        return shenqingMapper.selectCountGroupByDate(params);
    }

    //按日期或时间求和申请表sum
    @Override
    public List<Map<String, Object>> selectSumGroupByDate(Map<String, Object> params) {
        return shenqingMapper.selectSumGroupByDate(params);
    }

    //关联父表按父表列统计申请表count
    @Override
    public List<Map<String, Object>> selectCountGroupByFatherId(Map<String, Object> params) {
        return shenqingMapper.selectCountGroupByFatherId(params);
    }

    //关联父表按父表列求和申请表sum
    @Override
    public List<Map<String, Object>> selectSumGroupByFatherId(Map<String, Object> params) {
        return shenqingMapper.selectSumGroupByFatherId(params);
    }

    //父表信息
    private void setFatherInfo(Shenqing info){
        if (null != info){
            Xiaozu xiaozu= xiaozuMapper.selectByPrimaryKey(info.getXiaozuid());
            info.setXiaozu(xiaozu);
            Users users= usersMapper.selectByPrimaryKey(info.getUsersid());
            info.setUsers(users);

        }
    }

    //字符类型模糊查询条件构造器
    private ShenqingExample getShenqingExampleByLike(Shenqing instance) {
        ShenqingExample shenqingExample = new ShenqingExample();
        ShenqingExample.Criteria criteria = shenqingExample.createCriteria();
        //申请id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //小组idxiaozuid完全匹配
        if (null != instance.getXiaozuid()) {
            criteria.andXiaozuidEqualTo(instance.getXiaozuid());
        }
        //内容neirong模糊匹配
        if (null != instance.getNeirong() && !instance.getNeirong().equals("")) {
            criteria.andNeirongLike("%" + instance.getNeirong() + "%");
        }
        //用户idusersid完全匹配
        if (null != instance.getUsersid()) {
            criteria.andUsersidEqualTo(instance.getUsersid());
        }
        //申请shenhe模糊匹配
        if (null != instance.getShenhe() && !instance.getShenhe().equals("")) {
            criteria.andShenheLike("%" + instance.getShenhe() + "%");
        }

        return shenqingExample;
    }

    //字符类型完全相等查询条件构造器
    private ShenqingExample getShenqingExampleByEqualTo(Shenqing instance) {
        ShenqingExample shenqingExample = new ShenqingExample();
        ShenqingExample.Criteria criteria = shenqingExample.createCriteria();
        //申请id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //小组idxiaozuid完全匹配
        if (null != instance.getXiaozuid()) {
            criteria.andXiaozuidEqualTo(instance.getXiaozuid());
        }
        //内容neirong完全匹配
        if (null != instance.getNeirong() && !instance.getNeirong().equals("")) {
            criteria.andNeirongEqualTo(instance.getNeirong());
        }
        //用户idusersid完全匹配
        if (null != instance.getUsersid()) {
            criteria.andUsersidEqualTo(instance.getUsersid());
        }
        //申请shenhe完全匹配
        if (null != instance.getShenhe() && !instance.getShenhe().equals("")) {
            criteria.andShenheEqualTo(instance.getShenhe());
        }

        return shenqingExample;
    }
}
