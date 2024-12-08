# Microservices Practice

This project demonstrates the practice of **Spring Boot Microservices**. The application consists of multiple microservices, with the use of a **service registry**, **API Gateway** for routing, **circuit breakers**, and **Micrometer** and **Zipkin** for distributed tracing.


## Project Structure

- **Microservice 1**: Exposed via API Gateway endpoint `http://localhost:8080/apiOne/getByAge/{age}`
- **Microservice 2**: Exposed via API Gateway endpoint `http://localhost:8080/apiTwo/test/{age}`

## Distributed Tracing with Micrometer & Zipkin

This project integrates **Micrometer** for metrics collection and **Zipkin** for distributed tracing.

### Starting Zipkin

To run Zipkin in Docker, use the following command:

```bash
docker run -d -p 9411:9411 openzipkin/zipkin
```

# Kafka Integration with Microservices

**Kafka Producer** is implemented in **Microservice 1**.  
**Kafka Consumer** is implemented in **Microservice 2**.

steps to up the docker compose file for kafka placed in deployment parent folder :
```bash
1)docker compose -f docker-compose.yml up
```
```bash
2)docker network create kafka-network
```
```bash
3)docker run -d --name zookeeper --network kafka-network -e ZOOKEEPER_CLIENT_PORT=2181 confluentinc/cp-zookeeper:latest
```
```bash
4)docker run -d --name kafka --network kafka-network -e KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 -e KAFKA_BROKER_ID=1 -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 confluentinc/cp-kafka:latest
```

## Task Progress Tracking

Here’s a summary of the tasks that have been successfully completed:

- **Flyway Database Migration**: ✅ Completed
- **Exception Handling in Spring Boot**: ✅ Completed
- **Environment-Specific Application Properties (dev, prod)**: ✅ Completed
- **API Gateway Setup**: ✅ Completed
- **Microservices Communication (A calls B)**: ✅ Completed
- **Circuit Breakers Implementation**: ✅ Completed
- **Distributed Tracing with Micrometer & Zipkin (Spring Cloud Sleuth)**: ✅ In Progress
- **Kafka Integration (Producer and Consumer)**: ✅ Completed
