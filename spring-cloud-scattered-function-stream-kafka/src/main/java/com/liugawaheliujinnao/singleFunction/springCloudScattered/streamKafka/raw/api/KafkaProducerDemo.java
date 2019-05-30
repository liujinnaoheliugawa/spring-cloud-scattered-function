package com.liugawaheliujinnao.singleFunction.springCloudScattered.streamKafka.raw.api;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

/**
 * @Description: Kafka Producer Demo(使用原始 API)
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-30
 */
public class KafkaProducerDemo {

    public static void main(String[] args) throws Exception {
        // 初始化配置
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());
        // 创建 Kafka Producer
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer(properties);
        // 创建 Kafka 消息
        String topic = "test2";
        Integer partition = 1;
        Long timestamp = System.currentTimeMillis();
        String key = "messaging-key";
        String value = "Roy Wu";
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, partition, timestamp, key, value);
        // 发送消息
        Future<RecordMetadata> metadataFuture = kafkaProducer.send(record);
        // 强制执行
        metadataFuture.get();
    }
}
