package main;

import java.util.Scanner;
import service.StudentService;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Count Total Student");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    service.addStudent();
                    break;

                case 2:
                    service.viewStudents();
                    break;

                case 3:
                    service.updateStudent();
                    break;

                case 4:
                    service.deleteStudent();
                    break;

                case 5:
                    service.searchStudent();
                    break;

                case 6:
                    service.countStudents();
                    break;

                case 7:
                    System.out.println("Exiting Program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}