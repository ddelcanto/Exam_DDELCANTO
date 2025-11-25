package com.example.loginapp.dao;
import java.sql.*;
import com.example.loginapp.model.User;
public class UserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:8889/eva02";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";
    public boolean validate(User user) {
        boolean status = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement ps = connection.prepareStatement(
                "SELECT * FROM users WHERE username = ? AND password = ?");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}