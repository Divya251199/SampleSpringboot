<h1 align = "center"> Hospital Management System </h1>

<p align="center">
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.5-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.0.6-brightgreen.svg" />
</a>
  
<a >
    <img alt="MySQL" src="https://img.shields.io/badge/MySQL-blue.svg">
</a>
</p>
The Hospital Management API is a RESTful API designed to facilitate the management of patient and doctor data and appointments in a healthcare system. It provides endpoints for patient registration, authentication, appointment booking, and retrieval of doctor information.
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
POST /patient/signup: Creates a new patient account.

POST /patient/signin: Authenticates a patient and generates an access token.

GET /patient/doctors: Retrieves a list of doctors available for appointments.

DELETE /patient/appointment: Cancels an existing appointment.

POST /doctor: Adds a new doctor to the system.

GET /doctor/{docId}/appointments: Retrieves appointments for a specific doctor.

POST /appointment: Creates a new appointment.
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
The hospital Management API is a RESTful API developed using Spring Boot, Java, and MySQL. It provides a comprehensive solution for managing patient and doctor data, as well as appointments, within a healthcare system. The API allows patients to register, sign in, book appointments with available doctors, and cancel appointments if needed. Doctors can be added to the system, and their appointment schedules can be retrieved.



## 📝 Licence
---
Copywrite © 2019  [Divya]().

This project is [MIT]() Licensed.
 
---
_This README was generated with ❤️  by [readme-md-generator]()_

