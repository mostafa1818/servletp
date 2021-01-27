package com.maktab.online_bus_ticket_booking.controller;

import com.maktab.online_bus_ticket_booking.*;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
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

@WebServlet("/TicketServlet")
public class AcceptTicket extends HttpServlet {

    @Resource(name = "jdbc/bus_tickets_booking")
    private DataSource dataSource;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        response.setContentType("text/html");


        boolean flage=false;
        Travel travel1=new Travel();
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        TravelDao travelDao=new TravelDao(entityManager);

        String travelFrom = request.getParameter("travel_from");
        String travelTo = request.getParameter("travel_to");
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");


        }
    }

