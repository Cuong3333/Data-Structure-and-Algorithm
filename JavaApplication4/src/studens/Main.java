/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studens;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author cuong
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.print("Enter the number of students you want to manage: ");
            int size = scanner.nextInt();
            scanner.nextLine();

            StudentManager manager = new StudentManager(size);

            while (true) {
                System.out.println("1. Add Student");
                System.out.println("2. Edit Student");
                System.out.println("3. Delete Student");
                System.out.println("4. Sort Students by Marks");
                System.out.println("5. Search Student by ID");
                System.out.println("6. Display All Students");
                System.out.println("7. Exit");
                System.out.print("Choose an option: ");

                try {
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1 -> addStudent(manager);
                        case 2 -> editStudent(manager);
                        case 3 -> deleteStudent(manager);
                        case 4 -> manager.sortStudentsByMarks();
                        case 5 -> searchStudent(manager);
                        case 6 -> manager.displayAllStudents();
                        case 7 -> {
                            System.out.println("Exiting program.");
                            System.exit(0);
                        }
                        default -> System.out.println("Invalid choice. Try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 7.");
                    scanner.nextLine(); // Clear the invalid input
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for the number of students. Please enter a valid integer.");
        }
    }

    private static void addStudent(StudentManager manager) {
        try {
            System.out.print("Enter Student ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Student Marks: ");
            double marks = scanner.nextDouble();
            scanner.nextLine();

            manager.addStudent(id, name, marks);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for marks. Please enter a valid number.");
            scanner.nextLine(); // Clear the invalid input
        }
    }

    private static void editStudent(StudentManager manager) {
        try {
            System.out.print("Enter Student ID to edit: ");
            String id = scanner.nextLine();
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new marks: ");
            double newMarks = scanner.nextDouble();
            scanner.nextLine();

            manager.editStudent(id, newName, newMarks);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for new marks. Please enter a valid number.");
            scanner.nextLine(); // Clear the invalid input
        }
    }

    private static void deleteStudent(StudentManager manager) {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();
        manager.deleteStudent(id);
    }

    private static void searchStudent(StudentManager manager) {
        System.out.print("Enter Student ID to search: ");
        String id = scanner.nextLine();
        Student student = manager.searchStudentById(id);
        if (student != null) {
            student.display();
        } else {
            System.out.println("Student not found.");
        }
    }
}

