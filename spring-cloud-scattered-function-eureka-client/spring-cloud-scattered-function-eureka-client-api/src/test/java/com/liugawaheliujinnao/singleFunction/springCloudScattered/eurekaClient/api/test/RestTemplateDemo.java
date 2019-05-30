package com.liugawaheliujinnao.singleFunction.springCloudScattered.eurekaClient.api.test;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
public class RestTemplateDemo {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        Map<String, Object> data = restTemplate.getForObject("http://localhost:8080/env", Map.class);
        System.out.println(data);

        restTemplate.getForObject("http://localhost:8080/env", String.class);
    }
}
