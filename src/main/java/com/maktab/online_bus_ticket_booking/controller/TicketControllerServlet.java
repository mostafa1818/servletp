package com.maktab.online_bus_ticket_booking.controller;

import com.maktab.online_bus_ticket_booking.dao.TicketUtil;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/TicketControllerServlet")
public class TicketControllerServlet extends HttpServlet {

    @Resource(name = "jdbc/bus_tickets_booking")
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String strId =  request.getParameter("travelId");
        int travelId = Integer.parseInt(strId);
        String userId = (String) session.getAttribute("userN");
        TicketUtil ticketUtil = new TicketUtil(dataSource);
        try {
            int userID1 = ticketUtil.findUserId(userId);
           ticketUtil.addTicket(userID1, travelId);
        } catch (Exception exception) {
            exception.printStackTrace();
            out.println("something went wrong!!");
        }
    }
}
