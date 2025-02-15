# Backend Training-Center-Registry Application


This is a Spring Boot application that provides APIs to register and retrieve government-funded training centers.

## 📌 Features
1)  Register a new Training Center (POST API)  
2)  Fetch all stored Training Centers (GET API)  
3)  Validations for required fields (Email, Phone, etc.)   
4)  Data stored in MySQL

## 📌 Tech Stack
- Java 21
- Spring Boot 3.4.2
- Spring Data JPA
- Spring Validation
- MySQL
- Lombok
- Maven

## 📌 Setup Instructions

###  Clone the Repository

git clone https://github.com/Jaykolhe/Backend_Traini8_Jaykolhe.git
cd Traini8RegistryApplication


## Configure Database
### application.properties file
```json
spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```
###  Build and Run
1) mvn clean install 
2) mvn spring-boot:run


## 📌 API Documentation

### 1) Register Training Center (POST)
- **URL:** http://localhost:8081/api/training-centers/register
- **Method:** POST
- **Request Body (JSON):**  
```json 
  {
  "centerName": "Tech Learning School",
  "centerCode": "ABC123XYS149",
  "studentCapacity": 100,
  "detailedAddress": "123 Main Street, Near City Mall",
  "city": "Bangalore",
  "state": "Karnataka",
  "pincode": "560001",
  "contactEmail": "infok@techlearning.com",
  "contactPhone": "9976542130",
  "courses": ["Java", "Spring Boot", "Microservices"]
  }
```


- **Response (Success - 200 OK):**  
  ```json {
  "id": 1,
  "centerName": "Tech Learning School",
  "centerCode": "ABC123XYS149",
  "studentCapacity": 100,
  "createdOn": 1739593895959000,
  "address": {
  "detailedAddress": "123 Main Street, Near City Mall",
  "city": "Bangalore",
  "state": "Karnataka",
  "pincode": "560001"
  },
  "contactInfo": {
  "contactEmail": "infok@techlearning.com",
  "contactPhone": "9876542130"
  },
  "courses": [
  "Java",
  "Spring Boot",
  "Microservices"
  ]
  }
  ```

### 2️) Get All Training Centers (GET)
- **URL:** http://localhost:8081/api/training-centers/getAllTrainingCenters
- **Method:** GET
- **Response (Success - 200 OK):**  
```json
[
{
"id": 1,
"centerName": "Tech Learning School",
"centerCode": "ABC123XYZ249",
"studentCapacity": 100,
"createdOn": 1739591422409000,
"address": {
"detailedAddress": "123 Main Street, Near City Mall",
"city": "Bangalore",
"state": "Karnataka",
"pincode": "560001"
},
"contactInfo": {
"contactEmail": "info@techlearning.com",
"contactPhone": "9876543210"
},
"courses": [
"Java",
"Spring Boot",
"Microservices"
]
},
  {
    "id": 2,
    "centerName": "CodeMaster Institute",
    "centerCode": "XYZ789LMN456",
    "studentCapacity": 150,
    "createdOn": 1739591443115000,
    "address": {
      "detailedAddress": "45 Tech Park Road, Near Metro Station",
      "city": "Hyderabad",
      "state": "Telangana",
      "pincode": "500081"
    },
    "contactInfo": {
      "contactEmail": "contact@codemaster.com",
      "contactPhone": "9123456789"
    },
    "courses": [
      "Python",
      "Django",
      "Cloud Computing"
    ]
  }

]
```

### 📌 API Testing (Postman)
- Import the APIs into Postman using the request details above.
- Use JSON format to send data.
- Verify validation errors with incorrect inputs.



