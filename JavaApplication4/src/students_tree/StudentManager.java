/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package students_tree;

/**
 *
 * @author cuong
 */
public class StudentManager {
    private BST bst;

    public StudentManager() {
        bst = new BST();
    }

    // Thêm sinh viên
    public void addStudent(String id, String name, double marks) {
        Student student = new Student(id, name, marks);
        bst.addStudent(student);
        System.out.println("Student added.");
    }

    // Sửa thông tin sinh viên
    public void editStudent(String id, String newName, double newMarks) {
        Student student = bst.searchStudentById(id);
        if (student != null) {
            student.name = newName;
            student.marks = newMarks;
            student.rank = student.calculateRank(newMarks);
            System.out.println("Student details updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Xóa sinh viên
    public void deleteStudent(String id) {
        bst.deleteStudent(id);
        System.out.println("Student removed.");
    }

    // Sắp xếp sinh viên theo điểm
    public void sortStudents() {
        bst.sortStudents();
        System.out.println("Students sorted by marks.");
    }

    // Tìm kiếm sinh viên theo ID
    public Student searchStudentById(String id) {
        return bst.searchStudentById(id);
    }

    // Hiển thị tất cả sinh viên
    public void displayAllStudents() {
        bst.sortStudents();
    }
}
