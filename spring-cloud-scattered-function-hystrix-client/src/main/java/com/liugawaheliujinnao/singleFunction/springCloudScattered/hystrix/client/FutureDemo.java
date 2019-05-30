package com.liugawaheliujinnao.singleFunction.springCloudScattered.hystrix.client;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
public class FutureDemo {

    public static void main(String[] args) {
        Random random = new Random();

        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<String> future =  service.submit(() -> {
            // 如果随机时间大于 100，那么触发容错
            int value = random.nextInt(200);
            System.out.println("helloWorld() costs " + value + " ms.");
            Thread.sleep(value);
            return "Hello, World";
        });
        try {
            future.get(100, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            // 超时流程
            System.out.println("超时保护！");
        }
    }
}
