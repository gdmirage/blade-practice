package com.blade.practice.kafka;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/16 23:33
 */
public class KafkaConsumerTest {

    public static void main(String[] args) throws Exception{
        KafkaConsumerClient consumerClient = new KafkaConsumerClient();

        consumerClient.getMsg(KafkaProducerTest.topic);
    }
}
