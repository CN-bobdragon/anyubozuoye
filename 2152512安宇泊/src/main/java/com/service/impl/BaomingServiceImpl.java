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
 * @ClassName BaomingServiceImpl
 * @Description 报名模块业务实现层
 */
@Service
public class BaomingServiceImpl implements BaomingService {

    @Autowired
    private BaomingMapper baomingMapper;

    @Autowired
    private HuodongMapper huodongMapper;
    @Autowired
    private UsersMapper usersMapper;


    //保存或更新报名表baoming
    @Override
    public Integer saveOrUpdate(Baoming instance) {
        if(null != instance.getId() && instance.getId() > 0) {
            baomingMapper.updateByPrimaryKeySelective(instance);
        }else {
            baomingMapper.insertSelective(instance);
        }
        return instance.getId();
    }

    //查询报名表baoming
    @Override
    public List<Baoming> findAll() {
        List<Baoming> list = baomingMapper.selectByExample(null);
        for (Baoming info:list) {
            setFatherInfo(info);
        }
        return list;
    }

    //根据条件(字符类型模糊匹配)查询报名表baoming
    @Override
    public List<Baoming> find(Baoming instance) {
        BaomingExample baomingExample = getBaomingExampleByLike(instance);
        baomingExample.setOrderByClause(" id desc");
        List<Baoming> list = baomingMapper.selectByExample(baomingExample);
        for (Baoming info:list) {
            setFatherInfo(info);
        }
        return list;
     }

    //根据条件(字符类型完全匹配)查询报名表baoming
    @Override
    public List<Baoming> findByEqualTo(Baoming instance) {
        BaomingExample baomingExample = getBaomingExampleByEqualTo(instance);
        baomingExample.setOrderByClause(" id desc");
        List<Baoming> list = baomingMapper.selectByExample(baomingExample);
        for (Baoming info:list) {
            setFatherInfo(info);
        }
        return list;
    }


    //根据条件(字符类型模糊匹配)查询报名表baoming最后一条数据
    @Override
    public Baoming findOne(Baoming instance) {
        List<Baoming> list = find(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据条件(字符类型完全匹配)查询报名表baoming最后一条数据
    @Override
    public Baoming findOneByEqualTo(Baoming instance) {
        List<Baoming> list = findByEqualTo(instance);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    //根据id列查询报名表baoming数据
    @Override
    public Baoming findById(Integer id) {
        Baoming info = baomingMapper.selectByPrimaryKey(id);
        setFatherInfo(info);
        return info;
    }

    //根据主键id列删除报名表baoming数据
    @Override
    public int deleteById(Integer id) {
        return baomingMapper.deleteByPrimaryKey(id);
    }


    //根据条件(字符类型模糊匹配)分页查询报名表baoming数据
    @Override
    public PageData<Baoming> findPage(PageWrap<Baoming> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        BaomingExample baomingExample = getBaomingExampleByLike(pageWrap.getModel());
        baomingExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Baoming> list = baomingMapper.selectByExample(baomingExample);
        for (Baoming info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //根据条件(字符类型完全匹配)分页查询报名表baoming数据
    @Override
    public PageData<Baoming> findPageByEqualTo(PageWrap<Baoming> pageWrap) {
        PageHelper.startPage(pageWrap.getPageNum(), pageWrap.getPageSize());
        BaomingExample baomingExample = getBaomingExampleByEqualTo(pageWrap.getModel());
        baomingExample.setOrderByClause(pageWrap.getOrderByClause());
        List<Baoming> list = baomingMapper.selectByExample(baomingExample);
        for (Baoming info:list) {
            setFatherInfo(info);
        }
        return PageData.from(new PageInfo<>(list));
    }

    //按字段分组统计报名表count
    @Override
    public List<Map<String, Object>> selectCountGroup(Map<String, Object> params) {
        return baomingMapper.selectCountGroup(params);
    }

    //按字段分组求和报名表sum
    @Override
    public List<Map<String, Object>> selectSumGroup(Map<String, Object> params) {
        return baomingMapper.selectSumGroup(params);
    }

    //按日期或时间统计报名表count
    @Override
    public List<Map<String, Object>> selectCountGroupByDate(Map<String, Object> params) {
        return baomingMapper.selectCountGroupByDate(params);
    }

    //按日期或时间求和报名表sum
    @Override
    public List<Map<String, Object>> selectSumGroupByDate(Map<String, Object> params) {
        return baomingMapper.selectSumGroupByDate(params);
    }

    //关联父表按父表列统计报名表count
    @Override
    public List<Map<String, Object>> selectCountGroupByFatherId(Map<String, Object> params) {
        return baomingMapper.selectCountGroupByFatherId(params);
    }

    //关联父表按父表列求和报名表sum
    @Override
    public List<Map<String, Object>> selectSumGroupByFatherId(Map<String, Object> params) {
        return baomingMapper.selectSumGroupByFatherId(params);
    }

    //父表信息
    private void setFatherInfo(Baoming info){
        if (null != info){
            Huodong huodong= huodongMapper.selectByPrimaryKey(info.getHuodongid());
            info.setHuodong(huodong);
            Users users= usersMapper.selectByPrimaryKey(info.getUsersid());
            info.setUsers(users);

        }
    }

    //字符类型模糊查询条件构造器
    private BaomingExample getBaomingExampleByLike(Baoming instance) {
        BaomingExample baomingExample = new BaomingExample();
        BaomingExample.Criteria criteria = baomingExample.createCriteria();
        //报名id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //活动idhuodongid完全匹配
        if (null != instance.getHuodongid()) {
            criteria.andHuodongidEqualTo(instance.getHuodongid());
        }
        //申请原因nerong模糊匹配
        if (null != instance.getNerong() && !instance.getNerong().equals("")) {
            criteria.andNerongLike("%" + instance.getNerong() + "%");
        }
        //时间shijian模糊匹配
        if (null != instance.getShijian() && !instance.getShijian().equals("")) {
            criteria.andShijianLike("%" + instance.getShijian() + "%");
        }
        //用户idusersid完全匹配
        if (null != instance.getUsersid()) {
            criteria.andUsersidEqualTo(instance.getUsersid());
        }

        return baomingExample;
    }

    //字符类型完全相等查询条件构造器
    private BaomingExample getBaomingExampleByEqualTo(Baoming instance) {
        BaomingExample baomingExample = new BaomingExample();
        BaomingExample.Criteria criteria = baomingExample.createCriteria();
        //报名id完全匹配
        if (null != instance.getId()) {
            criteria.andIdEqualTo(instance.getId());
        }
        //活动idhuodongid完全匹配
        if (null != instance.getHuodongid()) {
            criteria.andHuodongidEqualTo(instance.getHuodongid());
        }
        //申请原因nerong完全匹配
        if (null != instance.getNerong() && !instance.getNerong().equals("")) {
            criteria.andNerongEqualTo(instance.getNerong());
        }
        //时间shijian完全匹配
        if (null != instance.getShijian() && !instance.getShijian().equals("")) {
            criteria.andShijianEqualTo(instance.getShijian());
        }
        //用户idusersid完全匹配
        if (null != instance.getUsersid()) {
            criteria.andUsersidEqualTo(instance.getUsersid());
        }

        return baomingExample;
    }
}
