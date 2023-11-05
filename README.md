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

## Project Structure
The project consists of two main entities:

### Employee (Stored in PostgreSQL):

id: Long (Primary Key)
firstName: String
lastName: String
email: String
departmentId: String (Foreign Key)
createdAt: Timestamp
updatedAt: Timestamp


### Department (Stored in MongoDB):

departmentId: String (Primary Key)
departmentName: String
createdAt: Timestamp
updatedAt: Timestamp

## The Employee Management System offers the following functionalities:

Employee Operations
Create a new employee.
Read employee details.
Update employee information.
Delete an employee.
Department Operations
Create a new department.
Read department details.
Update department information.
Delete a department.

## Setup
Clone the repository:
git clone https://github.com/rooparam01/employee-management-system.git

Set up the PostgreSQL database:

Configure your PostgreSQL database connection in application.properties.
Set up the MongoDB database:

Make sure you have a running MongoDB instance.
Configure the MongoDB connection in application.properties.
Build and run the application:
