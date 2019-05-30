package com.liugawaheliujinnao.singleFunction.springCloudScattered.eurekaClient.service.provider.service;

import com.liugawaheliujinnao.singleFunction.springCloudScattered.eurekaClient.api.domain.User;
import com.liugawaheliujinnao.singleFunction.springCloudScattered.eurekaClient.api.service.UserService;
import com.liugawaheliujinnao.singleFunction.springCloudScattered.eurekaClient.service.provider.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Description: {@link UserService 用户服务提供者实现}
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }
}
