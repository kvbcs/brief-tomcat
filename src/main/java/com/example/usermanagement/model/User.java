package com.example.usermanagement.model;

import java.time.LocalDate;

public class User {
    private int id;               // Identifiant unique de l'utilisateur
    private String name;         // Nom de l'utilisateur
    private String email;        // Email
    private String phone;        // Numéro de téléphone
    private LocalDate dateNaissance; // Date de naissance

    // Constructeur vide (nécessaire pour certains frameworks)
    public User() {}

    // Constructeur complet
    public User(int id, String name, String email, String phone, LocalDate dateNaissance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dateNaissance = dateNaissance;
    }

    // Getters et Setters pour accéder aux champs privés
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public LocalDate getDateNaissance() { return dateNaissance; }
    public void setDateNaissance(LocalDate dateNaissance) { this.dateNaissance = dateNaissance; }
}
