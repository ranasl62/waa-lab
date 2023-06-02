**Hibernate and Spring Boot Application**

This is a sample project demonstrating the integration of Hibernate and Spring Boot. The project showcases how to build a RESTful API using Spring Boot and interact with a PostgreSQL database using Hibernate.

Prerequisites
Before running the application, ensure you have the following installed:

Java Development Kit (JDK) 8 or above
Docker (for running PostgreSQL and pgAdmin)
Setup
Follow the steps below to set up and run the application:

Clone the repository to your local machine:

`git clone https://github.com/ranasl62/waa-lab
`

Start the PostgreSQL and pgAdmin containers using Docker Compose. Run the following command in the project root directory:


`docker-compose up -d`


This will start the PostgreSQL database and pgAdmin tool.

Build and run the Spring Boot application:

`./mvnw spring-boot:run`


This will build the application and start the Spring Boot server.

Once the application is running, you can access the API endpoints using Postman or any other REST client. Please refer to the Postman collection for the available API endpoints and their documentation.
Postman Collection
The Postman collection is available here. It provides a comprehensive list of API endpoints along with request and response examples. To use the collection, import it into Postman and replace {{base_url}} with the appropriate host and port of your running Spring Boot application. Additionally, replace {{api_version}} with v2 if you want to use the version 2 API.

PostgreSQL and pgAdmin
The provided Docker Compose file sets up a PostgreSQL database and pgAdmin tool for easy database administration. The database is accessible at localhost:5432, and pgAdmin can be accessed at localhost:5050. Use the following credentials for pgAdmin:

Email: admin@localhost
Password: admin
You can configure the database connection in the pgAdmin interface to manage the PostgreSQL database.

Conclusion
This project demonstrates the integration of Hibernate and Spring Boot for building a RESTful API. It also provides a Docker Compose file to set up a PostgreSQL database and pgAdmin tool for easy database management. Feel free to explore and modify the project according to your requirements. If you have any questions, refer to the documentation or reach out to the project maintainers.