package org.example;

import org.example.producer.Producer01;
import org.example.producer.ProducerCustomer;

import java.nio.ByteBuffer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {



        // FIRE & FORGET ACK 0
        // Producer01 client01 = new Producer01();
        // client01.sendMessagesFireAndForget();


        ProducerCustomer client = new ProducerCustomer();
        client.sendSyncCustomerBynary();
        client.sendSyncCustomerJson();



    }
}