package com.jsproject.companyapp;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {


    private static CompanyDatabase database;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        database = CompanyDatabase.getInstance();
        try {
            database.open("C:/Users/nikla/Documents/Ohjelmointi/omat/JavaScriptProject/companydb.db"); // database path
        } catch (SQLException e) {
            System.out.println("Database fail");
        }
    }

}