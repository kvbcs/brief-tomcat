package com.example.usermanagement.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

    public void init() {
        try (Connection connect = DatabaseManager.connect()) {
            if (connect != null) {
                System.out.println("📡 Connexion depuis UserDAO établie !");
                // Tu peux faire d'autres opérations ici si besoin
            }
        } catch (SQLException e) {
            System.out.println("⚠️ Erreur dans UserDAO : " + e.getMessage());
        }
    }

    // Exemple d'une méthode pour récupérer tous les utilisateurs
    public void listAll() {
        String sql = "SELECT * FROM users";

        try (Connection connect = DatabaseManager.connect();
             Statement stmt = connect.createStatement()) {
            // Exécute la requête ici, par exemple avec stmt.executeQuery(sql)
            System.out.println("📃 Requête exécutée : " + sql);
        } catch (SQLException e) {
            System.out.println("⚠️ Erreur lors de la lecture des utilisateurs : " + e.getMessage());
        }
    }
}
