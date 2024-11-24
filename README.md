
# Kafka Microservices Communication

This project contains two microservices that communicate using Kafka. The first microservice is a **Producer** running on port `8088`, and the second microservice is a **Consumer** running on port `8089`. The Producer sends messages to a Kafka topic, and the Consumer listens for messages on the same topic.

## Microservices Overview

- **Producer (Port 8088)**: 
  - The Producer sends User, to a Kafka topic.
  - It connects to a Kafka broker and writes User to a specified topic *KFK*.

- **Consumer (Port 8089)**: 
  - The Consumer listens for Users on the Kafka topic.
  - It connects to the Kafka broker and consumes users from the topic *KFK*.

## Kafka Commands

### 1. List Kafka Topics
To list all the Kafka topics, run the following command:
```bash
kafka-topics.sh --list --bootstrap-server localhost:9092
```

### 2. Delete a Kafka Topic
To delete a specific Kafka topic, run the following command (replace `your_topic_name` with the actual topic name):
```bash
kafka-topics.sh --delete --bootstrap-server localhost:9092 --topic your_topic_name
```

### 3. Consume Messages from a Kafka Topic
To consume messages from a Kafka topic (replace `your_topic_name` with the actual topic name), run the following command:
```bash
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic your_topic_name --from-beginning
```
This command will display all the messages from the beginning of the topic.

## Getting Started

1. **Install Kafka**: Ensure that Kafka and Zookeeper are running on your machine.
   - Download and install Kafka from [Apache Kafka](https://kafka.apache.org/downloads).
   - Start Zookeeper and Kafka server:
     ```bash
     # Start Zookeeper
     bin/zookeeper-server-start.sh config/zookeeper.properties

     # Start Kafka broker
     bin/kafka-server-start.sh config/server.properties
     ```

2. **Build and Run Microservices**:
   - Build the microservices (e.g., using Maven, Gradle, or Docker).
   - Run the **Producer** microservice on port `8088`.
   - Run the **Consumer** microservice on port `8089`.

3. **Verify Communication**:
   - The Producer will start sending messages to the Kafka topic.
   - The Consumer will receive and process these messages.

## Dependencies

- Apache Kafka
- Spring Boot (or another framework for creating microservices)
- Docker (optional for containerization)

