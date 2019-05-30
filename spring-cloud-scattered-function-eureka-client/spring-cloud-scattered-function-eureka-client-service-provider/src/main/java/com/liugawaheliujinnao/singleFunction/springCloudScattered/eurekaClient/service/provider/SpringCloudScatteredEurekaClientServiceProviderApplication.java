package com.liugawaheliujinnao.singleFunction.springCloudScattered.eurekaClient.service.provider;

import com.liugawaheliujinnao.singleFunction.springCloudScattered.eurekaClient.api.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description: 用户服务引导类 {@link UserService}
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudScatteredEurekaClientServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudScatteredEurekaClientServiceProviderApplication.class, args);
    }
}
