<center>
<h1> USER MANAGEMENT SYSTEM </h1>
</center>
<center>
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.5-brightgreen.svg" />
</a>
</center>
This project is a User management system built using Spring Boot with Java.

---

## Framework Used
* Spring Boot

---

## Language Used
* Java

---

## Data Model

The user data model is defined in the User class, which has the following attributes:
```
UserId : unique identifier for each user
Name : name of the user
UserName : Organisation user name
Address : address of the user
Phone Number : Phone number of the user
```

### Validation

To validate the input we get from client, we've used validation annotations that are used to enforce specific constraints on the values of the variables. These constraints ensure that the data input by the user is of the correct format and meets certain criteria.

* @Valid - In Spring Framework, the @Valid annotation is used in conjunction with @PostMapping and @PutMapping annotations, which are used to handle POST and PUT requests, respectively. When used with @PostMapping or @PutMapping, the @Valid annotation is typically applied to a method parameter annotated with @RequestBody.

* @NotEmpty: This annotation is used to validate that the annotated field is not null or empty. If the field is empty, the message "Why is id empty" will be displayed.

* @NotNull: This annotation is used to validate that the annotated field is not null.

* @Email: This annotation is used to validate that the annotated field is a valid email address.

* @NotBlank: This annotation is used to validate that the annotated field is not null, empty, or blank.

* @Pattern: This annotation is used to validate that the annotated field matches a regular expression pattern. In this case, the pattern is used to validate the format of a phone number, where the phone number must be in the format "dd/mm/yyyy" or "dd-mm-yyyy".

* @Size: This annotation is used to validate that the annotated field has a size within the specified range. In this case, the field is not used, but the annotation can be used to validate the length of a string, collection, or array.

---

## Data Flow

1. The user sends a request to the application through the API endpoints.
2. The API receives the request and sends it to the appropriate controller method.
3. The controller method makes a call to the method in service class.

4. The method in service class builds logic and retrieves or modifies data from the database, which is in turn given to controller class
5. The controller method returns a response to the API.
6. The API sends the response back to the user.

---

## Functions used :-

### API Endpoints :-
</br>
<b> Add User </b>

* PostMapping: /addUser
```
This endpoint makes a call to method in userService class which is connected to database. In database we add a new user given through API.
```

* GetMapping: /getAllUser
```
This endpoint makes a call to method in userService class which retrieves data of all users from database. This data is sent to controller which is then sent through the API to client.
```

* GetMapping: "getUser/{userid}"
```
This endpoint returns data of specific user based on userid through API
```

* PutMapping
```
This endpoint makes a call to method in userService class which is connected to database. In database we update a user by userid given through API.
```

* DeleteMapping
```
This endpoint makes a call to method in userService class which is connected to database. In database we delete a user by userid given through API.
```

---

## Data structure Used
* ArrayList
```
We have used ArrayList data structure as a database to implement CRUD Operations 
```
---

## Project Summary

The User Management System is a Spring Boot project written in Java that enables basic functionality for managing users. This project is built using the Spring Boot framework, which is a popular open-source framework for building production-ready applications. The project uses ArrayList as the data structure to store and manage user data.

The project includes four main components, the UserManagementController, the UserService, the UserDao, and the User class. The UserController class receives requests from the user interface layer and delegates them to the UserService. The UserService processes the request and retrieves or updates data from the UserDao. The UserDao uses an ArrayList data structure to store and manage user data, and the User class defines the user data model.
