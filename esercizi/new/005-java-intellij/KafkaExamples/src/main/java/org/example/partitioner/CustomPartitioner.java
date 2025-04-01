package org.example.partitioner;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

public class CustomPartitioner implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] bytes, Object value, byte[] valueBytes, Cluster cluster) {
        if (key != null && key instanceof String) {
            String keyString = (String)key;
            if (keyString.startsWith("K")) {
                return 1;
            } else if (keyString.startsWith("Q")) {
                return 2;
            } else return 0;

        }
        return 0;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
