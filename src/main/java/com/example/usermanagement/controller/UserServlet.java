package com.example.usermanagement.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.example.usermanagement.dao.UserDAO;
import com.example.usermanagement.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO(); // Instancie le DAO une seule fois
    }

    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    System.out.println(">>> POST reçu dans UserServlet");

    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String date = request.getParameter("dateNaissance");

    System.out.println("Nom: " + name + ", Email: " + email + ", Phone: " + phone + ", Date: " + date);

    LocalDate dateNaissance = LocalDate.parse(date);

    User newUser = new User(0, name, email, phone, dateNaissance);
    userDAO.add(newUser);

    response.sendRedirect("users"); // Recharge la liste
}

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    System.out.println(">>> GET sur /users");

    List<User> users = userDAO.listAll();
    System.out.println("Utilisateurs trouvés: " + users.size());

    request.setAttribute("users", users);
    request.getRequestDispatcher("/listUsers.jsp").forward(request, response);
}

}
