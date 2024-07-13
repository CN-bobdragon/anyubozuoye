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
 * @ClassName XiaozuServiceImpl
 * @Description 小组模块业务实现层
 */
@Service
public class XiaozuServiceImpl implements XiaozuService {

    @Autowired
    private XiaozuMapper xiaozuMapper;

    @Autowired
    private HuodongMapper huodongMapper;
    @Autowired
    private UsersMapper usersMapper;


    //保存或更新小组表xiaozu
    @Override
    public Integer saveOrUpdate(Xiaozu instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            xiaozuMapper.updateByPrimaryKeySelective(instance);
        }else {
            xiaozuMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询小组表xiaozu
    @Override
    public List<Xiaozu> findAll() {
        List<Xiaozu> list = xiaozuMapper.selectByExample(null);
        for (Xiaozu info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询小组表xiaozu
    @Override
    public List<Xiaozu> find(Xiaozu instance) {
        XiaozuExample xiaozuExample = getXiaozuExampleByLike(instance);
        xiaozuExample.setOrderByClause(" id desc");
        List<Xiaozu> list = xiaozuMapper.selectByExample(xiaozuExample);
        for (Xiaozu info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询小组表xiaozu
    @Override
    public List<Xiaozu> findByEqualTo(Xiaozu instance) {
        XiaozuExample xiaozuExample = getXiaozuExampleByEqualTo(instance);
        xiaozuExample.setOrderByClause(" id desc");
        List<Xiaozu> list = xiaozuMapper.selectByExample(xiaozuExample);
        for (Xiaozu info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询小组表xiaozu最后一条数据
    @Override
    public Xiaozu findOne(Xiaozu instance) {
        List<Xiaozu> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询小组表xiaozu最后一条数据
    @Override
    public Xiaozu findOneByEqualTo(Xiaozu instance) {
        List<Xiaozu> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询小组表xiaozu数据
    @Override
    public Xiaozu findById(Integer id) {
        Xiaozu info = xiaozuMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除小组表xiaozu数据
    @Override
    public int deleteById(Integer id) {
        return xiaozuMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询小组表xiaozu数据
    @Override
    public PageData<Xiaozu> findPage(PageWrap<Xiaozu> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        XiaozuExample xiaozuExample = getXiaozuExampleByLike(pageWrap.getModel());
        xiaozuExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Xiaozu> list = xiaozuMapper.selectByExample(xiaozuExample);
        for (Xiaozu info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询小组表xiaozu数据
    @Override
    public PageData<Xiaozu> findPageByEqualTo(PageWrap<Xiaozu> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        XiaozuExample xiaozuExample = getXiaozuExampleByEqualTo(pageWrap.getModel());
        xiaozuExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Xiaozu> list = xiaozuMapper.selectByExample(xiaozuExample);
        for (Xiaozu info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //按字段分组统计小组表count
    @Override
    public List<Map<String, Object>> selectCountGroup(Map<String, Object> params) {
        return xiaozuMapper.selectCountGroup(params);
    }

    //按字段分组求和小组表sum
    @Override
    public List<Map<String, Object>> selectSumGroup(Map<String, Object> params) {
        return xiaozuMapper.selectSumGroup(params);
    }

    //按日期或时间统计小组表count
    @Override
    public List<Map<String, Object>> selectCountGroupByDate(Map<String, Object> params) {
        return xiaozuMapper.selectCountGroupByDate(params);
    }

    //按日期或时间求和小组表sum
    @Override
    public List<Map<String, Object>> selectSumGroupByDate(Map<String, Object> params) {
        return xiaozuMapper.selectSumGroupByDate(params);
    }

    //关联父表按父表列统计小组表count
    @Override
    public List<Map<String, Object>> selectCountGroupByFatherId(Map<String, Object> params) {
        return xiaozuMapper.selectCountGroupByFatherId(params);
    }

    //关联父表按父表列求和小组表sum
    @Override
    public List<Map<String, Object>> selectSumGroupByFatherId(Map<String, Object> params) {
        return xiaozuMapper.selectSumGroupByFatherId(params);
    }

    //父表信息
    private void setFatherInfo(Xiaozu info){
        if (null != info){
            Huodong huodong= huodongMapper.selectByPrimaryKey(info.getHuodongid());
            info.setHuodong(huodong);
            Users users= usersMapper.selectByPrimaryKey(info.getUsersid());
            info.setUsers(users);

        }
    }

    //字符类型模糊查询条件构造器
    private XiaozuExample getXiaozuExampleByLike(Xiaozu instance) {
        XiaozuExample xiaozuExample = new XiaozuExample();
        XiaozuExample.Criteria criteria = xiaozuExample.createCriteria();
        //小组id完全匹配
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
        //活动idhuodongid完全匹配
        if (null != instance.getHuodongid()) {
            criteria.andHuodongidEqualTo(instance.getHuodongid());
        }
        //小组成绩chengji完全匹配
        if (null != instance.getChengji()) {
            criteria.andChengjiEqualTo(instance.getChengji());
        }
        //用户idusersid完全匹配
        if (null != instance.getUsersid()) {
            criteria.andUsersidEqualTo(instance.getUsersid());
        }

        return xiaozuExample;
    }

    //字符类型完全相等查询条件构造器
    private XiaozuExample getXiaozuExampleByEqualTo(Xiaozu instance) {
        XiaozuExample xiaozuExample = new XiaozuExample();
        XiaozuExample.Criteria criteria = xiaozuExample.createCriteria();
        //小组id完全匹配
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
        //活动idhuodongid完全匹配
        if (null != instance.getHuodongid()) {
            criteria.andHuodongidEqualTo(instance.getHuodongid());
        }
        //小组成绩chengji完全匹配
        if (null != instance.getChengji()) {
            criteria.andChengjiEqualTo(instance.getChengji());
        }
        //用户idusersid完全匹配
        if (null != instance.getUsersid()) {
            criteria.andUsersidEqualTo(instance.getUsersid());
        }

        return xiaozuExample;
    }
}
