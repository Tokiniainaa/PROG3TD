package com.example.library_management.connection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class dataBaseConnection {
    @Bean
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                System.getenv("Url"),
                System.getenv("User"),
                System.getenv("Password")
        );


    }



}
