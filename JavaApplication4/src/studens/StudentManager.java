/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



package studens;

/**
 *
 * @author cuong
 */
 public class StudentManager {
    private Student[] students;
    private int count;  

    public StudentManager(int size) {
        students = new Student[size];
        count = 0;
    }

    // Thêm sinh viên
    public void addStudent(String id, String name, double marks) {
        if (count < students.length) {
            students[count] = new Student(id, name, marks);
            count++;
            System.out.println("Student added.");
        } else {
            System.out.println("Student list is full.");
        }
    }

    // Sửa thông tin sinh viên dựa trên ID
    public void editStudent(String id, String newName, double newMarks) {
        for (int i = 0; i < count; i++) {
            if (students[i].id.equals(id)) {
                students[i].name = newName;
                students[i].marks = newMarks;
                students[i].rank = students[i].calculateRank(newMarks);
                System.out.println("Student details updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Xóa sinh viên dựa trên ID
    public void deleteStudent(String id) {
        for (int i = 0; i < count; i++) {
            if (students[i].id.equals(id)) {
                for (int j = i; j < count - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[count - 1] = null;
                count--;
                System.out.println("Student removed.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Sắp xếp sinh viên theo điểm từ cao đến thấp
    public void sortStudentsByMarks() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (students[j].marks < students[j + 1].marks) {
                    // Đổi chỗ hai phần tử
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        System.out.println("Students sorted by marks.");
    }

    // Tìm kiếm sinh viên theo ID
    public Student searchStudentById(String id) {
        for (int i = 0; i < count; i++) {
            if (students[i].id.equals(id)) {
                return students[i];
            }
        }
        return null;
    }

    // Hiển thị toàn bộ sinh viên
    public void displayAllStudents() {
        for (int i = 0; i < count; i++) {
            students[i].display();
            System.out.println();
        }
    }
}
