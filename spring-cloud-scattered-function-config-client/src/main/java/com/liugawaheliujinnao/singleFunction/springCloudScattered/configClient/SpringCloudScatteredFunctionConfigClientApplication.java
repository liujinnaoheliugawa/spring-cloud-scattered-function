package com.liugawaheliujinnao.singleFunction.springCloudScattered.configClient;

import com.liugawaheliujinnao.singleFunction.springCloudScattered.configClient.health.MyHealthIndicator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Set;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@SpringBootApplication
public class SpringCloudScatteredFunctionConfigClientApplication {

    private final ContextRefresher contextRefresher;

    private final Environment environment;

    public SpringCloudScatteredFunctionConfigClientApplication(ContextRefresher contextRefresher, Environment environment) {
        this.contextRefresher = contextRefresher;
        this.environment = environment;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudScatteredFunctionConfigClientApplication.class, args);
    }

    @Scheduled(fixedRate = 5 * 1000, initialDelay = 3 * 1000)
    public void autoRefresh() {
        Set<String> updatePropertyNames = contextRefresher.refresh();
        updatePropertyNames.forEach(propertyName -> {
            System.out.printf("[Thread :%s]当前配置已更新，具体 Key：%s, Value：%s\n", Thread.currentThread().getName(), propertyName, environment.getProperty(propertyName));
        });
    }

    @Bean
    public MyHealthIndicator myHealthIndicator() {
        return new MyHealthIndicator();
    }
}
