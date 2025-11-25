package com.example.loginapp.servlet;
import com.example.loginapp.model.User;
import com.example.loginapp.dao.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
public class LoginServlet extends HttpServlet {
    private UserDAO userDAO;
    public void init() { userDAO = new UserDAO(); }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        if (userDAO.validate(user)) {
            request.getRequestDispatcher("success.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Usuario o contraseña incorrectos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}