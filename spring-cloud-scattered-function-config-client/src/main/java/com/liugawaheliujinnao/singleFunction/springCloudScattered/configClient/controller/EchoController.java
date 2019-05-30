package com.liugawaheliujinnao.singleFunction.springCloudScattered.configClient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 输出配置项
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@RestController
@RefreshScope
public class EchoController {

    @Value("${my.name}")
    private String myName;

    @GetMapping("/my-name")
    public String getMyName() {
        return myName;
    }
}
