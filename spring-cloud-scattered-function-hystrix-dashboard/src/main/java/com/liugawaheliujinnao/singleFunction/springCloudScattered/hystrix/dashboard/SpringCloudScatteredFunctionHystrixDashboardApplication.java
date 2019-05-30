package com.liugawaheliujinnao.singleFunction.springCloudScattered.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@SpringBootApplication
@EnableHystrixDashboard
public class SpringCloudScatteredFunctionHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudScatteredFunctionHystrixDashboardApplication.class, args);
    }
}
