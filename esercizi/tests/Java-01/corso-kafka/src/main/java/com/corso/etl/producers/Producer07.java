package com.corso.etl.producers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.Future;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.corso.etl.model.Customer;
import com.corso.etl.model.CustomerAvro;
import com.corso.etl.producers.base.ProducerBase;

import io.confluent.kafka.serializers.KafkaAvroSerializer;

public class Producer07 extends ProducerBase {

	// SINCRONA CON ACK = 1 SEND CUSTOMER BSON WITH AVRO
	public void sendSyncCustomerAvro() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		Properties props = new Properties();
		
		// Definiamo connessione al cluster
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9091");
		
		// Schema Registry
		props.put("schema.registry.url", "http://localhost:8081");
		
		// Client ID
		props.put(ProducerConfig.CLIENT_ID_CONFIG, "P07");
		
		// Compression Type
		props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "gzip");
		
		// TIPO ACK
		props.put(ProducerConfig.ACKS_CONFIG, "1");
		
		// Namespaces delle CLASSI da utilizzare per la serializzazione della KEY e del VALORE 
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
		
		
		KafkaProducer<String, CustomerAvro> producer = new KafkaProducer<>(props);
				 
		
		System.out.println("START P07 -> " + formatter.format(new Date()));
		
		for (int count = 0; count < 5000; count++) {
			
			CustomerAvro obj = new CustomerAvro();
			obj.setId(count + 1);
			obj.setLastName("BIANCHI");
			obj.setFirstName("Mario " + (count + 1));
			
			// USO DI CUSTOMER AVRO
			ProducerRecord<String, CustomerAvro> record = new ProducerRecord<String, CustomerAvro>("TP_07", obj);
			
			// USO DI GENERIC DATA SU MODEL NON NATIVO AVRO
			//ProducerRecord<String, GenericRecord> record = new ProducerRecord<String, GenericRecord>("TP_CUSTOMER_AVRO", obj);
			//Customer customer = new Customer();
			//Schema sc =Schema.parse("CustomerAvro.avsc");
			//GenericRecord rec = customer.toAvro(sc);
			
			
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
		System.out.println("END P07 -> " + formatter.format(new Date()));
		
		System.out.println("Sended Closed");
		producer.flush();
		producer.close();	
		System.out.println("Complited");
		
		
	}
	
	 
	
	
}
