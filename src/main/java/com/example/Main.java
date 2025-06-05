package com.example;

import java.time.LocalDate;
import java.util.List;

import com.example.usermanagement.dao.UserDAO;
import com.example.usermanagement.model.User;

public class Main {
    public static void main(String[] args) {
    UserDAO dao = new UserDAO();
    dao.add(new User(0, "Test", "test@email.com", "0101010101", LocalDate.of(1990, 1, 1)));
    List<User> users = dao.listAll();
    System.out.println("Utilisateurs dans la DB : " + users.size());
}

}