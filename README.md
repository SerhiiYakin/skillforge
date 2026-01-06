# SkillForge

SkillForge is a full-stack mentorship and learning platform designed to connect mentors and learners through structured interaction and progress tracking.

The project is built as a real-world full-stack application using modern backend, frontend, and cloud technologies.

🔗 Repository: https://github.com/SerhiiYakin/skillforge

---

## Tech Stack

### Backend
- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- PostgreSQL

### Frontend
- React
- Material UI

### Infrastructure
- Docker
- AWS (EC2, RDS)

---

## Project Goal

The main goal of SkillForge is to practice and demonstrate:
- full-stack application development
- clean backend architecture
- interaction between frontend and backend via REST APIs
- containerization and cloud deployment
- engineering decisions behind real-world systems

This project is developed as a long-term learning and portfolio project.

---

## High-Level Architecture

SkillForge follows a classic full-stack architecture:

- **Frontend** communicates with the backend via REST APIs
- **Backend** handles business logic, authentication, and data persistence
- **Database** stores users, mentorship data, and progress information
- **Docker** is used to containerize services
- **AWS** is used for deployment and hosting

---

## Backend Structure

The backend is organized using a layered architecture:

- **controllers** – REST API endpoints and request handling
- **services** – business logic and application rules
- **repositories** – database access via Spring Data JPA
- **entities** – domain models
- **dto** – data transfer objects for API communication
- **enums** – application-level enums

This structure improves readability, maintainability, and scalability.

---

## Engineering Decisions

Some of the key engineering decisions made in this project:

- Separation of concerns between controllers, services, and repositories
- Usage of DTOs to decouple API contracts from internal entities
- RESTful API design for frontend-backend communication
- Containerization with Docker to simplify deployment
- Cloud deployment using AWS to simulate a production-like environment

---

## Current Features

- User authentication and authorization
- Mentor and learner roles
- Mentorship-related data management
- REST API for frontend integration
- Basic frontend interface using React

---

## Future Improvements

Planned improvements for the project include:

- Improved security and authentication flows
- Role-based access control
- Advanced mentorship workflows
- CI/CD pipeline
- Monitoring and logging
- UI/UX improvements

---

## Status

🚧 SkillForge is under active development and continuously evolving as new features and improvements are added.
