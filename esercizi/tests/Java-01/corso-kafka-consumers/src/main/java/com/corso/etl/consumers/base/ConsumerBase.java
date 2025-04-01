package com.corso.etl.consumers.base;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class ConsumerBase {
	
	
	public static<K,V> void printRecord(ConsumerRecord<K, V> rec, Long id) {
		
		System.out.println("===  MSG METADATA === ID -> " + id);
		System.out.println("Topic     = " + rec.topic());
		System.out.println("Partition = " + rec.partition());
		System.out.println("Offset    = " + rec.offset());
		System.out.println("Timestamp = " + rec.timestamp());
		System.out.println("Key       = " + rec.key());
		System.out.println("Value     = " + rec.value());
		
	}
	

}
