package com.maktab.online_bus_ticket_booking.controller;

import com.maktab.online_bus_ticket_booking.JPAUtil;
import com.maktab.online_bus_ticket_booking.User;
import com.maktab.online_bus_ticket_booking.UserDao;

import javax.persistence.EntityManager;
import javax.servlet.http.*;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    @Resource(name = "jdbc/bus_tickets_booking")
    private DataSource dataSource;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String username = req.getParameter("User");
        String password = req.getParameter("pass");

        if (username.isEmpty()||password.equals(password.isEmpty())) {
            HttpSession session = req.getSession();
            session.setAttribute("username",username);
            resp.sendRedirect("index.html");

        }


        try {
            boolean flage=false;
            User user=new User();
            EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
            UserDao userDao=new UserDao(entityManager);


            List<User> userList = userDao.loadall();
                    for (User object : userList) {
                        String user1 = object.getUser();
                        String pass1 = object.getPass();

                        if ((user1.equals(user)) && (pass1.equals(pass1))) {
                            flage = true;

                        }
                    }


            entityManager.getTransaction().commit();
            entityManager.close();
            JPAUtil.shutdown();


            if (flage==true) {
                HttpSession session = req.getSession();
                session.setAttribute("username",username);
                resp.sendRedirect("Travel.html");

            } else{
                HttpSession session = req.getSession();
                session.setAttribute("username",username);
                resp.sendRedirect("index.html");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
