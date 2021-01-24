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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/UserControllerServlet")
public class UserControllerServlet extends HttpServlet {

    @Resource(name = "jdbc/bus_tickets_booking")
    private DataSource dataSource;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("username");
        List<String> userNames = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user");
            while (resultSet.next()) {
                userNames.add(resultSet.getString("username"));
            }
            if (userNames.contains(username)) {
                out.println("Welcome Back");
            } else
                out.println("<html><body>");
                out.println("<h3>you need to register first!</h3>");
                out.println("<p><a href=\"register.html\">Register</a></p>");
                out.println("</html></body>");


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
