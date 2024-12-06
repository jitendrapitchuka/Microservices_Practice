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
