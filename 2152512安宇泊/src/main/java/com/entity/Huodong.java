package com.entity;


/**
 * @ClassName Huodong
 * @Description 活动模块实体层
 */
public class Huodong {
    //id列
    private Integer id;


    //名称
    private String mingcheng;
    //图片
    private String tupian;
    //日常内容
    private String neirong;
    //用户id
    private Integer usersid;
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
    * 获取 日常内容
    *
    * @return neirong 日常内容
    */
    public String getNeirong() {
        return this.neirong;
    }

    /**
    * 设置 日常内容
    *
    * @param neirong 日常内容
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
