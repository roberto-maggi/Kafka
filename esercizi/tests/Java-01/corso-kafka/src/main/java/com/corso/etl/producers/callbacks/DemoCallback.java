package com.corso.etl.producers.callbacks;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class DemoCallback implements Callback {

	@Override
	public void onCompletion(RecordMetadata metadata, Exception ex) {
		if (ex != null) {
			ex.printStackTrace();
		}
		
		if (metadata != null) {
			// printMetadata(metadata);
		}
		
	}

}
