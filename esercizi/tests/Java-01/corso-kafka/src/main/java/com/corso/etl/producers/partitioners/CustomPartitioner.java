package com.corso.etl.producers.partitioners;

import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

public class CustomPartitioner implements Partitioner {

	@Override
	public void configure(Map<String, ?> configs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
	
		if (key != null && key instanceof String) {
			String keyString = (String)key;
			if (keyString.startsWith("K")) {
				return 1;
			} else if (keyString.startsWith("Q")) {
				return 2;  
			}
			
		}
		return 0;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
