package com.liugawaheliujinnao.singleFunction.springCloudScattered.feignEurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringCloudScatteredFeignEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudScatteredFeignEurekaServerApplication.class, args);
    }
}
