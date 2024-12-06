# E-commerce Microservices Application

This project is the backend of an Microservices Application built with modern Java technologies and frameworks, including Spring Boot, Spring Web, Spring Data JPA, and Apache Kafka. It follows a microservices architecture, enabling scalability, modularity, and flexibility for large-scale e-commerce platforms.

## Features

- **Microservices Architecture**: Decomposed into independent, scalable services.
- **Service Discovery**: Utilizes Eureka for seamless service discovery and dynamic service registration.
- **API Gateway**: Spring Cloud Gateway handles routing, load balancing, and security for all services.
- **Distributed Tracing**: Zipkin is used for monitoring and tracing interactions between services, improving observability and troubleshooting.
- **Messaging**: Apache Kafka enables asynchronous communication between microservices.
- **Database**: Uses MySQL for persistent data storage, managed via Spring Data JPA.
- **Docker**: All services are containerized using Docker, enabling easy deployment and orchestration.

## Technologies

- **Java 17**: Programming language used for building the application.
- **Spring Boot 2.x**: Framework for building standalone applications with Spring.
- **Spring Web**: Module for building web applications and RESTful APIs.
- **Spring Data JPA**: Framework for simplifying database interactions using JPA (Java Persistence API).
- **Spring Cloud Eureka**: Service discovery tool for managing microservices.
- **Spring Cloud Gateway**: API gateway for routing and load balancing in microservices architectures.
- **Zipkin**: Distributed tracing system for monitoring and troubleshooting microservices.
- **Apache Kafka**: Distributed event streaming platform for building real-time data pipelines and streaming applications.
- **MySQL**: Relational database management system for storing application data.
- **Docker**: Platform for developing, shipping, and running applications in containers.
