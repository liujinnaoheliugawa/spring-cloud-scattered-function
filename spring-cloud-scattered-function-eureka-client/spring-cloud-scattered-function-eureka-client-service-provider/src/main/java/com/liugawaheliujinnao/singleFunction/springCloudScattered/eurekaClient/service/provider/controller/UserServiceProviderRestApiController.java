package com.liugawaheliujinnao.singleFunction.springCloudScattered.eurekaClient.service.provider.controller;

import com.liugawaheliujinnao.singleFunction.springCloudScattered.eurekaClient.api.domain.User;
import com.liugawaheliujinnao.singleFunction.springCloudScattered.eurekaClient.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @Description: 用户服务提供方 Rest API {@link UserService} {@link RestController}
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@RestController
public class UserServiceProviderRestApiController {

    private final UserService userService;

    @Autowired
    public UserServiceProviderRestApiController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @param user 请求参数
     * @return 如果保存成功的话，返回{@link User}，否则返回 null
     */
    @PostMapping("/user/save")
    public User saveUser(@RequestBody User user) {
        if (userService.save(user)) {
            System.out.println("UserService 服务方：保存用户成功！" + user);
            return user;
        } else {
            return null;
        }
    }

    /**
     * 罗列所有的用户数据
     * @return 所有的用户数据
     */
    @GetMapping("/user/list")
    public Collection<User> list() {
        return userService.findAll();
    }
}
