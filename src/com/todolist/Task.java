package com.todolist;

public class Task {

    private String description;
    private String status;   // "Pending" or "Completed"

    // Constructor → status defaults to Pending
    public Task(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be empty.");
        }

        this.description = description.trim();
        this.status = "Pending";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be empty.");
        }
        this.description = description.trim();
    }

    public String getStatus() {
        return status;
    }

    // Toggle Pending ↔ Completed
    public void toggleStatus() {
        if (this.status.equals("Pending")) {
            this.status = "Completed";
        } else {
            this.status = "Pending";
        }
    }

    @Override
    public String toString() {
        return description + " [" + status + "]";
    }
}
