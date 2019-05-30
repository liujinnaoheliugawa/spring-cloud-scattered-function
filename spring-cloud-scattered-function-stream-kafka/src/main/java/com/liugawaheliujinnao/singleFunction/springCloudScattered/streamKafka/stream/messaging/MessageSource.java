package com.liugawaheliujinnao.singleFunction.springCloudScattered.streamKafka.stream.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MessageSource {

    /**
     * 消息来源的管道名称："test"
     */
    String NAME = "test";

    @Output(NAME)
    MessageChannel test();
}
