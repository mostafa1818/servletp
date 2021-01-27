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
public class TicketServlet extends HttpServlet {

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
        boolean flage=false;
        Tiket tiket=new Tiket();
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        TiketDao tiketDao=new TiketDao(entityManager);
        UserDao userDao=new UserDao(entityManager);
        try {



            Travel[] travel = new Travel[10];




//                List<Tiket> travelList = tiketDao.loadall();
//                List<Travel> travelList2 = null;
//                int counter=0;
//                for (Travel object : travelList) {
//                    String travelFrom1 = object.getTravelFrom();
//                    String travelTo1 = object.getTravelTo();
//                    String year1 = object.getYear();
//                    String month1 = object.getMonth();
//                    String day1 = object.getDay();
//
//                    if ((travelFrom1.equals(travelFrom1)) && (travelTo1.equals(travelTo1))
//                            &&(year1.equals(year1))
//                            &&(month1.equals(month1))
//                            &&(day1.equals(day1)))
//                    {
//                        travel[counter].setTravelFrom(travelFrom);
//                        travel[counter] .setTravelTo(travelTo);
//                        travel[counter] .setYear(year);
//                        travel[counter] .setMonth(month);
//                        travel[counter] .setDay(day);
//                        travelList2.add(travel[counter]);
//                        counter++;
//
//                    }
//                }

                entityManager.getTransaction().commit();
                entityManager.close();
                JPAUtil.shutdown();


            entityManager.getTransaction().commit();
            entityManager.close();
            JPAUtil.shutdown();


            HttpSession session1 = request.getSession();

            RequestDispatcher dispatch = request.getRequestDispatcher("tickets.jsp");
            dispatch.forward(request,response);
        } catch (Exception exception) {
            exception.printStackTrace();
//            RequestDispatcher dispatch = request.getRequestDispatcher("TravelServlet");
//            dispatch.forward(request,response);
            out.println("<html><body>");
            out.println("<h3>something went wrong!!<h3>");
//            out.println("<a href=\\\"Travel.html\\\">go back</a>\"");
            out.println("</html></body>");


        }
    }
}
