# Student Management System

A full-stack Student Management System built using **Java, Spring Boot, Spring Data JPA, Hibernate, MySQL, React.js, and JavaScript**. This application provides a web-based interface to manage student records through REST APIs and a MySQL database.

This project is an upgraded version of my earlier Core Java console-based Student Management System, extended with a React frontend and a Spring Boot backend.

## 📌 Project Overview

The Student Management System helps users manage student information in one place. It provides features such as adding, viewing, updating, deleting, searching, sorting, and paginating student records.

The application follows a layered backend architecture using Controller, Service, and Repository layers. The React frontend communicates with the Spring Boot backend through REST APIs, while Spring Data JPA manages database operations with MySQL.

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
* Postman / IntelliJ HTTP Client

## ✨ Features

* Add new student records
* View all student records
* Retrieve student details by ID
* Update student information
* Delete student records with confirmation in the frontend
* Search students by name
* Prevent duplicate student IDs
* Validate student details, including name, age, course, and marks
* Sort students by ID, name, age, or marks
* Sort records in ascending and descending order
* Paginate student records
* Backend API support for searching with pagination and sorting
* REST API integration between React and Spring Boot
* Store and retrieve student records using MySQL and Spring Data JPA
* Handle application errors and validation exceptions

## 🛠️ Technologies and Concepts Demonstrated

* Object-Oriented Programming
* Layered architecture
* Spring Dependency Injection
* RESTful web services
* Spring Data JPA and Hibernate
* MySQL database integration
* CRUD operations
* Exception handling
* Jakarta Validation
* React components and state management
* Frontend and backend integration
* Pagination and sorting
* Git version control and GitHub

## 📂 Project Structure

```text
student-management/
│
├── .mvn/
│   └── wrapper/
│       └── maven-wrapper.properties
│
├── src/
│   ├── main/
│   │   ├── java/org/example/studentmanagement/
│   │   │   ├── controller/
│   │   │   │   └── StudentController.java
│   │   │   ├── entity/
│   │   │   │   └── Student.java
│   │   │   ├── exception/
│   │   │   ├── repository/
│   │   │   │   └── StudentRepository.java
│   │   │   ├── service/
│   │   │   │   └── StudentService.java
│   │   │   ├── GlobalExceptionHandler.java
│   │   │   └── StudentManagementApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── java/org/example/studentmanagement/
│           └── StudentManagementApplicationTests.java
│
├── student-frontend/
│   ├── public/
│   ├── src/
│   │   ├── assets/
│   │   ├── App.jsx
│   │   ├── App.css
│   │   ├── index.css
│   │   └── main.jsx
│   ├── eslint.config.js
│   ├── package.json
│   ├── package-lock.json
│   └── vite.config.js
│
├── Main.java
├── Student.java
├── StudentService.java
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
├── test.http
└── README.md
```

The Java files at the project root (`Main.java`, `Student.java`, and `StudentService.java`) are retained from the earlier Core Java console-based version. The Spring Boot backend is located in `src/`, and the React frontend is in `student-frontend/`.

## 🗄️ Database Configuration

The application uses **MySQL** with the database name `studentdb`.

Create the database using:

```sql
CREATE DATABASE studentdb;
```

The Spring Boot application uses the following database settings:

* Database: `studentdb`
* Database type: MySQL
* ORM: Hibernate
* Persistence framework: Spring Data JPA
* Backend port: `8081`

The database connection is configured in `src/main/resources/application.properties` using environment variables.

Example configuration:

```properties
spring.application.name=student-management

spring.datasource.url=${DB_URL:jdbc:mysql://localhost:3306/studentdb}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8081
```

**Security note:** Set `DB_USERNAME` and `DB_PASSWORD` in your local environment or IDE run configuration. Do not commit actual database credentials to GitHub.

## ⚙️ Setup and Installation

### Prerequisites

Install the following before running the application:

* Java JDK
* MySQL Server
* Node.js and npm
* IntelliJ IDEA or another Java IDE

The project includes the Maven Wrapper, so a separate Maven installation is not required.

### 1. Clone the Repository

```bash
git clone https://github.com/pujagouda/student-management-system.git
cd student-management-system
```

### 2. Configure MySQL

Start your MySQL server and create the database:

```sql
CREATE DATABASE studentdb;
```

Configure the following environment variables in your IDE run configuration or system environment:

```text
DB_URL=jdbc:mysql://localhost:3306/studentdb
DB_USERNAME=your_mysql_username
DB_PASSWORD=your_mysql_password
```

Replace the example username and password with your own local MySQL credentials.

### 3. Run the Spring Boot Backend

Open a terminal in the project root folder and run:

**Windows PowerShell:**

```powershell
.\mvnw.cmd spring-boot:run
```

The backend is configured to run at:

```text
http://localhost:8081
```

### 4. Run the React Frontend

Open a separate terminal and navigate to the frontend directory:

```bash
cd student-frontend
npm install
npm run dev
```

Vite will display a local development URL, usually:

```text
http://localhost:5173
```

Open that URL in your browser to use the application.

Keep both the Spring Boot backend and React frontend running while using the application locally.

## 🔗 REST API Endpoints

The backend provides the following REST APIs:

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
| GET    | `/students/sort/marks`      | Sort students by marks ascending              |
| GET    | `/students/sort/marks/desc` | Sort students by marks descending             |

### Example: Add a Student

**Request**

```http
POST http://localhost:8081/students
Content-Type: application/json
```

**Request body**

```json
{
  "id": 101,
  "name": "Rahul",
  "age": 21,
  "course": "Java",
  "marks": 85.5
}
```

### Example: Retrieve Students with Pagination and Sorting

```http
GET http://localhost:8081/students/page-sort?page=0&size=5&sortBy=marks&direction=desc
```

This requests the first page of student records, with five records per page, sorted by marks in descending order.

### Example: Search with Pagination and Sorting

```http
GET http://localhost:8081/students/search-page?name=Rahul&page=0&size=5&sortBy=marks&direction=desc
```

The `page` parameter is zero-based. The `size` parameter controls how many records are returned per page.

## 🖥️ Application Interface

The React frontend provides:

* A form to add or update student details
* A table to display student records
* Search controls to find students by name
* Sorting controls for supported student fields
* Pagination controls to navigate through records
* Edit and delete actions for each student

## 🔮 Future Enhancements

* User authentication and authorization
* Improved responsive user interface
* Additional filters and reports
* Cloud deployment
* Automated testing

## 👩‍💻 Author

**Puja Gouda**

GitHub: [pujagouda](https://github.com/pujagouda)

## 📌 Repository

[Student Management System – GitHub](https://github.com/pujagouda/student-management-system)
