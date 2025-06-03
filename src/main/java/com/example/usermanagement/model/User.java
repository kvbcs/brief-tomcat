package usermanagement.model;

import java.time.LocalDate;

public class User {
    private int id;
    private String name;
    private String email;
    private String phone;
    private LocalDate dateNaissance;

    //Constructor
    public User(int id, String name, String email, String phone, LocalDate dateNaissance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.dateNaissance = dateNaissance;
    }


    // Getters/setters
    public int getId() {
        return this.id;
    }

    public int setId(int id) {
        return this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String setName(String name) {
        return this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public String setEmail(String email) {
        return this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public String setPhone(String phone) {
        return this.phone = phone;
    }
    public LocalDate getDateNaissance() {
        return this.dateNaissance;
    }

    public LocalDate setDateNaissance(LocalDate dateNaissance){
        return this.dateNaissance = dateNaissance;
    }
   }
