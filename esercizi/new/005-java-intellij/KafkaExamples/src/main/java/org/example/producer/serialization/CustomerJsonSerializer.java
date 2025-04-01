package org.example.producer.serialization;

import org.apache.kafka.common.serialization.Serializer;
import org.example.model.Customer;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;


public class CustomerJsonSerializer implements Serializer<Customer> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String topic, Customer data) {
        if (data == null) {
            return null;
        }

        try {

            byte[] serJson = data.toString().getBytes(StandardCharsets.UTF_8);


            ByteBuffer buffer = ByteBuffer.allocate(serJson.length);
            buffer.put(serJson);

            return buffer.array();

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void close() {
        Serializer.super.close();
    }
}
