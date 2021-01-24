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
import java.util.List;

@WebServlet("/UserControllerServlet")
public class UserControllerServlet extends HttpServlet {

    private UserUtil userUtil;

    @Resource(name="jdbc/bus_tickets_booking")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        // create our student db util ... and pass in the conn pool / datasource
        try {
            userUtil = new UserUtil(dataSource);
        }
        catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

}
