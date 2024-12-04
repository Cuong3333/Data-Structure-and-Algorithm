/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studens;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager(100); // Giới hạn mảng 100 sinh viên

        while (true) {
            System.out.println("\n--- Student Management Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student by ID");
            System.out.println("5. View All Students");
            System.out.println("6. Sort Students by Marks");
            System.out.println("7. Search Student by Name");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1 -> manager.addStudent();
                case 2 -> {
                    System.out.print("Enter student ID to edit: ");
                    String id = scanner.nextLine();
                    manager.editStudent(id);
                }
                case 3 -> {
                    System.out.print("Enter student ID to delete: ");
                    String id = scanner.nextLine();
                    manager.deleteStudent(id);
                }
                case 4 -> {
                    System.out.print("Enter student ID to search: ");
                    String id = scanner.nextLine();
                    manager.findStudentById(id);
                }
                case 5 -> manager.displayAllStudents();
                case 6 -> manager.sortByMarks();
                case 7 -> manager.searchStudentByName();
                case 8 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }
}