package com.entity;


/**
 * @ClassName Xiaozu
 * @Description 小组模块实体层
 */
public class Xiaozu {
    //id列
    private Integer id;


    //名称
    private String mingcheng;
    //图片
    private String tupian;
    //活动id
    private Integer huodongid;
    //小组成绩
    private Integer chengji;
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
    * 获取 名称
    *
    * @return mingcheng 名称
    */
    public String getMingcheng() {
        return this.mingcheng;
    }

    /**
    * 设置 名称
    *
    * @param mingcheng 名称
    */
    public void setMingcheng(String mingcheng) {
        this.mingcheng = mingcheng;
    }
    /**
    * 获取 图片
    *
    * @return tupian 图片
    */
    public String getTupian() {
        return this.tupian;
    }

    /**
    * 设置 图片
    *
    * @param tupian 图片
    */
    public void setTupian(String tupian) {
        this.tupian = tupian;
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
    * 获取 小组成绩
    *
    * @return chengji 小组成绩
    */
    public Integer getChengji() {
        return this.chengji;
    }

    /**
    * 设置 小组成绩
    *
    * @param chengji 小组成绩
    */
    public void setChengji(Integer chengji) {
        this.chengji = chengji;
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
