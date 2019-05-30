package com.liugawaheliujinnao.singleFunction.springCloudScattered.eurekaClient.service.consumer.web.controller;

import com.liugawaheliujinnao.singleFunction.springCloudScattered.eurekaClient.api.domain.User;
import com.liugawaheliujinnao.singleFunction.springCloudScattered.eurekaClient.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@RestController
public class UseRestApiController {

    private final UserService userService;

    @Autowired
    public UseRestApiController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @param name 请求参数名为 "name" 的数据
     * @return 如果保存成功的话，返回{@link User}，否则返回 null
     */
    @PostMapping("/user/save")
    public User saveUser(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        if (userService.save(user)) {
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
