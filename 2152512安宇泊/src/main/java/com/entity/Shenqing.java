package com.entity;


/**
 * @ClassName Shenqing
 * @Description 申请模块实体层
 */
public class Shenqing {
    //id列
    private Integer id;


    //小组id
    private Integer xiaozuid;
    //内容
    private String neirong;
    //用户id
    private Integer usersid;
    //申请
    private String shenhe;
    //父表：小组表xiaozu
    private Xiaozu xiaozu;
    //父表：用户表users
    private Users users;


    /**
    * 获取 id列
    *
    * @return id id列
    */
    public Integer getId() {
        return this.id;
    }

    /**
    * 设置 id列
    *
    * @param id id列
    */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
    * 获取 小组id
    *
    * @return xiaozuid 小组id
    */
    public Integer getXiaozuid() {
        return this.xiaozuid;
    }

    /**
    * 设置 小组id
    *
    * @param xiaozuid 小组id
    */
    public void setXiaozuid(Integer xiaozuid) {
        this.xiaozuid = xiaozuid;
    }
    /**
    * 获取 内容
    *
    * @return neirong 内容
    */
    public String getNeirong() {
        return this.neirong;
    }

    /**
    * 设置 内容
    *
    * @param neirong 内容
    */
    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }
    /**
    * 获取 用户id
    *
    * @return usersid 用户id
    */
    public Integer getUsersid() {
        return this.usersid;
    }

    /**
    * 设置 用户id
    *
    * @param usersid 用户id
    */
    public void setUsersid(Integer usersid) {
        this.usersid = usersid;
    }
    /**
    * 获取 申请
    *
    * @return shenhe 申请
    */
    public String getShenhe() {
        return this.shenhe;
    }

    /**
    * 设置 申请
    *
    * @param shenhe 申请
    */
    public void setShenhe(String shenhe) {
        this.shenhe = shenhe;
    }
    /**
    * 获取 父表：小组表xiaozu
    *
    * @return xiaozu 父表：小组表xiaozu
    */
    public Xiaozu getXiaozu() {
        return this.xiaozu;
    }

    /**
    * 设置 父表：小组表xiaozu
    *
    * @param xiaozu 父表：小组表xiaozu
    */
    public void setXiaozu(Xiaozu xiaozu) {
        this.xiaozu = xiaozu;
    }
    /**
    * 获取 父表：用户表users
    *
    * @return users 父表：用户表users
    */
    public Users getUsers() {
        return this.users;
    }

    /**
    * 设置 父表：用户表users
    *
    * @param users 父表：用户表users
    */
    public void setUsers(Users users) {
        this.users = users;
    }

}
