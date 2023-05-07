<center>
<h1> Ecommerce Site </h1>
</center>
<center>
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.6-brightgreen.svg" />
</a>
</center>
This is a backend API built using the Spring framework that handles various HTTP requests for an Ecommerce domain. The API allows users to create accounts, add products, create orders and manage addresses

---
<br>

## Framework Used
* Spring Boot

---
<br>

## Dependencies
The following dependencies are required to run the project:

* Spring Boot Dev Tools
* Spring Web
* Spring Data JPA
* MySQL Driver
* Lombok

<br>

## Database Configuration
To connect to a MySQL database, update the application.properties file with the appropriate database URL, username, and password. The following properties need to be updated:
```
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.url = jdbc:mysql://localhost:3306/<DatabaseName>
spring.datasource.username = <userName>
spring.datasource.password = <password>
spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto = update

spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true

```
<br>

## Language Used
* Java

---
<br>

## Data Model

The Job data model is defined in the Job class, which has the following attributes:
<br>

* User Model
```
Id:integer
name:string
email:string
password:string
phoneNumber:string
```

* Product Model
```
id:integer 
name:string
price:integer
description:string
category:string
brand:string
```
* Address Model
```
id:integer    
name:string
landmark:string
phoneNumber:string
zipcode:string
state:string
UserID : foreign key mapping
```
* Order Model
```
id:integer
userID:integer (foreign key mapping)
productID:integer(foreign key mapping)
addressID:integer(foreign key mapping)
productQuantity:integer
```

## Data Flow

1. The user at client side sends a request to the application through the API endpoints.
2. The API receives the request and sends it to the appropriate controller method.
3. The controller method makes a call to the method in service class.

4. The method in service class builds logic and retrieves or modifies data from the database, which is in turn given to controller class
5. The controller method returns a response to the API.
6. The API sends the response back to the user.

---

<br>


## API End Points 

The following endpoints are available in the API:

```
/users (POST): Create a new user
/users (GET): Get user by user ID (request param)
/products (POST): Add a new product
/products (GET): Get all products (request param)
/products/{id} (DELETE): Delete a product by product ID
/products (GET): Get products based on category (request param)
/address (POST): Create a new address
/order (POST): Place a new order
/order : Get an order by order ID (request param)
```
<br>

## DataBase Used
* SQL database
```
We have used Persistent database to implement CRUD Operations.
```
---
<br>

## Project Summary

This API provides basic functionality for an Ecommerce platform, allowing users to create accounts, add products, create orders and manage addresses. The project can be extended to include additional features as required.