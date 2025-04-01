package org.example.producer.serialization;

import org.apache.kafka.common.serialization.Serializer;
import org.example.model.Customer;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;


public class CustomerSerializer implements Serializer<Customer> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String topic, Customer data) {
        if (data == null) {
            return new byte[0];
        }

        try {

            byte[] serFirstName = data.getFirstName().getBytes(StandardCharsets.UTF_8);
            byte[] serLastName = data.getLastName().getBytes(StandardCharsets.UTF_8);


            ByteBuffer buffer = ByteBuffer.allocate(
                    4 + 4 + 4 + serFirstName.length + serLastName.length
            );

            buffer.putInt(data.getId());
            buffer.putInt(serFirstName.length);
            buffer.putInt(serLastName.length);

            buffer.put(serFirstName);
            buffer.put(serLastName);

            return buffer.array();

        } catch (Exception e) {
            return new byte[0];
        }
    }

    @Override
    public void close() {
        Serializer.super.close();
    }
}
