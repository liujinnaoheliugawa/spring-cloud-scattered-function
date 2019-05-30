package com.liugawaheliujinnao.singleFunction.springCloudScattered.streamKafka.stream.producer;

import com.liugawaheliujinnao.singleFunction.springCloudScattered.streamKafka.stream.messaging.MessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @Description: 消息生产者 Bean
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
@Component
@EnableBinding({Source.class, MessageSource.class})
public class MessageProducerBean {

    @Autowired
    @Qualifier(Source.OUTPUT) // Bean 名称
    private MessageChannel messageChannel;

    @Autowired
    private Source source;

    @Autowired
    private MessageSource testSource;

    @Autowired
    @Qualifier(Source.OUTPUT)
    private MessageChannel testMessageChannel;

    /**
     * 发送消息
     * @param message 消息内容
     */
    public void send(String message) {
        // 通过消息管道发送消息
        messageChannel.send(MessageBuilder.withPayload(message).build());
        source.output().send(MessageBuilder.withPayload(message).build());
    }

    public void sendToTest(String message) {
        testMessageChannel.send(MessageBuilder.withPayload(message).build());
        testSource.test().send(MessageBuilder.withPayload(message).build());
    }
}
