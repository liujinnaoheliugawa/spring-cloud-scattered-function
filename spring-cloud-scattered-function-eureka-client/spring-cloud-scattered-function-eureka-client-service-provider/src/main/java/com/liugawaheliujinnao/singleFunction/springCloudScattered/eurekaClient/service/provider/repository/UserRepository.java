package com.liugawaheliujinnao.singleFunction.springCloudScattered.eurekaClient.service.provider.repository;

import com.liugawaheliujinnao.singleFunction.springCloudScattered.eurekaClient.api.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description: {@link User 用户仓储模型}
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@Repository
public class UserRepository {

    private ConcurrentMap<Long, User> repository = new ConcurrentHashMap<>();

    private static final AtomicLong idGenerator = new AtomicLong(0);

    public boolean save(User user) {
        Long id = idGenerator.incrementAndGet();
        user.setId(id);
        return repository.putIfAbsent(id, user) == null;
    }

    public Collection<User> findAll() {
        return repository.values();
    }
}
