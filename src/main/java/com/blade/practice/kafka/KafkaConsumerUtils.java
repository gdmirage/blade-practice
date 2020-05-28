package com.blade.practice.kafka;

import com.blade.util.SystemConfiguration;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Properties;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/14 21:54
 */
public class KafkaConsumerUtils {

    private static final String CONFIG_PATH = "/kafka-consumer.properties";

    private KafkaConsumer<String, String> kafkaConsumer;

    private static Properties consumerProperties = null;

    public KafkaConsumerUtils() {
        SystemConfiguration configuration = new SystemConfiguration(CONFIG_PATH);

        if(null == consumerProperties || consumerProperties.size() == 0) {
            consumerProperties = configuration.getProperties();
        }

        this.kafkaConsumer = new KafkaConsumer<String, String>(consumerProperties);
    }

    public KafkaConsumer<String, String> getKafkaConsumer() {
        return this.kafkaConsumer;
    }
}
