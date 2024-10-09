BackendAssignment

Project Overview
BackendAssignment is a template project built with Spring Boot for managing training centers. It provides RESTful APIs to create, retrieve, and manage details about various training centers, including their names,
codes, addresses, courses offered, and contact information.

Features
-REST APIs for CRUD operations on training centers.
-Integration with MySQL for data persistence.
-Validation using Spring Boot Validation.
-Database interaction using Spring Data JPA.

Technology Stack
-Java 11
-Spring Boot 2.7.18
-MySQL as the database.
-Lombok for reducing boilerplate code.

Prerequisites
-Java 11 or higher
-Maven 3.6 or higher
-System should have lombok
-MySQL Server

Setup Instructions
1. Clone the repository

2. Configure the MySQL Database
Make sure to update your MySQL database credentials in application.properties

3. Build and Run the Project
Use Maven to build and run the project

4. Access the API Documentation
Once the application is running, you can explore the available endpoints using the OpenAPI UI at:
http://localhost:8080/swagger-ui.html

5. To check apis can use postman

API Endpoints
Training Center API
Method	Endpoint	Description
POST	/api/v1/training-centers	Create a new training center
GET	/api/v1/training-centers	Retrieve all training centers


TrainingCenter Entity
centerName: Name of the training center (max 40 chars).
centerCode: Unique 12-character alphanumeric code.
address: Embedded address (detailed address, city, state, pincode).
studentCapacity: Maximum capacity of students.
coursesOffered: List of courses offered by the training center.
contactEmail: Email address for the center.
contactPhone: Phone number (10 digits).

You can use this data in post method
{
    "centerName": "Tech Training Institute",
    "centerCode": "ABC123456789",
    "address": {
        "detailedAddress": "123 Tech Street",
        "city": "Bangalore",
        "state": "Karnataka",
        "pincode": "560001"
    },
    "studentCapacity": 150,
    "coursesOffered": ["Java Programming", "Data Structures", "Web Development"],
    "contactEmail": "info@techtraining.com",
    "contactPhone": "9876543210"
}


