package org.example.consumer;

import org.apache.kafka.clients.consumer.*;
import org.example.model.Customer;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class ConsumerCustomer {



    public void loadRecords(String topicName) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");


        Properties props = new Properties();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9093,localhost:9094");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "CONSUMERS_01");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.example.consumer.deserializationCustomerDeserializer");


        final Consumer<String, Customer> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(topicName));

        Long count = 0L;

        try {
            while (true) {
                ConsumerRecords<String, Customer> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, Customer> record : records) {
                    String key = record.key();
                    Customer value = record.value();
                    count++;
                    System.out.printf("Consumato record con key %s e value %s (Total:  %d%n)", key, value, count);
                }
            }
        } finally {
            consumer.close();
        }
    }

    public void loadRecordsJson(String topicName) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");


        Properties props = new Properties();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9093,localhost:9094");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "CONSUMERS_01");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.example.consumer.CustomerJsonDeserializer");


        final Consumer<String, Customer> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(topicName));

        Long count = 0L;

        try {
            while (true) {
                ConsumerRecords<String, Customer> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, Customer> record : records) {
                    String key = record.key();
                    Customer value = record.value();
                    count++;
                    System.out.printf("Consumato record con key %s e value %s (Total:  %d%n)", key, value, count);
                }
            }
        } finally {
            consumer.close();
        }
    }


}
