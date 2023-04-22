<center>
<h1> URL-Hit-Counter </h1>
</center>
<center>
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.5-brightgreen.svg" />
</a>
</center>
This project is a URL Hit counter system built using Spring Boot with Java.

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
UserName : Name of the user
UrlHitCount : count of the times user hit url
```

---

## Data Flow

1. The user sends a request to the application through the API endpoints.
2. The API receives the request and sends it to the appropriate controller method.
3. The controller method makes a call to the method in service class.

4. The method in service class builds logic and retrieves and modifies data from the database, which is in turn given to controller class
5. The controller method returns a response to the API.
6. The API sends the response back to the user.

---

## Functions used :-

### API Endpoints :-
</br>
<b> count </b>

* GetMapping: /count
```
This endpoint makes a call to method in userService class which retrieves data of user from database and updates urlHitCount by adding 1. This data is sent to controller which is then sent through the API to client.
```

* GetMapping: "/username/{username}/count"
```
This endpoint returns data of specific user based on username through API
```

---

## Data structure Used
* HashMap
```
We have used HashMap data structure as a database to get, add and update data in database 
```
---

## Project Summary

This is a simple Spring Boot project that implements a URL hit counter. The application keeps track of the number of times a specific URL is accessed and also provides an additional feature to show the hit count for a specific username.

### Usage
Once the application is running, you can access the following URLs to test the functionality:

http://localhost:8080/api/v1/visitor-count-app/count - This URL will increment the hit count for the entire application.

http://localhost:8080/api/v1/visitor-count-app/username/{username}/count - This URL will show the hit count for the specified username.


#### Incrementing the Hit Count
To increment the hit count for the entire application, simply access the following URL in your web browser or a tool like Postman: 
```
http://localhost:8080/api/v1/visitor-count-app/count
```
Each time you access this URL, the hit count will be incremented.

#### Showing the Hit Count for a Specific User
To show the hit count for a specific user, access the following URL in your web browser or a tool like Postman:
```
http://localhost:8080/api/v1/visitor-count-app/username/{username}/count
```
Replace {username} with the actual username you want to check the hit count for. For example:
```
http://localhost:8080/api/v1/visitor-count-app/username/Divya/count
``` 
This will return a JSON object with the hit count for the specified user:

```
{
  "username": "Divya",
  "hitcount": 3
}
```