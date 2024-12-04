/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studens;

import java.util.Scanner;

public class StudentManager {

    private Student[] students;
    private int studentCount;

    public StudentManager(int capacity) {
        students = new Student[capacity];
        studentCount = 0;
    }

    public void addStudent() {
        if (studentCount >= students.length) {
            System.out.println("Cannot add more students, the list is full.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Add new student");

        String id = getValidId(sc);
        String name = getValidName(sc);
        int age = getValidAge(sc);
        double marks = getValidMarks(sc);

        students[studentCount] = new Student(id, name, marks, age);
        studentCount++;
        System.out.println("Student added successfully!");
    }

    private String getValidId(Scanner sc) {
        String id;
        while (true) {
            System.out.print("Enter student ID: ");
            id = sc.nextLine();
            if (id.matches("\\d+") && Integer.parseInt(id) > 0) {
                break;
            } else {
                System.out.println("Invalid ID. ID must be a positive number.");
            }
        }
        return id;
    }

    private String getValidName(Scanner sc) {
        String name;
        while (true) {
            System.out.print("Enter student name: ");
            name = sc.nextLine();
            if (!name.trim().isEmpty()) {
                break;
            } else {
                System.out.println("Invalid name. Name cannot be empty.");
            }
        }
        return name;
    }

    private int getValidAge(Scanner sc) {
        int age;
        while (true) {
            System.out.print("Enter student age: ");
            age = sc.nextInt();
            sc.nextLine(); // Consume newline left-over
            if (age > 18) {
                break;
            } else {
                System.out.println("Invalid age. Age must be greater than 18.");
            }
        }
        return age;
    }

    private double getValidMarks(Scanner sc) {
        double marks;
        while (true) {
            System.out.print("Enter student marks: ");
            marks = sc.nextDouble();
            sc.nextLine(); // Consume newline left-over
            if (marks >= 0.0 && marks <= 10.0) {
                break;
            } else {
                System.out.println("Invalid marks. Marks must be between 0.0 and 10.0.");
            }
        }
        return marks;
    }

    public void editStudent(String id) {
        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Editing student: " + student);

        String name = getEditValidName(sc, student);
        int age = getEditValidAge(sc, student);
        double marks = getEditValidMarks(sc, student);

        student.setName(name);
        student.setAge(age);
        student.setMarks(marks);
        System.out.println("Student updated successfully!");
    }

    private String getEditValidName(Scanner sc, Student student) {
        String name;
        System.out.print("Enter new name (leave blank to keep current): ");
        name = sc.nextLine().trim();
        return name.isEmpty() ? student.getName() : name;
    }

    private int getEditValidAge(Scanner sc, Student student) {
        int age;
        System.out.print("Enter new age (leave blank to keep current): ");
        String ageInput = sc.nextLine().trim();
        if (ageInput.isEmpty()) {
            return student.getAge();
        } else {
            return Integer.parseInt(ageInput);
        }
    }

    private double getEditValidMarks(Scanner sc, Student student) {
        double marks;
        System.out.print("Enter new marks (leave blank to keep current): ");
        String marksInput = sc.nextLine().trim();
        if (marksInput.isEmpty()) {
            return student.getMarks();
        } else {
            return Double.parseDouble(marksInput);
        }
    }

    public Student findStudentById(String id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId().equals(id)) {
                return students[i];
            }
        }
        return null;
    }

    public void deleteStudent(String id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId().equals(id)) {
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[studentCount - 1] = null;
                studentCount--;
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("No students available.");
        } else {
            for (int i = 0; i < studentCount; i++) {
                System.out.println(students[i]);
            }
        }
    }

    public void sortByMarks() {
        for (int i = 0; i < studentCount - 1; i++) {
            for (int j = i + 1; j < studentCount; j++) {
                if (students[i].getMarks() < students[j].getMarks()) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        System.out.println("Students sorted by marks.");
    }

    public void searchStudentByName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name to search: ");
        String name = sc.nextLine().trim();
        boolean found = false;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(students[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found with name containing: " + name);
        }
    }
}
