package com.corso.etl.producers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.corso.etl.model.Customer;
import com.corso.etl.producers.base.ProducerBase;

public class Producer05 extends ProducerBase {

	// SINCRONA CON ACK = 1 SEND CUSTOMER
	public void sendSyncCustomer() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		Properties props = new Properties();
		
		// Definiamo connessione al cluster
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9091");
		
		// Client ID
		props.put(ProducerConfig.CLIENT_ID_CONFIG, "P05");
		
		// Compression Type
		props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "gzip");
		
		// TIPO ACK
		props.put(ProducerConfig.ACKS_CONFIG, "1");
		
		// Namespaces delle CLASSI da utilizzare per la serializzazione della KEY e del VALORE 
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "com.corso.etl.producers.serialization.CustomerSerializer");
		
		
		KafkaProducer<String, Customer> producer = new KafkaProducer<>(props);
				 
		
		System.out.println("START P05 -> " + formatter.format(new Date()));
		
		for (int count = 0; count < 5000; count++) {
			
			Customer obj = new Customer(count + 1, "Rossi", "Mario " + count);
			ProducerRecord<String, Customer> record = new ProducerRecord<String, Customer>("TP_05", obj);
			
			try {
			
				Future<RecordMetadata> future = producer.send(record);
				
				RecordMetadata metadata = future.get();
				// printMetadata(metadata);
				
				
				System.out.println("Sended Msg -> " + obj.getLastName() + " " + obj.getFirstName());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error Msg -> " + e.getMessage());
			}
		}
		System.out.println("END P05 -> " + formatter.format(new Date()));
		
		System.out.println("Sended Closed");
		producer.flush();
		producer.close();	
		System.out.println("Complited");
		
		
	}
	
	 
	
	
}
