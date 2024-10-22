# Library-Management-System-API

# Prerequisites

Before running the project, ensure you have the following installed:
    Java 17 or higher
    Maven (for managing dependencies)
    Git (for cloning the repository)
    PostgreSQL
    
#Clone the Repository
git clone https://github.com/MazenTarek20/library-management-system.git
cd library-management-system

# Running the Application
Using PostgreSQL:

    To use a persistent database like  PostgreSQL, update the application.properties or application.yml file:
   
    spring.datasource.url=jdbc:mysql://localhost:3306/library_db
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update

    Then run the application: 
    ./mvnw spring-boot:run

   # API Endpoints
   #  Book Management

| Method | Endpoint               | Description                       |
|--------|------------------------|-----------------------------------|
| GET    | `/api/books`            | Retrieve all books               |
| GET    | `/api/books/{id}`       | Retrieve a specific book         |
| POST   | `/api/books`            | Add a new book                   |
| PUT    | `/api/books/{id}`       | Update an existing book          |
| DELETE | `/api/books/{id}`       | Remove a book from the library   |

# Example Request: Add a New Book
POST /api/books
Content-Type: application/json

{
    "title": "1984",
    "author": "Ali Mohammed",
    "isbn": "978-0451524935",
    "publicationYear": 2005
}

# Patron Management

| Method | Endpoint               | Description                       |
|--------|------------------------|-----------------------------------|
| GET    | `/api/patrons`          | Retrieve all patrons             |
| GET    | `/api/patrons/{id}`     | Retrieve a specific patron       |
| POST   | `/api/patrons`          | Add a new patron                 |
| PUT    | `/api/patrons/{id}`     | Update an existing patron        |
| DELETE | `/api/patrons/{id}`     | Remove a patron                  |

# Example Request: Add a New Patron
POST /api/patrons
Content-Type: application/json

{
    "name": "Mohammed Salah",
    "contactInfo": "mosalah@example.com"
}


# Borrowing and Returning Books

| Method | Endpoint                                        | Description                   |
|--------|-------------------------------------------------|-------------------------------|
| POST   | `/api/borrow/{bookId}/patron/{patronId}`        | Borrow a book                 |
| PUT    | `/api/return/{bookId}/patron/{patronId}`        | Return a borrowed book        |


# Example Request: Borrow a Book
POST /api/borrow/1/patron/1

# Example Request: Return a Book
PUT /api/return/1/patron/1




