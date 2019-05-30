package com.liugawaheliujinnao.singleFunction.springCloudScattered.eurekaClient.service.consumer.service;

import com.liugawaheliujinnao.singleFunction.springCloudScattered.eurekaClient.api.domain.User;
import com.liugawaheliujinnao.singleFunction.springCloudScattered.eurekaClient.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

/**
 * @Description: {@link UserService}
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@Service
public class UserServiceProxy implements UserService {

    /**
     * 通过 REST API 代理到服务器提供者
     */
    private final RestTemplate restTemplate;

    private static final String PROVIDER_SERVER_URL_PREFIX = "http://user-service-provider/";

    @Autowired
    public UserServiceProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public boolean save(User user) {
        User returnValue = restTemplate.postForObject(PROVIDER_SERVER_URL_PREFIX + "/user/save", user, User.class);
        return returnValue != null;
    }

    @Override
    public Collection<User> findAll() {
        return restTemplate.getForObject(PROVIDER_SERVER_URL_PREFIX + "/user/list", Collection.class);
    }
}
