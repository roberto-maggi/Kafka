package org.example.producer;

import org.example.model.Customer;
import org.example.producer.base.ProducerBase;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;



public class ProducerCustomer extends ProducerBase {

    public void sendSyncCustomerBynary(String topicName, long totalMessage) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        Properties props = new Properties();

        // Definiamo connessione al cluster
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9093,localhost:9094");

        // Client ID
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "PCustomer");

        // Compression Type
        props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "gzip");

        // TIPO ACK
        props.put(ProducerConfig.ACKS_CONFIG, "1");

        // Namespaces delle CLASSI da utilizzare per la serializzazione della KEY e del VALORE
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.example.producer.serialization.CustomerSerializer");


        KafkaProducer<String, Customer> producer = new KafkaProducer<>(props);


        String startTime = formatter.format(new Date());

        for (int count = 0; count < totalMessage; count++) {

            Customer obj = new Customer(count + 1, "Rossi", "Mario " + count);
            ProducerRecord<String, Customer> record = new ProducerRecord<String, Customer>(topicName, obj);

            try {

                Future<RecordMetadata> future = producer.send(record);

                RecordMetadata metadata = future.get();
                // printMetadata(metadata);


                System.out.println("Sended Msg -> " + metadata.offset() + " - " + obj.getLastName() + " " + obj.getFirstName());
            } catch (Exception e) {
                System.out.println("Error Msg -> " + e.getMessage());
            }
        }
        System.out.println("START -> " + startTime + " == END -> " + formatter.format(new Date()));

        System.out.println("Sended Closed");
        producer.flush();
        producer.close();
        System.out.println("Complited");


    }


    public void sendSyncCustomerJson(String topicName, long totalMessage) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        Properties props = new Properties();

        // Definiamo connessione al cluster
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9091");

        // Client ID
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "PCustomer");

        // Compression Type
        props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "gzip");

        // TIPO ACK
        props.put(ProducerConfig.ACKS_CONFIG, "1");

        // Namespaces delle CLASSI da utilizzare per la serializzazione della KEY e del VALORE
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.example.producer.serialization.CustomerSerializer");


        KafkaProducer<String, Customer> producer = new KafkaProducer<>(props);


        String startTime = formatter.format(new Date());

        for (int count = 0; count < totalMessage; count++) {

            Customer obj = new Customer(count + 1, "Rossi", "Mario " + count);
            ProducerRecord<String, Customer> record = new ProducerRecord<String, Customer>(topicName, obj);

            try {

                Future<RecordMetadata> future = producer.send(record);

                RecordMetadata metadata = future.get();
                // printMetadata(metadata);


                System.out.println("Sended Msg -> " + metadata.offset() + " - " + obj.getLastName() + " " + obj.getFirstName());
            } catch (Exception e) {
                System.out.println("Error Msg -> " + e.getMessage());
            }
        }
        System.out.println("START -> " + startTime + " == END -> " + formatter.format(new Date()));

        System.out.println("Sended Closed");
        producer.flush();
        producer.close();
        System.out.println("Complited");


    }


}
