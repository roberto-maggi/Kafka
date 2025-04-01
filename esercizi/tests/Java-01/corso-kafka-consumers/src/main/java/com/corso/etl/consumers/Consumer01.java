package com.corso.etl.consumers;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import com.corso.etl.consumers.base.ConsumerBase;


public class Consumer01 extends ConsumerBase {

	public void loadMessages() {
		
		Properties props = new Properties();
		
		// Definiamo connessione al cluster
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9091");
	
		// Definiamo il Gruppo del consumer
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "GRC_01");
		
		// Namespaces delle CLASSI da utilizzare per la serializzazione della KEY e del VALORE 
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,  StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		
		List<String> topics = Collections.singletonList("TP_01");
		
		consumer.subscribe(topics);
		
		try {
			
			Long countPolling = 0l;
			Long countRecords = 0l;
			
			do {
				countPolling++;
				ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(5000));
				
				for (ConsumerRecord<String, String> record : records) {
					countRecords++;
					printRecord(record, countRecords);
				}				
				
			} while (true);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			consumer.close();
		}
		
		
	} 
	
	
}
