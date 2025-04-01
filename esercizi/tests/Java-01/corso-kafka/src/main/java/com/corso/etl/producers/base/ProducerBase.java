package com.corso.etl.producers.base;

import org.apache.kafka.clients.producer.RecordMetadata;

public class ProducerBase {


	public static void printMetadata(RecordMetadata data) {
		System.out.println("=== MSG METADATA ===");
		System.out.println("Topic     = " + data.topic());
		System.out.println("Partition = " + data.partition());
		System.out.println("Offset    = " + data.offset());
		System.out.println("Timestamp = " + data.timestamp() );
	}
	
}
