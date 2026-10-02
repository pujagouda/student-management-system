# Student Management System

A full-stack Student Management System built using **Java, Spring Boot, Spring Data JPA, MySQL, React, and JavaScript**. The application allows users to manage student records through a web-based interface connected to REST APIs.

## 📌 Project Overview

This project is an upgraded version of my previous Core Java console-based Student Management System. The full-stack version provides a React frontend, a Spring Boot backend, and a MySQL database for storing and managing student information.

The application demonstrates REST API development, CRUD operations, database integration, validation, searching, sorting, and pagination.

## 🚀 Technologies Used

### Frontend

* React.js
* JavaScript
* HTML5
* CSS3
* Vite

### Backend

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* REST APIs
* Jakarta Validation
* Maven

### Database and Tools

* MySQL
* IntelliJ IDEA
* Git
* GitHub
* Postman / HTTP Client

## ✨ Features

* Add new student records
* View all students
* Search students by name
* Update student details
* Delete student records
* Prevent duplicate student IDs
* Validate student details
* Sort students by ID, name, age, or marks
* Sort in ascending and descending order
* Pagination for student records
* Search with pagination and sorting
* REST API integration between React and Spring Boot
* Store and retrieve data using MySQL and Spring Data JPA

## 📂 Project Structure

```text
student-management/
│
├── src/
│   └── main/
│       ├── java/org/example/studentmanagement/
│       │   ├── controller/
│       │   ├── entity/
│       │   ├── exception/
│       │   ├── repository/
│       │   ├── service/
│       │   ├── GlobalExceptionHandler.java
│       │   └── StudentManagementApplication.java
│       │
│       └── resources/
│           └── application.properties
│
├── student-frontend/
│   ├── public/
│   ├── src/
│   │   ├── assets/
│   │   ├── App.jsx
│   │   ├── App.css
│   │   ├── index.css
│   │   └── main.jsx
│   ├── package.json
│   └── vite.config.js
│
├── Main.java
├── Student.java
├── StudentService.java
├── pom.xml
└── README.md
```

The Java files at the root retain the earlier console-based version of the project. The Spring Boot application is in `src/`, and the React application is in `student-frontend/`.

## 🛠️ Setup and Installation

### Prerequisites

* Java JDK
* Maven (or the included Maven Wrapper)
* Node.js and npm
* MySQL Server
* IntelliJ IDEA or another suitable IDE

### 1. Clone the Repository

```bash
git clone https://github.com/pujagouda/student-management-system.git
cd student-management-system
```

### 2. Configure the MySQL Database

Create a database in MySQL:

```sql
CREATE DATABASE studentdb;
```

Configure your database connection in `src/main/resources/application.properties` with your local MySQL URL, username, and password.

Do not commit real database passwords or other secrets to GitHub.

### 3. Run the Spring Boot Backend

From the project root, run:

```powershell
.\mvnw.cmd spring-boot:run
```

The backend is configured to run at:

```text
http://localhost:8081
```

### 4. Run the React Frontend

Open another terminal and navigate to the frontend folder:

```bash
cd student-frontend
npm install
npm run dev
```

Open the local URL shown by Vite, usually:

```text
http://localhost:5173
```

Keep both the backend and frontend running while using the application locally.

## 🔗 REST API Endpoints

| Method | Endpoint                    | Description                                   |
| ------ | --------------------------- | --------------------------------------------- |
| GET    | `/students`                 | Retrieve all students                         |
| POST   | `/students`                 | Add a new student                             |
| GET    | `/students/{id}`            | Retrieve a student by ID                      |
| PUT    | `/students/{id}`            | Update student details                        |
| DELETE | `/students/{id}`            | Delete a student                              |
| GET    | `/students/search/{name}`   | Search students by name                       |
| GET    | `/students/search-page`     | Search with pagination and sorting            |
| GET    | `/students/page`            | Retrieve students with pagination             |
| GET    | `/students/page-sort`       | Retrieve students with pagination and sorting |
| GET    | `/students/sort/marks`      | Sort by marks ascending                       |
| GET    | `/students/sort/marks/desc` | Sort by marks descending                      |

### Example: Add a Student

**POST** `/students`

```json
{
  "id": 101,
  "name": "Rahul",
  "age": 21,
  "course": "Java",
  "marks": 85.5
}
```

## 🧠 Concepts Demonstrated

* Object-Oriented Programming
* Layered architecture (Controller, Service, Repository)
* RESTful web services
* Spring Dependency Injection
* Spring Data JPA and Hibernate
* MySQL database integration
* CRUD operations
* Exception handling
* Input validation
* React components and state management
* Frontend and backend integration
* Pagination and sorting

## 🔮 Future Enhancements

* User authentication and authorization
* Improved UI and responsive design
* Additional filtering and reporting
* Cloud deployment

## 👩‍💻 Author

**Puja Gouda**

GitHub: [pujagouda](https://github.com/pujagouda)

## 📌 Repository

[Student Management System – GitHub](https://github.com/pujagouda/student-management-system)
