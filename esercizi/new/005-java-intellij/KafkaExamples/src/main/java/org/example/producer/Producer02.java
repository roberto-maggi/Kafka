package org.example.producer;

import org.example.producer.base.ProducerBase;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class Producer02 extends ProducerBase {

    public void sendSyncAck1(String topicName, long totalMessage) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        Properties props = new Properties();

        // Definiamo connessione al cluster
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9093,localhost:9094");

        // Client ID
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "P02");

        // Compression Type
        props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "gzip");

        // TIPO ACK
        props.put(ProducerConfig.ACKS_CONFIG, "1");

        // Namespaces delle CLASSI da utilizzare per la serializzazione della KEY e del VALORE
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");


        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        ProducerRecord<String, String> record = null;

        System.out.println("START P02 -> " + formatter.format(new Date()));

        for (int count = 0; count < totalMessage; count++) {
            record = new ProducerRecord<String, String>(topicName, "Messagio Nr" + count);
            try {
                String headInfo = "K" + count;
                record.headers().add("MSK_KEY", headInfo.getBytes());

                Future<RecordMetadata> future = producer.send(record);

                RecordMetadata metadata = future.get();
                // printMetadata(metadata);


                //System.out.println("Sended Msg -> " + headInfo);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error Msg -> " + e.getMessage());
            }
        }
        String startTime = formatter.format(new Date());

        System.out.println("Sended Closed");
        producer.flush();
        producer.close();
        System.out.println("Complited");


    }

    // ASINCRONA CON ACK = 1
    public void sendAsyncAck1(String topicName, long totalMessage) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        Properties props = new Properties();

        // Definiamo connessione al cluster
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9093,localhost:9094");

        // Client ID
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "P02");

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


        for (int count = 0; count < totalMessage; count++) {
            record = new ProducerRecord<String, String>(topicName, "Messagio Nr" + count);
            try {
                String headInfo = "K" + count;
                record.headers().add("MSK_KEY", headInfo.getBytes());


                //RecordMetadata metadata = future.get();

                // Uso Anonymous
                producer.send(record, new Callback() {

                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception ex) {
                        if (ex != null) {
                            System.out.println("Error Msg -> " + ex.getMessage());
                        }

                        if (metadata != null) {
                            // printMetadata(metadata);
                        }
                    }
                });

				/*
				// Uso Lambda
				producer.send(record, (metadata, ex) -> {
					if (ex != null) {
						ex.printStackTrace();
					}

					if (metadata != null) {
						// printMetadata(metadata);
					}
				});

				// Uso classico con interfaccia di callback
				producer.send(record, new DemoCallback());
				*/


                //System.out.println("Sended Msg -> " + headInfo);
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println("Error Msg -> " + e.getMessage());
            }
        }
        System.out.println("START -> " + startTime + " == END -> " + formatter.format(new Date()));

        System.out.println("Sended Closed");
        producer.flush();
        producer.close();
        System.out.println("Complited");


    }


    public void sendSyncAckAll() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        Properties props = new Properties();

        // Definiamo connessione al cluster
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092,localhost:9093,localhost:9094");

        // Client ID
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "P02");

        // Compression Type
        props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "gzip");

        // TIPO ACK
        props.put(ProducerConfig.ACKS_CONFIG, "all");

        // Namespaces delle CLASSI da utilizzare per la serializzazione della KEY e del VALORE
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");


        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        ProducerRecord<String, String> record = null;

        String startTime = formatter.format(new Date());


        for (int count = 0; count < 10000; count++) {
            record = new ProducerRecord<String, String>("TP_03", "Messagio Nr" + count);
            try {
                String headInfo = "K" + count;
                record.headers().add("MSK_KEY", headInfo.getBytes());

                Future<RecordMetadata> future = producer.send(record);

                RecordMetadata metadata = future.get();
                // printMetadata(metadata);


                //System.out.println("Sended Msg -> " + headInfo);
            } catch (Exception e) {
                //e.printStackTrace();
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
