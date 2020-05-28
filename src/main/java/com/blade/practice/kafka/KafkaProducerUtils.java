package com.blade.practice.kafka;

import com.blade.util.SystemConfiguration;
import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/14 21:54
 */
public class KafkaProducerUtils {

    private static final String CONFIG_PATH = "/kafka-producer.properties";

    private KafkaProducer<String, String> kafkaProducer;

    public KafkaProducerUtils() {
        SystemConfiguration configuration = new SystemConfiguration(CONFIG_PATH);

        Properties properties = configuration.getProperties();

        this.kafkaProducer = new KafkaProducer<String, String>(properties);
    }

    public KafkaProducer<String, String> getKafkaProducer() {
        return this.kafkaProducer;
    }
}
