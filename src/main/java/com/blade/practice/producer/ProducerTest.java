package com.blade.practice.producer;

import com.blade.practice.producer.arrayblockqueue.BConsumer;
import com.blade.practice.producer.arrayblockqueue.BProducer;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/10 22:55
 */
public class ProducerTest {
    public static void main(String[] args) {
        arrayBlockQueueTest();
    }

    private static void arrayBlockQueueTest() {
        BProducer.produce();
        BConsumer.consumer();
    }
}
