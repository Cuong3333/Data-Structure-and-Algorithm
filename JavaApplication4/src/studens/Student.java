/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studens;

/**
 *
 * @author cuong
 */
class Student {
    String id;
    String name;
    double marks;
    String rank;

    // Hàm tạo cho lớp Student
    public Student(String id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.rank = calculateRank(marks);
    }

    // Xác định xếp hạng dựa trên điểm số
    public String calculateRank(double marks) {
        if (marks >= 0 && marks < 5.0) {
            return "Fail";
        } else if (marks >= 5.0 && marks < 6.5) {
            return "Medium";
        } else if (marks >= 6.5 && marks < 7.5) {
            return "Good";
        } else if (marks >= 7.5 && marks < 9.0) {
            return "Very Good";
        } else if (marks >= 9.0 && marks <= 10.0) {
            return "Excellent";
        } else {
            return "Invalid Marks";
        }
    }

    // Hiển thị thông tin sinh viên
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Rank: " + rank);
    }
}
