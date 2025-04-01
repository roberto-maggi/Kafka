
## Esempio 

```shell

docker network create net-kafka
# alternativa come immagine: apache/kafka-native:3.9.0
docker run -d --hostname kafka01 --name kafka01 -p 9092:9092 --network net-kafka apache/kafka:3.9.0

# ALTRO TERMINALE PER CREAZIONE TOPIC e PRODUCER
docker exec -it kafka01 /bin/bash
# nel ALTRO TERMINALE kafka
cd opt/kafka/
bin/kafka-topics.sh --create --topic test-corso --bootstrap-server localhost:9092
bin/kafka-topics.sh --describe --topic test-corso --bootstrap-server localhost:9092
bin/kafka-console-producer.sh --topic test-corso --bootstrap-server localhost:9092

# ALTRO TERMINALE PER CONSUMER
docker exec -it kafka01 /bin/bash
cd /opt/kafka/
bin/kafka-console-consumer.sh --topic test-corso --from-beginning --bootstrap-server localhost:9092


# TEMINALE PER ENTRARE COME ROOT
docker exec -u root -it kafka01 /bin/bash
apk update
apk search htop
apk add htop
apk add nano

# ALTRO TERMINALE PER PRODUCER CONNECT 2
docker exec -it kafka01 /bin/bash
cd /opt/kafka/
echo "plugin.path=libs/connect-file-3.9.0.jar" >> config/connect-standalone.properties
echo -e "msg1\nmsg2\nmsg3\nmsg3\nmsg4\nmsg5\nmsg6\nmsg7\nmsg8\nmsg9\nmsg10\nmsg11" > test.txt
bin/connect-standalone.sh config/connect-standalone.properties config/connect-file-source.properties config/connect-file-sink.properties

# ALTRO TERMINALE PER PRODUCER CONNECT 2
docker exec -it kafka01 /bin/bash
cd /opt/kafka/
# per aggiungere, dopo aver creato il consumer 2, nuovi messaggi
echo "altro messaggio" >> test.txt

# ALTRO TERMINALE PER CONSUMER 2
docker exec -it kafka01 /bin/bash
cd /opt/kafka/
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic connect-test --from-beginning 

```

## Esempio di uso env

```env

KAFKA_BROKER_ID=1
KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181
KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092

```


```yml

version: '3'
services:
  kafka:
    image: confluentinc/cp-kafka:latest
    env_file:
      - .env
    ports:
      - "9092:9092"
    depends_on:
      - zookeeper
    environment:
      KAFKA_ZOOKEEPER_CONNECT: ${KAFKA_ZOOKEEPER_CONNECT}
      KAFKA_BROKER_ID: ${KAFKA_BROKER_ID}
      KAFKA_ADVERTISED_LISTENERS: ${KAFKA_ADVERTISED_LISTENERS}

  zookeeper:
    image: confluentinc/cp-zookeeper:latest
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
    ports:
      - "2181:2181"

```

```shell
docker run --env-file .env -p 9092:9092 confluentinc/cp-kafka:latest
```
