<center>
<h1> Restaurant Management System </h1>
</center>
<center>
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.6-brightgreen.svg" />
</a>
</center>
This is a basic implementation of a Restaurant Management System using Spring Boot. The system allows users to sign up, sign in, and perform CRUD operations on food items. There are three types of users: admin, normal user, and visitor. The admin has additional privileges such as managing users and creating food items, while normal users can perform actions similar to visitors with some extra features.

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
* Swagger

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

* User Entity
```
id (auto-generated): The unique identifier for the user.
username: The username chosen by the user.
password: The password associated with the user's account.
email: The email address of the user.
```


* Food Entity
```
id (auto-generated): The unique identifier for the food item.
title: The title or name of the food item.
description: A brief description of the food item.
price: The price of the food item.
createdAt: The date and time when the food item was created.
dummyImageUrl: A dummy image URL associated with the food item.
```

* Order Entity
```
id (auto-generated): The unique identifier for the order.
foodItemId: The ID of the food item associated with the order.
quantity: The quantity of the food item in the order.
userId: The ID of the user who placed the order.
status: The status of the order (e.g., created, dispatched, delivered).
createdAt: The date and time when the order was created.
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


## Roles and Permissions

The system implements role-based access control with the following roles:

* ROLE_ADMIN: This role is assigned to admins and has full access to all endpoints.
* ROLE_USER: This role is assigned to normal users and has restricted access to certain endpoints.
* ROLE_VISITOR: This role is assigned to visitors and has limited access to read-only endpoints.


<br>

## DataBase Used
* SQL database

```
We have used Persistent database to implement CRUD Operations.
```
---
<br>

## Project Summary

This Restaurant Management System provides a basic implementation for managing users, food items, and orders. It incorporates authentication and authorization mechanisms to control access 
based on user roles.

<br>

## 📝 Licence
---
Copywrite © 2019 [Divya]().

This project is [MIT]() Licensed.
 
---
_This README was generated with ❤️  by [readme-md-generator]()_

