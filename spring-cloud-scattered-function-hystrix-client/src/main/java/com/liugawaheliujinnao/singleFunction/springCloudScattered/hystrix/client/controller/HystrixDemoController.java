package com.liugawaheliujinnao.singleFunction.springCloudScattered.hystrix.client.controller;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@RestController
public class HystrixDemoController {

    private final static Random random = new Random();

    /**
     * 当 {@link #helloWorld} 方法调用超时或者失败时，fallback 方法作为替代返回
     * @return
     */
    @GetMapping("hello-world-2")
    public String helloWorld2() {
        return new HelloWorldCommand().execute();
    }

    /**
     * 编程方式
     */
    private class HelloWorldCommand extends com.netflix.hystrix.HystrixCommand<String> {

        protected HelloWorldCommand() {
            super(HystrixCommandGroupKey.Factory.asKey("HelloWorld"), 100);
        }

        @Override
        protected String run() throws Exception {
            // 如果随机时间大于 100，那么触发容错
            int value = random.nextInt(200);
            System.out.println("helloWorld() costs " + value + " ms.");
            Thread.sleep(value);
            return "Hello， World";
        }

        //容错执行
        protected String getFallback() {
            return HystrixDemoController.this.errorContent();
        }
    }


    /**
     * 当 {@link #helloWorld} 方法调用超时或者失败时，fallback 方法作为替代返回
     * @return
     */
    @GetMapping("hello-world")
    @HystrixCommand(
            fallbackMethod = "errorContent",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")
            })
    public String helloWorld() throws Exception {
        // 如果随机时间大于 100，那么触发容错
        int value = random.nextInt(200);
        System.out.println("helloWorld() costs " + value + " ms.");
        Thread.sleep(value);
        return "Hello， World";
    }

    public String errorContent() {
        return "Fault";
    }
}
