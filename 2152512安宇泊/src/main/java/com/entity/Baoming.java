package com.entity;


/**
 * @ClassName Baoming
 * @Description 报名模块实体层
 */
public class Baoming {
    //id列
    private Integer id;


    //活动id
    private Integer huodongid;
    //申请原因
    private String nerong;
    //时间
    private String shijian;
    //用户id
    private Integer usersid;
    //父表：活动表huodong
    private Huodong huodong;
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
    * 获取 活动id
    *
    * @return huodongid 活动id
    */
    public Integer getHuodongid() {
        return this.huodongid;
    }

    /**
    * 设置 活动id
    *
    * @param huodongid 活动id
    */
    public void setHuodongid(Integer huodongid) {
        this.huodongid = huodongid;
    }
    /**
    * 获取 申请原因
    *
    * @return nerong 申请原因
    */
    public String getNerong() {
        return this.nerong;
    }

    /**
    * 设置 申请原因
    *
    * @param nerong 申请原因
    */
    public void setNerong(String nerong) {
        this.nerong = nerong;
    }
    /**
    * 获取 时间
    *
    * @return shijian 时间
    */
    public String getShijian() {
        return this.shijian;
    }

    /**
    * 设置 时间
    *
    * @param shijian 时间
    */
    public void setShijian(String shijian) {
        this.shijian = shijian;
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
    * 获取 父表：活动表huodong
    *
    * @return huodong 父表：活动表huodong
    */
    public Huodong getHuodong() {
        return this.huodong;
    }

    /**
    * 设置 父表：活动表huodong
    *
    * @param huodong 父表：活动表huodong
    */
    public void setHuodong(Huodong huodong) {
        this.huodong = huodong;
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
