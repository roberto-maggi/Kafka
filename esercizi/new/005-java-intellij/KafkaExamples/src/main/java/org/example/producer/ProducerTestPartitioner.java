package org.example.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.example.admin.KafkaAdmins;
import org.example.producer.base.ProducerBase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.Future;

public class ProducerTestPartitioner extends ProducerBase {

    public void sendSyncCustomPartitioner(String topicName, int numPartitions) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        Properties props = new Properties();

        // Definiamo connessione al cluster
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9093,localhost:9094");

        KafkaAdmins.createTopic(topicName, numPartitions, props);

        // Client ID
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "PP");

        // Compression Type
        props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "gzip");

        // TIPO ACK
        props.put(ProducerConfig.ACKS_CONFIG, "1");

        // Namespaces delle CLASSI da utilizzare per la serializzazione della KEY e del VALORE
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");


        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        ProducerRecord<String, String> record = null;

        String startTime = formatter.format(new Date());

        for (int count = 0; count < 5000; count++) {

            String key = null;
            if (count >= 50 && count <= 151) {
                key = "X" + count;
            } else {
                key = count % 2 == 0 ? "K" + count : "Q" + count;
            }

            record = new ProducerRecord<String, String>(topicName, key,"Messagio Nr" + count);
            try {
                String headInfo = "K" + count;
                record.headers().add("MSK_KEY", headInfo.getBytes());

                Future<RecordMetadata> future = producer.send(record);

                RecordMetadata metadata = future.get();
                // printMetadata(metadata);


                System.out.println("offset e partione Msg -> " + metadata.offset() + "," + metadata.partition());
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
