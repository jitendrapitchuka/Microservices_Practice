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

### Redis Implementation (Redis-Practise Module)

1. **Start Redis container**:
    ```bash
    docker run --name my-redis -p 6379:6379 -d redis
    ```

2. **Access Redis CLI**:
    ```bash
    docker exec -it my-redis sh
    ```

3. **In Redis CLI**:
    ```bash
    redis-cli
    keys product:*
    FLUSHDB
    keys GetProduct:*
    ```

In the **Product Service**, I have implemented caching. The first time a product is fetched using its ID, it will take around 10 seconds (due to a simulated delay). However, subsequent fetches for the same product will be much faster because the result is cached in Redis.

---

## Task Progress Tracking

Here’s a summary of the tasks that have been successfully completed:

- **[Flyway Database Migration](https://github.com/jitendrapitchuka/flyway_example_springboot)**: ✅ Completed
- **Exception Handling in Spring Boot**(In MicroService-1): ✅ Completed
- **Environment-Specific Application Properties (dev, prod)** (Not included in this project): ✅ Completed
- **API Gateway Setup**: ✅ Completed
- **Microservices Communication (A calls B using RestTemplate and openFeign)**: ✅ Completed
- **Circuit Breakers Implementation**: ✅ Completed
- **Distributed Tracing with Micrometer & Zipkin (Spring Cloud Sleuth)**: ✅ Completed
- **Kafka Integration (Producer and Consumer)**: 🔄 Completed
- **Redis Implementation (Caching in Product Service)**: 🔄 In Progress
