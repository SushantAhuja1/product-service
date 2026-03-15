# Product Service – E-commerce Microservices Platform

This repository contains the **Product Microservice** for an E-commerce Microservices Platform built using **Spring Boot**.

## Features

* Create Product
* Get All Products
* Get Product By ID
* Delete Product
* Global Exception Handling
* MySQL Database Integration

## Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA
* MySQL
* Lombok
* Maven

## API Endpoints

### Create Product

POST /products

### Get All Products

GET /products

### Get Product By ID

GET /products/{id}

### Delete Product

DELETE /products/{id}

## Project Structure

```
controller
service
service.impl
repository
entity
dto
exception
```

## Database

MySQL database used:

```
product_service
```

## Future Improvements

* DTO Layer
* Mapper
* Pagination
* Validation
* Service Discovery (Eureka)
* API Gateway
* Order Service
* Inventory Service
* Payment Service
