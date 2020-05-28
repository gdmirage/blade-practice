package com.blade.practice.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/15 0:00
 */
public class KafkaConsumerClient {

    private KafkaConsumer<String, String> kafkaConsumer;

    public KafkaConsumerClient() {
        kafkaConsumer = new KafkaConsumerUtils().getKafkaConsumer();
    }

    public void getMsg(String topic) {

        List<String> topics = new ArrayList<>();
        topics.add(topic);

        kafkaConsumer.subscribe(topics);

//        System.out.println("--->"+kafkaConsumer.listTopics());
        while (true) {
            ConsumerRecords<String, String> records = kafkaConsumer.poll(1000);
            System.out.println("record count:" + records.count());
            for (ConsumerRecord record : records) {
                System.out.println(String.format("[%s] receiver message: [%s -> %s], offset:%s",
                        record.partition(), record.key(), record.value(), record.offset()));
            }
        }
    }
}
