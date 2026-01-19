# Placement Portal – Backend System

A backend system that models a real-world college placement portal similar to those used in universities and large hiring platforms.

This project is being built with a focus on **clean domain modeling**, **business rules**, and **real backend architecture**, not just CRUD APIs.

---

##  Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- Maven
- MySQL (planned)
- Git & GitHub

---

## Domain Overview

The system models the complete placement workflow:

### Core Entities
- **User** – Base identity for all system actors
- **Student** – A student who applies for jobs
- **Company** – Organization offering jobs
- **Recruiter** – Company representative who manages hiring
- **Job** – A job opening created by a company
- **Application** – Bridge between Student and Job, holding application state
- **Interview** – Multiple interview rounds per application
- **Offer** – Final offer generated after successful interviews

---

##  Key Relationships
- One **Student** can apply to many **Jobs**
- One **Job** can have many **Applications**
- Each **Application** belongs to exactly one Student and one Job
- One **Application** can have multiple **Interviews**
- One **Application** can result in at most one **Offer**

---

## ️ Business Rules Implemented
- Students can only apply to OPEN jobs
- Duplicate applications are prevented
- CGPA eligibility is validated before application
- Application status lifecycle is enforced (APPLIED → SHORTLISTED → etc.)

---

##  Architecture
- **Controller layer** – handles HTTP requests (planned)
- **Service layer** – contains business logic and validations
- **Repository layer** – database access using Spring Data JPA
- **Entity layer** – core domain models

---

##  Project Status
- Domain modeling completed
- Service layer logic implemented for job application flow
- Controller and API layer to be implemented next

---

##  Goal
To build a production-style backend project that reflects **real engineering practices** used in MAANG-level product companies.
