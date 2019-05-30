package com.liugawaheliujinnao.singleFunction.springCloudScattered.eurekaClient.api.service;

import com.liugawaheliujinnao.singleFunction.springCloudScattered.eurekaClient.api.domain.User;

import java.util.Collection;

/**
 * 用户服务
 */
public interface UserService {

    /**
     * @param user 保存用户
     * @return 如果保存成功的话，返回 true，否则返回 false
     */
    boolean save(User user);

    /**
     * 查询所有的用户对象
     * @return 不会返回 null
     */
    Collection<User> findAll();
}
