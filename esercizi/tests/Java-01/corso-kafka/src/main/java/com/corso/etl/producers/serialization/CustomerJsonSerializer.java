package com.corso.etl.producers.serialization;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.corso.etl.model.Customer;

public class CustomerJsonSerializer implements Serializer<Customer> {
	

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub
		Serializer.super.configure(configs, isKey);
	}

	@Override
	public byte[] serialize(String topic, Customer data) {
		
		if (data == null) {
			return null;
		}

		try {
			
			byte[] serJson = data.toString().getBytes("UTF-8");
			 
			
			ByteBuffer buffer = ByteBuffer.allocate(serJson.length);
			buffer.put(serJson); 
				
			return buffer.array();
		
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
	
	@Override
	public void close() {
		// TODO Auto-generated method stub
		Serializer.super.close();
	}

}
