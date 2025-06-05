package com.example.usermanagement.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.example.usermanagement.dao.UserDAO;
import com.example.usermanagement.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/users") // Cette URL déclenchera le servlet
public class UserServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAO(); // Instancie le DAO une seule fois
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupère la liste d'utilisateurs et l'envoie à la JSP
        List<User> users = userDAO.listAll();
        request.setAttribute("users", users); // Envoie la liste à la JSP
        request.getRequestDispatcher("/listUsers.jsp").forward(request, response); // Redirection vers la vue
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupère les données du formulaire
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        LocalDate dateNaissance = LocalDate.parse(request.getParameter("dateNaissance"));

        User newUser = new User(0, name, email, phone, dateNaissance);
        userDAO.add(newUser); // Ajoute à la base

        response.sendRedirect("users"); // Recharge la liste
    }
}
