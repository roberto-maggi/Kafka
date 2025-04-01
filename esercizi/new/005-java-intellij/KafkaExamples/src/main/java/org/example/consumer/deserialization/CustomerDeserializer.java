package org.example.consumer.deserialization;

import org.apache.kafka.common.serialization.Deserializer;
import org.example.model.Customer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

public class CustomerDeserializer implements Deserializer<Customer> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public Customer deserialize(String topic, byte[] data) {

        Customer customer = new Customer();
        byte[] serId = Arrays.copyOfRange(data, 0, 4);
        customer.setId( ByteBuffer.wrap(serId).getInt());

        byte[] serLenFirstName = Arrays.copyOfRange(data, 4, 8);
        int lenFirstName = ByteBuffer.wrap(serLenFirstName).getInt();

        byte[] serLenLastName = Arrays.copyOfRange(data, 8, 12);
        int lenLastName = ByteBuffer.wrap(serLenLastName).getInt();

        int startFirstName = 12;
        int endFirstName = 12 + lenFirstName;
        byte[] serFirstName = Arrays.copyOfRange(data, startFirstName, endFirstName );
        customer.setFirstName(new String(serFirstName, StandardCharsets.UTF_8));

        int endLastName = endFirstName + lenLastName;
        byte[] serLastName = Arrays.copyOfRange(data, endFirstName, endLastName );
        customer.setLastName(new String(serLastName, StandardCharsets.UTF_8));


        return customer;
    }


    @Override
    public void close() {
        Deserializer.super.close();
    }
}

/*

package org.example.consumer.serialization;

import org.apache.kafka.common.serialization.Deserializer;
import org.example.model.Customer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

public class CustomerDeserializer implements Deserializer<Customer> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public Customer deserialize(String topic, byte[] data) {

        Customer customer = new Customer();

        //Set ID
        byte[] serId = Arrays.copyOfRange(data, 0, 4);

        customer.setId(ByteBuffer.wrap(serId).getInt());

        //Set First Name
        byte[] serLenFirstName = Arrays.copyOfRange(data, 4, 8);
        int lenFirstName = ByteBuffer.wrap(serLenFirstName).getInt();
        byte[] serFirstName = Arrays.copyOfRange(data, 12, 12 + lenFirstName);

        customer.setFirstName(new String(serFirstName, StandardCharsets.UTF_8));

        //Set Last Name
        byte[] serLenLastName = Arrays.copyOfRange(data, 8, 12);
        int lenLastName = ByteBuffer.wrap(serLenLastName).getInt();
        byte[] serLastName = Arrays.copyOfRange(data, 12 + lenFirstName, 12 + lenFirstName + lenLastName);

        customer.setLastName(new String(serLastName, StandardCharsets.UTF_8));

        return customer;
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}


 */