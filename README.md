# Library Management System
## Objective
The objective of this project is to develop a library management system.

## Technologies and Architeture
The project's architecture follows a microservices-based approach using Spring Boot (**Java**) for building each service. **Kafka** is utilized for efficient message streaming between services, ensuring asynchronous and scalable communication. The entire solution is containerized using **Docker**, orchestrated via **Docker Compose**, providing a consistent and portable environment across all stages of development and deployment.

For persistent data storage, **PostgreSQL** is employed, offering robust relational database capabilities. **Redis** is integrated for caching, significantly improving the performance and reducing the load on the database by storing frequently accessed data in memory.

The front-end of the application is built as a Server Side Rendering (SSR) using **Angular**, delivering a responsive and dynamic user experience.

## Use cases

### 1. Book Management

- Description: Manage books in the library, including adding new books, updating book details, and tracking book availability.

### 2. User Management

- Description: Manage library users, including registration, profile updates, and borrowing history.

### 3. Notification System
- Description: Send notifications to users about various events, such as due dates and new books.

### 4. Search and Rating
- Description: Provide search and rating functionality for books.



