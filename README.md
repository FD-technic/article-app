# Article Publishing App

Simple web application for publishing articles.

The project was created as a learning project while studying web application development with **Java** and **Spring Boot**.

## Features

* create and publish articles
* display a list of published articles
* view article details
* simple server-side rendering using Thymeleaf

## Technologies

* Java
* Spring Boot
* Thymeleaf
* MySQL
* HTML
* CSS

## Project Structure

```
src
 └─ main
     ├─ java
     │   └─ controllers
     ├─ resources
     │   ├─ templates
     │   └─ static
```

* **templates** – Thymeleaf HTML templates
* **static** – CSS and other static resources

## Database

The application uses a MySQL database for storing articles.

Typical configuration in application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/article_app
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

## Running the application

1. Clone the repository

```
git clone https://github.com/FD-technic/article-app
```

2. Go to the project directory

```
cd article-app
```

3. Run the application

```
./mvnw spring-boot:run
```

or run the main class from your IDE.

4. Open the browser

```
http://localhost:8080
```

## Purpose

This project serves mainly as a **learning example** for working with:

* Spring Boot controllers
* Thymeleaf templates
* MySQL database
* basic web application structure

## License

MIT License
