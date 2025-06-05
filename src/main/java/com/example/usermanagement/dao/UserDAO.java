package com.example.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.usermanagement.model.User;

public class UserDAO {
    private final String url = "jdbc:sqlite:src/main/resources/db/users.db";

    public UserDAO() {
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // Crée la table users si elle n'existe pas
            stmt.execute("CREATE TABLE IF NOT EXISTS users (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                         "name TEXT, email TEXT, phone TEXT, dateNaissance TEXT)");
        } catch (SQLException e) {
            e.printStackTrace(); // Affiche l'erreur si la BDD échoue
        }
    }

    // Méthode pour lister tous les utilisateurs
    public List<User> listAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Récupère chaque utilisateur de la base
                User u = new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    LocalDate.parse(rs.getString("dateNaissance"))
                );
                users.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Méthode pour ajouter un utilisateur à la base
    public void add(User u) {
        String sql = "INSERT INTO users(name, email, phone, dateNaissance) VALUES(?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getEmail());
            pstmt.setString(3, u.getPhone());
            pstmt.setString(4, u.getDateNaissance().toString());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
