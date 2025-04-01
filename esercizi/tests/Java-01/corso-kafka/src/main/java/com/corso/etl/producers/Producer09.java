package com.corso.etl.producers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.corso.etl.admins.KafkaAdmins;
import com.corso.etl.producers.base.ProducerBase;
import com.corso.etl.producers.partitioners.CustomPartitioner;

public class Producer09 extends ProducerBase {

	// SINCRONA CON ACK = 1 Cutom topic
	public void sendSyncCutomPartitioner(String topicName, int numPartitions) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		Properties props = new Properties();
		
		// Definiamo connessione al cluster
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9091");
		
		System.out.println("CREATE TOPIC P09 -> " + topicName + " " + formatter.format(new Date()));
		
		
		KafkaAdmins.createTopic(topicName, numPartitions, props);
		
		
		
		
		// Client ID
		props.put(ProducerConfig.CLIENT_ID_CONFIG, "P09");
		
		// Compression Type
		props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "gzip");
		
		// TIPO ACK
		props.put(ProducerConfig.ACKS_CONFIG, "1");
		
		// Namespaces delle CLASSI da utilizzare per la serializzazione della KEY e del VALORE 
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, CustomPartitioner.class);
			
		
		KafkaProducer<String, String> producer = new KafkaProducer<>(props);
		
		ProducerRecord<String, String> record = null;
		
		System.out.println("START P09 -> " + formatter.format(new Date()));
		
		for (int count = 0; count < 5000; count++) {
			
			String key = null;
			if (count >= 50 && count <= 151) {
				key = "" + count;
			} else {
				key = count % 2 == 0 ? "K" + count : "Q" + count; 
			}
			
			
			record = new ProducerRecord<String, String>(topicName, key, "Messagio Nr" + count);
			try {
				
				Future<RecordMetadata> future = producer.send(record);
				
				RecordMetadata metadata = future.get();
				// printMetadata(metadata);
				
				
				System.out.println("offset e partione Msg -> " + metadata.offset() + "," + metadata.partition());
			} catch (Exception e) {
				System.out.println("Error Msg -> " + e.getMessage());
			}
		}
		System.out.println("END P09 -> " + formatter.format(new Date()));
		
		System.out.println("Sended Closed");
		producer.flush();
		producer.close();	
		System.out.println("Complited");
		
		
	}
	
	 
	
	
}
