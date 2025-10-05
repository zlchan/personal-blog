# Personal Blog Project (Spring Boot)

A simple personal blog application built with Spring Boot, featuring separate guest and admin sections for viewing and managing blog articles.

## 🎯 Project Overview

This is a lightweight blog system with:

- **Guest Section**: Browse and read articles
- **Admin Section**: Full CRUD operations for article management
- **File-based Storage**: Articles stored as JSON/Markdown files
- **Simple Authentication**: Basic Spring Security implementation

## 🛠️ Tech Stack

- **Backend**: Spring Boot (Java)
- **Frontend**: Thymeleaf templating engine, HTML, CSS
- **Storage**: Filesystem (JSON/Markdown files)
- **Authentication**: Spring Security with Basic Auth

## ✨ Key Features

### Guest Features

- View list of all published articles
- Read individual article details
- Public access (no authentication required)

### Admin Features

- Secure dashboard with authentication
- Create new articles
- Edit existing articles
- Delete articles
- Session-based login system

## 📁 Project Structure

```java
personal-blog/
 ├── src/main/java/com/example/blog
 │    ├── controller/         # Handles web requests
 │    │     ├── [GuestController.java](http://GuestController.java)
 │    │     ├── [AdminController.java](http://AdminController.java)
 │    │
 │    ├── service/            # Business logic
 │    │     ├── [ArticleService.java](http://ArticleService.java)
 │    │
 │    ├── model/              # Data classes
 │    │     ├── [Article.java](http://Article.java)
 │    │
 │    ├── repository/         # File operations (read/write JSON or Markdown)
 │    │     ├── [ArticleRepository.java](http://ArticleRepository.java)
 │    │
 │    ├── config/             # Authentication/session setup
 │    │     ├── [SecurityConfig.java](http://SecurityConfig.java)
 │    │
 │    └── [BlogApplication.java](http://BlogApplication.java)
 │
 ├── src/main/resources/
 │    ├── templates/          # Thymeleaf HTML templates
 │    │     ├── home.html
 │    │     ├── article.html
 │    │     ├── dashboard.html
 │    │     ├── add-article.html
 │    │     ├── edit-article.html
 │    │
 │    ├── static/             # CSS files
 │    │     ├── style.css
 │    │
 │    ├── [application.properties](http://application.properties)
 │
 └── articles/                # Directory storing article JSON/Markdown files
```

## 🚀 Getting Started

### Prerequisites

- Java 11 or higher
- Maven or Gradle
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

### Installation

1. Clone the repository

```bash
git clone [your-repository-url]
cd personal-blog
```

1. Run the application

```bash
mvn spring-boot:run
```

1. Access the application
- Guest pages: [`http://localhost:8080/`](http://localhost:8080/)
- Admin dashboard: [`http://localhost:8080/admin/dashboard`](http://localhost:8080/admin/dashboard)

### Default Admin Credentials

- **Username**: `admin`
- **Password**: `password`

## 🔗 API Endpoints

### Public Routes

- `GET /` - Home page with article list
- `GET /article/{id}` - View article details

### Admin Routes (Authentication Required)

- `GET /admin/dashboard` - Admin dashboard
- `GET /admin/add` - Add new article form
- `POST /admin/add` - Create article
- `GET /admin/edit/{id}` - Edit article form
- `PUT /admin/edit/{id}` - Update article
- `DELETE /admin/delete/{id}` - Delete article

## 🧪 Testing

### Browser Testing

1. **Guest Flow**: Navigate to [`http://localhost:8080/`](http://localhost:8080/) and browse articles
2. **Admin Flow**: Access `/admin/dashboard`, login, and test CRUD operations
3. **Authentication**: Verify unauthorized access redirects to login page

### API Testing (Postman)

Use Basic Auth with admin credentials to test REST endpoints.

## 📝 Future Enhancements

- [ ]  Add categories/tags for articles
- [ ]  Implement search functionality
- [ ]  Add article preview with content truncation
- [ ]  Migrate to database storage (MySQL/PostgreSQL)
- [ ]  Add comment system
- [ ]  Implement rich text editor

## 📄 License

[Add your license here]

## 👤 Author

Albert Chan
