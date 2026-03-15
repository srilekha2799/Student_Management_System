package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import database.DBConnection;

public class StudentService {

    Scanner sc = new Scanner(System.in);

    // Add Student
    public void addStudent() {

        try {

            System.out.println("Enter Name:");
            String name = sc.nextLine();

            System.out.println("Enter Age:");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Course:");
            String course = sc.nextLine();

            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO Student(name, age, course) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);

            ps.executeUpdate();

            System.out.println("Student added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Students
    public void viewStudents() {

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM Student";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("course"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Student
    public void updateStudent() {

        try {

            System.out.println("Enter Students ID to update:");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter New Name:");
            String name = sc.nextLine();

            System.out.println("Enter New Age:");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter New Course:");
            String course = sc.nextLine();

            Connection con = DBConnection.getConnection();

            String query = "UPDATE Student SET name=?, age=?, course=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.setInt(4, id);

            ps.executeUpdate();

            System.out.println("Student updated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Student
    public void deleteStudent() {

        try {

            System.out.println("Enter Student ID to delete:");
            int id = sc.nextInt();

            Connection con = DBConnection.getConnection();

            String query = "DELETE FROM Student WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Student deleted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Search Student
    public void searchStudent() {

        try {

            System.out.println("Enter Student ID:");
            int id = sc.nextInt();

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM Student WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("course"));
            } else {
                System.out.println("Student not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
// Count Total Students
    public void countStudents() {

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT COUNT(*) AS total FROM Student";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Total Students: " + rs.getInt("total"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}