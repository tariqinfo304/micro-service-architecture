# Microservice Architecture

This project demonstrates a complete microservice architecture built with Spring Cloud and Spring Boot 3. The architecture includes service discovery, centralized configuration, API gateway, distributed tracing, and multiple microservices.

## 🏗️ Architecture Overview

```
┌─────────────────┐    ┌──────────────────┐    ┌─────────────────┐
│   API Gateway   │    │  Eureka Server   │    │  Config Server  │
│   (Port 8080)   │◄──►│   (Port 8761)    │◄──►│   (Port 8888)   │
└─────────────────┘    └──────────────────┘    └─────────────────┘
         │                         │                       │
         ▼                         ▼                       ▼
┌─────────────────┐    ┌──────────────────┐    ┌─────────────────┐
│   User Service  │    │ Product Service  │    │   Config Repo   │
│   (Port 8081)   │    │   (Port 8082)    │    │   (Git/Local)   │
└─────────────────┘    └──────────────────┘    └─────────────────┘
         │                         │
         ▼                         ▼
┌─────────────────────────────────────────────────────────────┐
│                    Zipkin (Port 9411)                       │
│                Distributed Tracing Server                  │
└─────────────────────────────────────────────────────────────┘
```

## 🛠️ Technology Stack

- **Framework**: Spring Boot 3.3.2
- **Language**: Java 17
- **Spring Cloud**: 2023.0.2
- **Service Discovery**: Netflix Eureka
- **API Gateway**: Spring Cloud Gateway
- **Configuration Management**: Spring Cloud Config
- **Distributed Tracing**: Micrometer + Zipkin
- **Database**: H2 (In-memory, for demo purposes)
- **Documentation**: OpenAPI/Swagger

## 🔧 Services

### 1. API Gateway (`api-gateway`)
- **Port**: 8080
- **Purpose**: Single entry point for all client requests
- **Features**:
  - Route requests to appropriate microservices
  - Load balancing with `lb://` protocol
  - Path-based routing (`/user/**` → user-service, `/product/**` → product-service)
  - Service discovery integration

### 2. Eureka Server (`eureka-server`)
- **Port**: 8761
- **Purpose**: Service discovery and registration
- **Features**:
  - Service registry for all microservices
  - Health monitoring
  - Load balancer integration

### 3. Config Server (`config-server`)
- **Port**: 8888
- **Purpose**: Centralized configuration management
- **Features**:
  - Externalized configuration for all services
  - Git repository integration for config storage
  - Environment-specific configurations

### 4. User Service (`user-service`)
- **Port**: 8081
- **Purpose**: User management functionality
- **Features**:
  - User CRUD operations
  - Spring Data JPA with H2 database
  - Feign client for inter-service communication
  - Swagger/OpenAPI documentation

### 5. Product Service (`product-service`)
- **Port**: 8082
- **Purpose**: Product management functionality
- **Features**:
  - Product CRUD operations
  - Service discovery integration
  - RESTful API endpoints

### 6. Config Repository (`config-repo`)
- **Purpose**: Git repository containing configuration files
- **Files**:
  - `application.yml` - Common configuration
  - `user-service.yml` - User service specific config
  - `product-service.yml` - Product service specific config
  - `api-gateway.yml` - API Gateway configuration

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Git

### Running the Services

1. **Start Eureka Server** (Service Discovery)
```bash
cd eureka-server
mvn spring-boot:run
```
Eureka Dashboard: http://localhost:8761

2. **Start Config Server**
```bash
cd config-server
mvn spring-boot:run
```
Config Server: http://localhost:8888

3. **Start User Service**
```bash
cd user-service
mvn spring-boot:run
```
User Service: http://localhost:8081

4. **Start Product Service**
```bash
cd product-service
mvn spring-boot:run
```
Product Service: http://localhost:8082

5. **Start API Gateway**
```bash
cd api-gateway
mvn spring-boot:run
```
API Gateway: http://localhost:8080

6. **Start Zipkin (Distributed Tracing)**
```bash
sudo docker run -d -p 9411:9411 openzipkin/zipkin
```
Zipkin UI: http://localhost:9411

## 🌐 API Endpoints

### Via API Gateway
- **User Service**: `http://localhost:8080/user/**`
- **Product Service**: `http://localhost:8080/product/**`

### Direct Service Access
- **User Service**: `http://localhost:8081/swagger-ui.html`
- **Product Service**: `http://localhost:8082/swagger-ui.html`

## 🔍 Service Discovery

All services register themselves with Eureka Server. You can view registered services at:
- **Eureka Dashboard**: http://localhost:8761

## ⚙️ Configuration

Configuration is centralized in the `config-repo` directory:
- **Common Config**: `application.yml`
- **Service Specific**: `{service-name}.yml`

## 🔗 Inter-Service Communication

- Services use Eureka for service discovery
- Feign clients for type-safe HTTP communication
- Load-balanced RestTemplate for HTTP calls
- Distributed tracing with Micrometer and Zipkin

## 📊 Monitoring & Observability

- **Health Checks**: Available via Spring Boot Actuator
- **Distributed Tracing**: Zipkin integration for request tracing
- **Service Registry**: Eureka dashboard for service monitoring

## 🏗️ Architecture Patterns

1. **Service Registry Pattern** - Eureka for service discovery
2. **API Gateway Pattern** - Spring Cloud Gateway for request routing
3. **Configuration Server Pattern** - Centralized config management
4. **Circuit Breaker Pattern** - Ready for implementation with Hystrix/ Resilience4j
5. **Distributed Tracing** - End-to-end request tracing

## 🚀 Production Considerations

For production deployment, consider:

1. **Database**: Replace H2 with PostgreSQL/MySQL
2. **Service Discovery**: Use multiple Eureka instances
3. **Configuration**: Use Git repository for config storage
4. **Security**: Add OAuth2/JWT authentication
5. **Circuit Breaker**: Implement Hystrix/Resilience4j
6. **Containerization**: Add Docker support
7. **Orchestration**: Use Kubernetes for deployment
8. **Monitoring**: Add Prometheus and Grafana
9. **Logging**: Centralized logging with ELK stack

## 📚 Further Reading

- [Spring Cloud Documentation](https://spring.io/projects/spring-cloud)
- [Spring Cloud Gateway](https://spring.io/projects/spring-cloud-gateway)
- [Netflix Eureka](https://github.com/Netflix/eureka)
- [Spring Cloud Config](https://spring.io/projects/spring-cloud-config)
- [Micrometer Tracing](https://micrometer.io/docs/tracing)
- [Zipkin Documentation](https://zipkin.io/)