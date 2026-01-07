# 💸 Expense Tracker - Full Stack Java Application


A robust and user-friendly web application to manage daily expenses. This project demonstrates a complete Full-Stack workflow including a RESTful API and a dynamic Frontend UI.

---

## 🌟 Key Features

# 🖥️ Web Interface (Thymeleaf UI)
**Live Dashboard:** View all expenses in a clean, structured table.
**Instant Add:** Add expenses directly from the browser without needing Postman.
**Auto-Calculation:** Real-time display of the Total Sum of all added expenses.
**Easy Management:** Integrated "Delete" functionality for quick cleanup.

# ⚙️ Backend API (REST)
**CRUD** operations (Create, Read, Update, Delete).
**Validation:** Ensures data integrity using Jakarta Validation.
**H2 Database:** In-memory storage for lightning-fast testing and development.

---

# 🛠️ Tech Stack & Tools

**Framework:** Spring Boot 3.x
**Language:** Java 17
**Template Engine:** Thymeleaf (for Dynamic UI)
**ORM:** Spring Data JPA (Hibernate)
**Database:** H2 (In-memory)
**Styling:** Bootstrap 5 (CSS Framework)
**Testing:** Postman & Browser

---
# 📂 Project Structure


src/main/java/com/expense/expense_tracker/
├── controller/    # Handles Web UI & REST Endpoints
├── model/         # Database Entity (Expense.java)
├── repository/    # Database Communication (JPA)
├── service/       # Business Logic Layer
└── src/main/resources/
    ├── templates/ # HTML Files (Thymeleaf)
    └── static/    # CSS/JS files (Optional)

# 🛣️ API Documentation

# Method       Endpoint                    Description
   GET       /api/expenses         Fetch all expenses in JSON format
   POST      /api/expenses         Add a new expense 
   PUT       /api/expenses/{id}    Update an existing expense by ID
   DELETE    /api/expenses/{id}    Remove an expense from the record