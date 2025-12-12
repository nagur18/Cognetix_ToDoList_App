package com.todolist;

import java.util.ArrayList;
import java.util.List;


public class TaskManager {

    // Primary storage
    private final List<Task> tasks = new ArrayList<>();

    
    public boolean addTask(String description) {
        if (description == null) return false;
        String trimmed = description.trim();
        if (trimmed.isEmpty()) return false;

        Task t = new Task(trimmed); // default status "Pending"
        tasks.add(t);
        System.out.println("Task added successfully.");
        return true;
    }

    /**
     * View (list) all tasks and return a defensive copy of the list.
     *
     * @return copy of tasks list
     */
    public List<Task> viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return new ArrayList<>();
        }

        System.out.println("====================");
        System.out.println("TASK LIST");
        System.out.println("====================");
        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            System.out.printf("%d. %s%n", i + 1, t.getDescription());
            System.out.printf("   [%s]%n", t.getStatus());
        }
        return new ArrayList<>(tasks);
    }

    
    public boolean updateTaskStatus(int index) {
        if (index <= 0) {
            System.out.println("Invalid task index.");
            return false;
        }
        int idx0 = index - 1;
        if (idx0 >= tasks.size()) {
            System.out.println("Invalid task index.");
            return false;
        }
        Task t = tasks.get(idx0);
        t.toggleStatus();
        System.out.println("Task status updated successfully.");
        return true;
    }

    
    public boolean deleteTask(int index) {
        if (index <= 0) {
            System.out.println("Invalid task index.");
            return false;
        }
        int idx0 = index - 1;
        if (idx0 >= tasks.size()) {
            System.out.println("Invalid task index.");
            return false;
        }
        tasks.remove(idx0);
        System.out.println("Task deleted successfully!");
        return true;
    }

    
    public Task findTaskByIndex(int index) {
        if (index <= 0) return null;
        int idx0 = index - 1;
        if (idx0 >= tasks.size()) return null;
        return tasks.get(idx0);
    }

    /**
     * Helper: return number of tasks
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Helper: clear all tasks (useful for tests)
     */
    public void clearAll() {
        tasks.clear();
    }
}
