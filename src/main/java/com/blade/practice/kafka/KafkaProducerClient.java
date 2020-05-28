package com.blade.practice.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/12 23:54
 */
public class KafkaProducerClient {
    private final KafkaProducer<String, String> kafkaProducer;

    public KafkaProducerClient() {
        kafkaProducer = new KafkaProducerUtils().getKafkaProducer();
    }

    public void sendMsg(String topic, String message) {
        this.sendMsg(topic, null, message);
    }

    public void sendMsg(String topic, String key, String message) {
        System.out.println("in send msg method");
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, key, message);

        kafkaProducer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                System.out.println("in call back");
                System.out.println(message);
            }
        });
    }
}
