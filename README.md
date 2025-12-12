# 📝 To-Do List Console Application (Java)

A clean, beginner-friendly **Java console-based To-Do List Application** built using Object-Oriented Programming (OOP) principles.  
This project allows users to **add, view, update, and delete tasks** using a simple menu-driven interface.

Developed as part of the **Cognetix Technology Java Developer Internship**.

---

## 🚀 Features

### ✔ Add Task
- Accepts a short description  
- Automatically assigns status: **Pending**
- Validates empty or whitespace-only input

### ✔ View All Tasks
**Displays:**
- Task Index  
- Description  
- Status (**Pending / Completed**)

### ✔ Update Task Status
- Toggle task state  
- Pending → Completed  
- Completed → Pending  
- Shows confirmation message

### ✔ Delete Task
- Delete by index  
- Shows: *"Task deleted successfully!"*

### ✔ Multi-Task Support
**Uses:**
```java
* ArrayList<Task> tasks = new ArrayList<>();
```

### 🧱 Project Structure
src/
 └── com/todolist/
     ├── Task.java
     ├── TaskManager.java
     └── Main.java

### 🛠 Technologies Used

* Java 8 / Java 11
* OOP Concepts
* ArrayList Collection
* Scanner for user input
* Clear modular design
### 📌 Validations Implemented

|  Input           | Validation Rule               |
| ---------------- | ----------------------------- |
| Task Description | Cannot be empty or whitespace |
| Menu Choice      | Must be 1–5                   |
| Index Numbers    | Must be valid & within range  |

### 📋 Sample Output

--
       TO-DO LIST APP
--
1. Add Task
2. View Tasks
3. Update Task Status
4. Delete Task
5. Exit
Enter your choice:

### ▶ How to Run
**In Eclipse**
* Create project
* Add package com.todolist
* Add Java files
* Right-click **Main.java → Run As → Java Application**

### From Terminal
```java
javac -d out src/com/todolist/*.java
java -cp out com.todolist.Main
```

### 👨‍💻 Author

- Name : Nagur vali
- Java Developer Intern
- Cognetix Technology





