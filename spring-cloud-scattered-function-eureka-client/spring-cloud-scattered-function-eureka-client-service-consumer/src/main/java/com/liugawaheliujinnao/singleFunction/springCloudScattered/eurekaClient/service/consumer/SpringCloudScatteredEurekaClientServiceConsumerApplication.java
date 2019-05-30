package com.liugawaheliujinnao.singleFunction.springCloudScattered.eurekaClient.service.consumer;

import com.liugawaheliujinnao.singleFunction.springCloudScattered.eurekaClient.api.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: {@link UserService} 消费引导类
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudScatteredEurekaClientServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudScatteredEurekaClientServiceConsumerApplication.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
