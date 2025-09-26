# Modern Web Application

A modern Spring Boot application built with Kotlin, featuring a responsive web interface and REST API endpoints.

## 🚀 Features

- **Modern Tech Stack**: Spring Boot 3.5.3, Kotlin 2.2.10, Java 21 LTS
- **Responsive UI**: Bootstrap 5.3.3 with modern design
- **REST API**: JSON endpoints with timestamp support
- **Statistics Dashboard**: Interactive chart showing greeting frequency per user (Chart.js)
- **Health Monitoring**: Spring Boot Actuator for application health
- **Live Development**: Spring Boot DevTools for automatic reload
- **Interactive HTTP Debugging**: Client-side HTTP request/response visualization
- **Containerization**: Docker support with multi-stage builds
- **Comprehensive Testing**: Unit, integration, and MVC tests
- **Modern Kotlin**: Constructor injection, data classes, and modern syntax

## 🛠️ Technology Stack

- **Backend**: Spring Boot 3.5.3
- **Language**: Kotlin 2.2.10
- **Java Version**: 21 LTS
- **Frontend**: Bootstrap 5.3.3, Thymeleaf
- **Build Tool**: Gradle 9.0.0
- **Testing**: JUnit 5, AssertJ, MockMvc
- **Containerization**: Docker
- **Database**: PostgreSQL (production), H2 in-memory (tests)

## 📋 Prerequisites

- Java 21 or higher
- Gradle 9.0.0 or higher
- Docker and Docker Compose

## 🏃‍♂️ Quick Start

### Running the Application

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd template-lab1-git-race
   ```

2. **Run the application**

   docker-compose -f docker-compose.dev.yml up --build -d

4. **Access the application**
   - Web Interface: http://localhost:8080
   - API Endpoint: http://localhost:8080/api/hello
   - Health Check: http://localhost:8080/actuator/health
   - stats : http://localhost:8080/stats
### Using Docker for Development

1. **Using Docker Compose** (Recommended):
   ```bash
   docker-compose -f docker-compose.dev.yml up --build
   ```

2. **Build and run development container**:
   ```bash
   docker build -f Dockerfile.dev -t modern-web-app-dev .
   docker run -p 8080:8080 -p 35729:35729 -v $(pwd):/app modern-web-app-dev
   ```

The development Docker setup includes:
- **LiveReload Support**: Automatic browser refresh on code changes
- **Volume Mounting**: Source code changes are immediately reflected
- **Spring Boot DevTools**: Automatic application restart on file changes
- **Health Monitoring**: Built-in health checks via Spring Boot Actuator

## 🧪 Testing

Run all tests:
```bash
./gradlew test
```

Run specific test classes:
```bash
./gradlew test --tests "HelloControllerUnitTests"
./gradlew test --tests "IntegrationTest"
./gradlew test --tests "GreetingControllerIntegrationTest"
./gradlew test --tests "GreetingControllerUnitTest"
```

## 📡 API Endpoints

### Web Endpoints
- `GET /` - Main web page with interactive HTTP debugging tools
- `GET /?name={name}` - Personalized greeting page
- `GET /stats` - Statistics dashboard showing greeting frequency per user 

### REST API Endpoints
- `GET /api/hello` - Returns JSON greeting with timestamp
- `GET /api/hello?name={name}` - Returns personalized JSON greeting


### Monitoring Endpoints
- `GET /actuator/health` - Application health status
- `GET /actuator/info` - Application information
- `GET /actuator/metrics` - Application metrics
- `GET /api/greeting/save?name={name}` - Saves a greeting and returns JSON with message and timestamp
- `GET /api/greeting/history` - Returns a list of all saved greetings

### Interactive HTTP Debugging
- **Web Page Testing**: Test the main page with personalized greetings
- **API Testing**: Test REST endpoints with real-time request/response display
- **Health Check Testing**: Monitor application health status
- **Live Reload**: Spring Boot DevTools automatically reloads on file changes

## 🏗️ Project Structure

```
src/
├── main/
│   ├── kotlin/
│   │   ├── controller/
│   │   │   └── HelloController.kt      # Web and API controllers
│   │   ├── entity/
│   │   │   └── Greeting.kt      # Web and API controllers
│   │   ├── repository/
│   │   │   └── GreetingRepository.kt      # Web and API controllers
│   │   ├── service/
│   │   │   └── GreetingService.kt      # Web and API controllers
│   └── resources/
│       ├── application.properties      # Application configuration
│       ├── templates/
│       │   └── welcome.html           # Thymeleaf template
│       └── public/
│           └── assets/
│               └── logo.svg           # Application logo
└── test/
    └── kotlin/
        ├── controller/
        │   ├── HelloControllerUnitTests.kt    # Unit tests
        │   └── HelloControllerMVCTests.kt     # MVC tests
        │   ├── GreetingControllerIntegrationTest.kt    
        │   └── GreetingControllerUnitTest.kt
        └── IntegrationTest.kt                 # Integration tests
```

## ⚙️ Configuration

Key configuration options in `application.properties`:

```properties
# Application settings
spring.application.name=modern-web-app
server.port=8080

# Custom message
app.message=Welcome to the Modern Web App!

# Actuator endpoints
management.endpoints.web.exposure.include=health,info,metrics
```

## 🐳 Docker Details

The application includes a development-focused Docker setup:

- **Development Dockerfile**: Uses JDK 21 Alpine for development with live reload
- **Docker Compose**: Orchestrates the development environment with volume mounting
- **LiveReload**: Spring Boot DevTools automatically reloads on file changes
- **Volume Mounting**: Source code changes are immediately reflected in the container
- **Health Checks**: Built-in health monitoring via Spring Boot Actuator
- **Development Tools**: Includes wget for health checks and debugging utilities

## 🔧 Development

### Adding New Features

1. **Controllers**: Add new endpoints in the controller package
2. **Templates**: Add new Thymeleaf templates in `src/main/resources/templates/`
3. **Tests**: Add corresponding tests in the test package
4. **Configuration**: Update `application.properties` for new settings

### Code Style

- Use modern Kotlin features (constructor injection, data classes)
- Follow Spring Boot best practices
- Write comprehensive tests for all functionality
- Use descriptive test method names with backticks

## 📊 Monitoring

The application includes Spring Boot Actuator for monitoring:

- **Health**: Application and dependency health status
- **Info**: Application metadata and build information
- **Metrics**: JVM and application metrics

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Ensure all tests pass
6. Submit a pull request

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🆕 What's New in This Modern Version

- ✅ Upgraded to Java 21 LTS for better performance
- ✅ Modern Kotlin syntax with constructor injection
- ✅ Separated web and API controllers for better organization
- ✅ Added comprehensive test coverage
- ✅ Implemented Spring Boot Actuator for monitoring
- ✅ Created responsive Bootstrap 5.3.3 UI
- ✅ Added Docker support with multi-stage builds
- ✅ Fixed Bootstrap version inconsistencies
- ✅ Enhanced error handling and validation
- ✅ Added interactive features and API endpoints
- ✅ Introduced greeting persistence and a statistics dashboard (Chart.js)