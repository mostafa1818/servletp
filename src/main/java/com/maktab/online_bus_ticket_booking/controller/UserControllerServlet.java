package com.maktab.online_bus_ticket_booking.controller;

import com.maktab.online_bus_ticket_booking.bean.User;
import com.maktab.online_bus_ticket_booking.dao.UserUtil;

import javax.servlet.http.*;


import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

@WebServlet("/UserControllerServlet")
public class UserControllerServlet extends HttpServlet {

    @Resource(name = "jdbc/bus_tickets_booking")
    private DataSource dataSource;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        List<String> userNames = new ArrayList<>();
        Map<String, String> userPassword = new HashMap<>();
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user");
            while (resultSet.next()) {
                userNames.add(resultSet.getString("username"));
                userPassword.put(resultSet.getString("username"),resultSet.getString("password"));
            }
                HttpSession httpSession = req.getSession();
            if (userPassword.containsKey(username)&&password.equals(userPassword.get(username))) {
                httpSession.setAttribute("isLoggedIn", username);
                resp.sendRedirect("travel.html");


            } else
                out.println("<html><body>");
                out.println("<h3>Username or Password is incorrect!</h3>");
                out.println("<p><a href=\"register.html\">Register</a></p>");
                out.println("<p><a href=\"login.html\">Login</a></p>");
                out.println("</html></body>");


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
