package org.example.producer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer01 {

    // FIRE & FORGET ACK = 0
    public void sendMessagesFireAndForget(String topicName, long totalMessage) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");


        Properties props = new Properties();

        // Definiamo connessione al cluster
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9093,localhost:9094");


        // Client ID
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "P01");

        // Compression Type
        props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "gzip");

        // TIPO ACK
        props.put(ProducerConfig.ACKS_CONFIG, "0");

        // Namespaces delle CLASSI da utilizzare per la serializzazione della KEY e del VALORE
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");


        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        ProducerRecord<String, String> record = null;

        String startTime = formatter.format(new Date());

        for (int count = 0; count < totalMessage; count++) {
            record = new ProducerRecord<String, String>(topicName, "Messaggio Nr" + count);
            try {
                String headKey = "K" + count;
                record.headers().add("MSG_KEY", headKey.getBytes());
                producer.send(record);
                System.out.println("Sended Msg -> " + headKey);
            } catch (Exception e) {
                e.printStackTrace();
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
