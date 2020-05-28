package com.blade.practice.kafka;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/16 23:06
 */
public class KafkaProducerTest {

    protected static String topic = "Test_topic";

    public static void main(String[] args) throws Exception {
        KafkaProducerClient producer = new KafkaProducerClient();
        producer.sendMsg(topic, "1","hello world");

        //不要让主线程停止，才能向kafka发送成功
        System.in.read();
    }
}
