package com.example.usermanagement.dao;

import com.example.usermanagement.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public List<User> listAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT name, email, phone, dateNaissance FROM users";

        try (Connection conn = DatabaseManager.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                User user = new User(
                    rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                LocalDate.parse(rs.getString("dateNaissance"))
                );
                users.add(user);
            }

        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de la lecture des utilisateurs : " + e.getMessage());
        }

        return users;
    }

    public void add(User user) {
        String sql = "INSERT INTO users (name, email, phone, dateNaissance) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPhone());
            pstmt.setString(4, user.getDateNaissance().toString());

            pstmt.executeUpdate();
            System.out.println("✅ Utilisateur ajouté : " + user.getName());

        } catch (SQLException e) {
            System.err.println("❌ Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
    }
}
