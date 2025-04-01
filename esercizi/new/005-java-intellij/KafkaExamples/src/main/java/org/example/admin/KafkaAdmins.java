package org.example.admin;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;


public class KafkaAdmins {

    public static void createTopic(final String topicName, final int numPartitions, final Properties props) {
        final NewTopic topic = new NewTopic(topicName, Optional.of(numPartitions), Optional.empty());

        try (final AdminClient admin = AdminClient.create(props)) {
            final List<NewTopic> topics = Collections.singletonList(topic);

            Object ret = admin.createTopics(topics).all().get();


        } catch (Exception e) {
            // TODO: handle exception
        }


    }

    }
