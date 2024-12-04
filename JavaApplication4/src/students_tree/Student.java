/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package students_tree;

/**
 *
 * @author cuong
 */
public class Student {
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


class BST {
    class Node {
        Student student;
        Node left, right;

        public Node(Student student) {
            this.student = student;
            left = right = null;
        }
    }

    private Node root;

    public BST() {
        root = null;
    }

    public void addStudent(Student student) {
        root = addRecursive(root, student);
    }

    private Node addRecursive(Node node, Student student) {
        if (node == null) {
            return new Node(student);
        }

        if (student.id.compareTo(node.student.id) < 0) {
            node.left = addRecursive(node.left, student);
        } else if (student.id.compareTo(node.student.id) > 0) {
            node.right = addRecursive(node.right, student);
        }

        return node;
    }

    public Student searchStudentById(String id) {
        return searchRecursive(root, id);
    }

    private Student searchRecursive(Node node, String id) {
        if (node == null) {
            return null;
        }

        if (id.equals(node.student.id)) {
            return node.student;
        }

        return id.compareTo(node.student.id) < 0
            ? searchRecursive(node.left, id)
            : searchRecursive(node.right, id);
    }

    // Sắp xếp sinh viên (duyệt cây theo thứ tự trung tố)
    public void sortStudents() {
        inorderTraversal(root);
    }

    private void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            node.student.display();
            inorderTraversal(node.right);
        }
    }

    // Xóa sinh viên dựa trên ID
    public void deleteStudent(String id) {
        root = deleteRecursive(root, id);
    }

    private Node deleteRecursive(Node node, String id) {
        if (node == null) {
            return null;
        }

        if (id.equals(node.student.id)) {
            // Sinh viên cần xóa được tìm thấy

            // Trường hợp 1: Sinh viên không có con
            if (node.left == null && node.right == null) {
                return null;
            }

            // Trường hợp 2: Sinh viên có một con
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }

            // Trường hợp 3: Sinh viên có hai con
            Student smallestStudent = findSmallestStudent(node.right);
            node.student = smallestStudent;
            node.right = deleteRecursive(node.right, smallestStudent.id);
            return node;
        }

        if (id.compareTo(node.student.id) < 0) {
            node.left = deleteRecursive(node.left, id);
        } else {
            node.right = deleteRecursive(node.right, id);
        }

        return node;
    }

    private Student findSmallestStudent(Node root) {
        return root.left == null ? root.student : findSmallestStudent(root.left);
    }
}

