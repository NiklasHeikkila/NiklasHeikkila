package com.jsproject.companyapp;

import java.io.File;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.jsproject.companyapp.dto.UserRequest;

public class CompanyDatabase {
    

    private static CompanyDatabase instance;
    private Connection connection;


    public static synchronized CompanyDatabase getInstance() {
        if (instance == null) {
            instance = new CompanyDatabase();
        }
        return instance;
    }

    public void open(String dbName) throws SQLException {
        close();
        try {
            boolean fileExists;
            String database = "jdbc:sqlite:" + dbName;
            File dbFile = new File(dbName);
            fileExists = dbFile.exists();
            connection = DriverManager.getConnection(database);
            if (!fileExists) {
                initializeDatabase(database);
            }
        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }

    private void initializeDatabase(String database) throws SQLException {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(
                "CREATE TABLE customer (" +
                    "customerId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name VARCHAR(100))"
            );
            stmt.executeUpdate(
                "CREATE TABLE employee (" +
                    "employeeId INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "firstName VARCHAR(100) NOT NULL," +
                    "lastName VARCHAR(100) NOT NULL," +
                    "email VARCHAR(255)," +
                    "phone VARCHAR(20))"
            );
            stmt.executeUpdate(
                "CREATE TABLE user (" +
                    "username VARCHAR(100) PRIMARY KEY," +
                    "password VARCHAR(100)," +
                    "employeeId INTEGER," +
                    "FOREIGN KEY (employeeId) REFERENCES employee(employeeId))"
            );
            // Seed default admin user with hashed password
            String adminHashed = hashPassword("admin123");
            PreparedStatement seedStmt = connection.prepareStatement(
                "INSERT INTO user(username, password) VALUES (?, ?)"
            );
            seedStmt.setString(1, "admin");
            seedStmt.setString(2, adminHashed);
            seedStmt.executeUpdate();
            seedStmt.close();
            stmt.close();
            System.out.println("Database created");
        } catch (SQLException e) {
            System.out.println("Database initialization failed");
            e.printStackTrace();
        }
    }

    public boolean insertCustomer (String name) {
        String insertCustomer = "INSERT INTO customer(name) VALUES (?)";
        
        try {
            PreparedStatement insertStatement = connection.prepareStatement(insertCustomer);
            insertStatement.setString(1, name);
            insertStatement.executeUpdate();
            System.out.println("Customer inserted");
            return true;
        } catch (SQLException e) {
            System.out.println("Error inserting customer");
            e.printStackTrace();
            return false;
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();

        String sql = "SELECT * FROM customer";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                customers.add(new Customer(
                    rs.getInt("customerId"),
                    rs.getString("name")
                ));
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public boolean validateUser(UserRequest user) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT password FROM user WHERE username = ?");
            stmt.setString(1, user.getUsername());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String storedHash = rs.getString("password");
                String inputHash = hashPassword(user.getPassword());
                
                if (inputHash != null && inputHash.equals(storedHash)) {
                    return true;
                }
            } else {
                System.out.println("No user found with username: " + user.getUsername());
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashed = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashed);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void close() throws SQLException {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Database connection closed");
            } catch (SQLException e) {
                System.out.println("Error closing database: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}

