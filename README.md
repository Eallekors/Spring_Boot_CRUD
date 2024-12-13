# User Management Service

This project is a user management service for a application, built using **Spring Boot** and **Hibernate** for handling user data, with MySQL as the database. 
## Features

- **User Create, read, update and delete**:  Users can create data, have access to the data in the UI by reading the data, update or edit the data, and delete the data.
- **Error Handling**: Error handling for invalid inputs and system exceptions.

## Technologies Used

- **Spring Boot**: For building the RESTful service.
- **Hibernate**: For ORM-based database interactions.
- **MySQL**: Used as the relational database to store user information.
- **Spring Data JPA**: For managing entities and repositories.


## Prerequisites

- **JDK 11 or higher**
- **MySQL** database
- **Maven** for building the project

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Eallekors/Spring_Boot_CRUD

2. Navigate to the project directory:

```bash

cd Spring_Boot_CRUD
```
3. Configure MySQL:

  Create a new database called userdb.
  Update the application.properties file with your MySQL credentials.

4. Install project dependencies using Maven:

```bash

mvn clean install
```
5. Run the application:

```bash

mvn spring-boot:run
```
The application should now be running at http://localhost:8080.
