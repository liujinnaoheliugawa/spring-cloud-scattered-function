package com.liugawaheliujinnao.singleFunction.springCloudScattered.streamKafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Description: Kafka 消费者监听器
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@Component
public class KafkaConsumerListener {

    @KafkaListener(topics = "${kafka.topic}")
    public void onMessage(String message) {
        System.out.println("Kafka 消费者监听器，接收到消息：" + message);
    }

    @KafkaListener(topics = "gupao")
    public void onTestMessage(String message) {
        System.out.println("Kafka Test 消费者监听器，接收到消息：" + message);
    }
}
