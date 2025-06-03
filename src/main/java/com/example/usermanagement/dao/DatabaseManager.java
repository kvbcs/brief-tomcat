package com.example.usermanagement.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    private static final String URL = "jdbc:sqlite:users.db";
   

    public static Connection connect() {
        try {
            Connection connection = DriverManager.getConnection(URL);
            System.out.println("✅ Connexion réussie !");
             // Exemple : créer une table
             String sql = "CREATE TABLE IF NOT EXISTS users (" +
             "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
             "name TEXT NOT NULL, " + "email TEXT NOT NULL, " + "phone TEXT NOT NULL, " + "dateNaissance DATETIME NOT NULL" +
             " );";

Statement stmt = connection.createStatement();
stmt.execute(sql);
System.out.println("📦 Table 'users' créée (ou déjà existante).");
connection.close();
            return connection;
        } catch (SQLException e) {
            System.err.println("❌ Erreur de connexion : " + e.getMessage());
            return null;
        }
    }
}
