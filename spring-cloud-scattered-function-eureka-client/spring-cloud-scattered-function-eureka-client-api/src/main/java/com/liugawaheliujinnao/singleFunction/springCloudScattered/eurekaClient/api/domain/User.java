package com.liugawaheliujinnao.singleFunction.springCloudScattered.eurekaClient.api.domain;

/**
 * @Description: 用户的模型 API
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
public class User {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
