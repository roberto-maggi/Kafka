# Kafka

## Introduction to Apache Kafka


Apache Kafka® is a distributed event streaming platform that is used for building real-time data pipelines and streaming applications. 

Kafka is designed to handle large volumes of data in a scalable and fault-tolerant manner, making it ideal for use cases such as real-time analytics, data ingestion, and event-driven architectures.

At its core, Kafka is a distributed publish-subscribe messaging system. Data is written to Kafka topics by producers and consumed from those topics by consumers. 

Kafka topics can be partitioned, enabling the parallel processing of data, and topics can be replicated across multiple brokers for fault tolerance.

With Kafka you get command-line tools for management and administration tasks, and [Java and Scala APIs](https://docs.confluent.io/kafka/kafka-apis.html#kafka-apis) to build an event streaming solution for your scenarios.


## Events and event streaming

To understand distributed event streaming in more detail, you should first understand that an event is a record that “something happened” in the world or in your business. 

For example, in a ride-share system, you might see the following event:

- Event key: “Alice”
- Event value: “Trip requested at work location”
- Event timestamp: “Jun. 25, 2020 at 2:06 p.m.”

The event data describes what happened, when, and who was involved. 

Event streaming is the practice of capturing events like the example, in real-time from sources like databases, sensors, mobile devices, cloud services, and software applications.


![alt text](../Images/kafka-intro.png)

An event streaming platform captures events in order and these streams of events are stored durably for processing, manipulation, and responding to in real time or to be retrieved later. 

In addition, event streams can be routed to different destination technologies as needed. Event streaming ensures a continuous flow and interpretation of data so that the right information is at the right place, at the right time.

To accomplish this, Kafka is run as a cluster on one or more servers that can span multiple datacenters. and provides its functionality in a distributed, highly scalable, elastic, fault-tolerant, and secure manner. 

In addition, Kafka can be deployed on bare-metal hardware, virtual machines, containers, and on-premises as well as in the cloud.