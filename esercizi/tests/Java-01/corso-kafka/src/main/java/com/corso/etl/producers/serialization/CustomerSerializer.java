package com.corso.etl.producers.serialization;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.corso.etl.model.Customer;

public class CustomerSerializer implements Serializer<Customer> {


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
			
			byte[] serFirstName = data.getFirstName().getBytes("UTF-8");
			byte[] serLastName = data.getLastName().getBytes("UTF-8");		
			 
			
			ByteBuffer buffer = ByteBuffer.allocate(
					4 + 4 + 4 + serFirstName.length + serLastName.length
		    );
			
			buffer.putInt(data.getId());
			buffer.putInt(serFirstName.length);
			buffer.putInt(serLastName.length);
			
			buffer.put(serFirstName);
			buffer.put(serLastName);
				
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
