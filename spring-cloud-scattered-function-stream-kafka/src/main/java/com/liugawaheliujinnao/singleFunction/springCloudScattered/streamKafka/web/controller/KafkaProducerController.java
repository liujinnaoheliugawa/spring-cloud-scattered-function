package com.liugawaheliujinnao.singleFunction.springCloudScattered.streamKafka.web.controller;

import com.liugawaheliujinnao.singleFunction.springCloudScattered.streamKafka.stream.producer.MessageProducerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@RestController
public class KafkaProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final MessageProducerBean messageProducerBean;

    private final String topic;

    @Autowired
    public KafkaProducerController(KafkaTemplate<String, String> kafkaTemplate, MessageProducerBean messageProducerBean, @Value("${kafka.topic}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.messageProducerBean = messageProducerBean;
        this.topic = topic;
    }

    /**
     * 通过 {@link KafkaTemplate} 发送
     * @param message
     * @return
     */
    @PostMapping("/message/send")
    public Boolean sendMessage(@RequestParam String message) {
        kafkaTemplate.send(topic, message);
        return true;
    }

    /**
     * 通过 {@link MessageProducerBean} 发送
     * @param message
     * @return
     */
    @GetMapping("/message/send")
    public Boolean send(@RequestParam String message) {
        messageProducerBean.send(message);
        return true;
    }

    @GetMapping("/message/sendToTest")
    public Boolean sendToTest(@RequestParam String message) {
        messageProducerBean.sendToTest(message);
        return true;
    }
}
