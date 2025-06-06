<%@ page import="java.util.*, com.example.usermanagement.model.User" %>
<%
    List<User> users = (List<User>) request.getAttribute("users");
%>
<h2>Liste des utilisateurs</h2>
<% if (users != null && !users.isEmpty()) { %>
    <ul>
    <% for (User u : users) { %>
        <li><%= u.getName() %> - <%= u.getEmail() %> - <%= u.getPhone() %></li>
    <% } %>
    </ul>
<% } else { %>
    <p>Aucun utilisateur trouvé.</p>
<% } %>
