package com.liugawaheliujinnao.singleFunction.springCloudScattered.hystrix.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableTurbine
public class SpringCloudScatteredFunctionHystrixClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudScatteredFunctionHystrixClientApplication.class, args);
    }
}
