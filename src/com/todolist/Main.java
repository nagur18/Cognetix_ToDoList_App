package com.todolist;

import java.util.Scanner;

/**
 * Console UI for the To-Do List App.
 * Menu-driven, validates inputs, and calls TaskManager for operations.
 */
public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final TaskManager MANAGER = new TaskManager();

    public static void main(String[] args) {
        System.out.println("===========================");
        System.out.println("       TO-DO LIST APP      ");
        System.out.println("===========================");

        boolean running = true;
        while (running) {
            printMenu();
            String choice = SCANNER.nextLine().trim();
            switch (choice) {
                case "1":
                    addTaskFlow();
                    break;
                case "2":
                    viewTasksFlow();
                    break;
                case "3":
                    updateTaskFlow();
                    break;
                case "4":
                    deleteTaskFlow();
                    break;
                case "5":
                    System.out.println("Exiting application. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please enter a number from 1 to 5.");
            }
        }

        SCANNER.close();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("===========================");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Update Task Status");
        System.out.println("4. Delete Task");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addTaskFlow() {
        System.out.println("\n-- Add Task --");
        while (true) {
            System.out.print("Enter task description: ");
            String desc = SCANNER.nextLine();
            if (desc == null || desc.trim().isEmpty()) {
                System.out.println("Error: Description cannot be empty. Please re-enter.");
                continue;
            }
            boolean added = MANAGER.addTask(desc);
            if (added) break;
            else System.out.println("Failed to add task. Try again.");
        }
    }

    private static void viewTasksFlow() {
        System.out.println();
        MANAGER.viewTasks();
    }

    private static void updateTaskFlow() {
        System.out.println("\n-- Update Task Status --");
        if (MANAGER.size() == 0) {
            System.out.println("No tasks to update.");
            return;
        }
        while (true) {
            System.out.print("Enter task number to toggle status (or 0 to cancel): ");
            String input = SCANNER.nextLine().trim();
            int idx;
            try {
                idx = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid task number.");
                continue;
            }
            if (idx == 0) {
                System.out.println("Update cancelled.");
                return;
            }
            boolean ok = MANAGER.updateTaskStatus(idx);
            if (ok) return;
            // if not ok, loop and ask again
        }
    }

    private static void deleteTaskFlow() {
        System.out.println("\n-- Delete Task --");
        if (MANAGER.size() == 0) {
            System.out.println("No tasks to delete.");
            return;
        }
        while (true) {
            System.out.print("Enter task number to delete (or 0 to cancel): ");
            String input = SCANNER.nextLine().trim();
            int idx;
            try {
                idx = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid task number.");
                continue;
            }
            if (idx == 0) {
                System.out.println("Deletion cancelled.");
                return;
            }
            boolean ok = MANAGER.deleteTask(idx);
            if (ok) return;
            // if deletion failed (invalid index), loop and ask again
        }
    }
}
