package Lab_Session5;
// Buoc 1: import java.sql package
import sun.awt.geom.AreaOp;

import javax.xml.soap.SOAPPart;
import java.net.URL;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MENU();

    }

    public static void MENU() {
        System.out.println("------MENU------");
        System.out.println("1. SHOW STUDENT");
        System.out.println("2. ADD STUDENT");
        System.out.println("3. DELETE ");
        System.out.println("4. EXIT");
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Choose function: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                ShowStudent();
                MENU();
            case 2:
                addStudent();
                MENU();
            case 3:
                delete();
                MENU();
            case 4:
                break;
        }

    }

    public static void ShowStudent() {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            String DB_URL = "jdbc:mysql://localhost:3306/t1806e";
            String DB_USER = "root";
            String DB_PASS = "";

            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);


            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM student";
            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Age: " + resultSet.getInt("age"));
                System.out.println("Mark:" + resultSet.getInt("mark"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void addStudent() {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            String DB_URL = "jdbc:mysql://localhost:3306/t1806e";
            String DB_USER = "root";
            String DB_PASS = "";

            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);


            Statement statement = connection.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Name: ");
            String name = scanner.nextLine();
            System.out.println("Age:");
            int age = scanner.nextInt();
            System.out.println("Mark: ");
            int mark = scanner.nextInt();
            String sql1 = "INSERT INTO student (name, age, mark) values ('"+name +"'"+","+age+"," +mark+")";
            statement.executeUpdate(sql1);

            ResultSet resultSet = statement.executeQuery(sql1);


            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Age: " + resultSet.getInt("age"));
                System.out.println("Mark:" + resultSet.getInt("mark"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void delete() {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            String DB_URL = "jdbc:mysql://localhost:3306/t1806e";
            String DB_USER = "root";
            String DB_PASS = "";

            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);


            Statement statement = connection.createStatement();
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            int id = scanner.nextInt();
            String sql2 = "DELETE FROM student WHERE id =" + id;
            statement.executeUpdate(sql2);

            ResultSet resultSet = statement.executeQuery(sql2);


            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Age: " + resultSet.getInt("age"));
                System.out.println("Mark:" + resultSet.getInt("mark"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
