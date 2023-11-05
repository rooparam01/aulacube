# Employee-Department Management System

This is a simple Employee Management System built using Spring Boot, PostgreSQL, and MongoDB.

## Overview
This project is a simple Employee Management System built using Spring Boot. It demonstrates the integration of both PostgreSQL and MongoDB databases for storing employee and department data. The application provides basic CRUD (Create, Read, Update, Delete) operations for employees and departments.

## Features

- CRUD operations for employees stored in PostgreSQL.
- CRUD operations for departments stored in MongoDB.

## Technologies Used
- Spring Boot
- PostgreSQL
- MongoDB
- JUnit (for testing)

## Project Structure
The project consists of two main entities:

### Employee (Stored in PostgreSQL):

- id: Long (Primary Key)
- firstName: String
- lastName: String
- email: String
- departmentId: String (Foreign Key)
- createdAt: Timestamp
- updatedAt: Timestamp


### Department (Stored in MongoDB):

- departmentId: String (Primary Key)
- departmentName: String
- createdAt: Timestamp
- updatedAt: Timestamp

## The Employee Management System offers the following functionalities:

- Employee Operations
- Create a new employee.
- Read employee details.
- Update employee information.
- Delete an employee.
- Department Operations
- Create a new department.
- Read department details.
- Update department information.
- Delete a department.

## Setup
Clone the repository:
git clone https://github.com/rooparam01/employee-department-management-system.git

Set up the PostgreSQL database:

Configure your PostgreSQL database connection in application.properties.
Set up the MongoDB database:

Make sure you have a running MongoDB instance.
Configure the MongoDB connection in application.properties.
Build and run the application:
- Access the application at http://localhost:8080.

## API Endpoints
### Employee CRUD:

- POST /employees - Create a new employee.
- GET /employees - Get all employee.
- GET /employees/{id} - Get employee details by ID.
- PUT /employees/{id} - Update employee information by ID.
- DELETE /employees/{id} - Delete an employee by ID.
- GET /employees/changedept/{empid}/{deptid} - Change department of Employee.
### Department CRUD:

- POST /departments - Create a new department.
- GET /departments - Get all departments.
- GET /departments/{id} - get department information by departmentId.
- PUT /departments/{id} - Update department information by departmentId.
- DELETE /departments/{id} - Delete a department by departmentId.

## Exception Handling
![Screenshot (890)](https://github.com/rooparam01/employee-department-management-system/assets/111178057/46178e20-4acb-4a52-a005-45643bac69e6)

## Swagger UI
![Screenshot (893)](https://github.com/rooparam01/employee-department-management-system/assets/111178057/b7b162ff-a1e3-47ec-9bd6-02b85029760f)
![Screenshot (892)](https://github.com/rooparam01/employee-department-management-system/assets/111178057/f9ab7fa7-a0de-4538-b766-7c34ee6b4e82)

## Unit testing
![Screenshot (894)](https://github.com/rooparam01/employee-department-management-system/assets/111178057/9cfbc2dd-1644-44f3-ae4e-06b68e3e6aa7)
![Screenshot (895)](https://github.com/rooparam01/employee-department-management-system/assets/111178057/d3ce3b79-d8ee-484d-9dbc-ac82e5e445ed)




