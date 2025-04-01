
# Come utilizzare l'immagine Spark in Docker.


```dockerfile
# Dockerfile
FROM apache/spark:latest

# Impostazione delle variabili d'ambiente
ENV SPARK_HOME=/opt/spark
ENV PATH=$PATH:$SPARK_HOME/bin

# Directory di lavoro
WORKDIR /opt/spark/work-dir

# Esporre le porte necessarie
EXPOSE 4040 7077 8080 8081

# Copiare eventuali file di configurazione
COPY spark-defaults.conf /opt/spark/conf/
COPY log4j.properties /opt/spark/conf/

# Script di avvio
CMD ["./bin/spark-shell"]

```

Per compilare:

```bash

docker build -t spark-corso:latest .

```


I passaggi per utilizzare Spark con Docker:

1. Pull dell'immagine:
```bash
docker pull apache/spark:latest
```

2. Avvio del container master:
```bash
docker run -d \
    --name spark-master \
    -p 4040:4040 \
    -p 7077:7077 \
    -p 8080:8080 \
    -e SPARK_MODE=master \
    apache/spark:latest
```

3. Avvio di uno o più worker:
```bash
docker run -d \
    --name spark-worker-1 \
    --link spark-master:spark-master \
    -p 8081:8081 \
    -e SPARK_MODE=worker \
    -e SPARK_MASTER_URL=spark://spark-master:7077 \
    apache/spark:latest
```

4. Per utilizzare docker-compose, creare un file `docker-compose.yml`:
```yaml
version: '3'
services:
  spark-master:
    image: apache/spark:latest
    ports:
      - "4040:4040"
      - "7077:7077"
      - "8080:8080"
    environment:
      - SPARK_MODE=master
    volumes:
      - ./data:/opt/spark/data
      
  spark-worker:
    image: apache/spark:latest
    depends_on:
      - spark-master
    environment:
      - SPARK_MODE=worker
      - SPARK_MASTER_URL=spark://spark-master:7077
    ports:
      - "8081-8084:8081"
```

Per avviare con docker-compose:
```bash
docker-compose up -d
```

Porte principali:
- 4040: Spark Web UI
- 7077: Spark Master
- 8080: Master Web UI
- 8081: Worker Web UI

Per accedere alla shell Spark:
```bash
docker exec -it spark-master spark-shell
```

Per verificare lo stato:
```bash
# Visualizza i log del master
docker logs spark-master

# Visualizza i log del worker
docker logs spark-worker-1

# Accedi al container
docker exec -it spark-master bash
```

