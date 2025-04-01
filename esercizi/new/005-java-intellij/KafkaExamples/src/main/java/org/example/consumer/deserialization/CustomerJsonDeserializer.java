package org.example.consumer.deserialization;

import com.google.gson.Gson;
import org.apache.kafka.common.serialization.Deserializer;
import org.example.model.Customer;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class CustomerJsonDeserializer implements Deserializer<Customer> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public Customer deserialize(String topics, byte[] data) {
        try {
            String json = new String(data, StandardCharsets.UTF_8);
            return new Gson().fromJson(json, Customer.class);
        } catch (Exception e) {
           return new Customer();
        }
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
