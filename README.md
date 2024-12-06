# Microservices_Practice
This a practice project for spring boot microservices

For calling 
microservice 1 from apigateway - http://localhost:8080/apiOne/getByAge/18

microservice 2 from apigateway - http://localhost:8080/apiTwo/test/18


using micrometer and zipkins we can see distributed tracing

zipkins run on docker run -d -p 9411:9411 openzipkin/zipkin
