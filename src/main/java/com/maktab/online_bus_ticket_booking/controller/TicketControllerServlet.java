package com.maktab.online_bus_ticket_booking.controller;

import com.maktab.online_bus_ticket_booking.bean.Travel;
import com.maktab.online_bus_ticket_booking.dao.TicketUtil;
import sun.security.krb5.internal.Ticket;

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
import java.util.List;

@WebServlet("/TicketControllerServlet")
public class TicketControllerServlet extends HttpServlet {
    String userId;
    int travelId;

    @Resource(name = "jdbc/bus_tickets_booking")
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TicketUtil ticketUtil = new TicketUtil(dataSource);
        PrintWriter out = response.getWriter();
        try {
            int userID1 = ticketUtil.findUserId(userId);
            ticketUtil.addTicket(userID1,travelId);
            out.println("DONE!");

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        TicketUtil ticketUtil = new TicketUtil(dataSource);
        HttpSession session = request.getSession();
        userId = (String) session.getAttribute("userN");
        travelId = (Integer) session.getAttribute("travelId");
    }
}
