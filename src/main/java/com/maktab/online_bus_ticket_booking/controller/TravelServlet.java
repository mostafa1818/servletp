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
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/TravelServlet")
public class TravelServlet extends HttpServlet {

    @Resource(name = "jdbc/bus_tickets_booking")
    private DataSource dataSource;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

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

        Travel[] travel = new Travel[10];

        try {


            List<Travel> travelList = travelDao.loadall();
            List<Travel> travelList2 = null;
            int counter=0;
            for (Travel object : travelList) {
                String travelFrom1 = object.getTravelFrom();
                String travelTo1 = object.getTravelTo();
                String year1 = object.getYear();
                String month1 = object.getMonth();
                String day1 = object.getDay();

                if ((travelFrom1.equals(travelFrom1)) && (travelTo1.equals(travelTo1))
                        &&(year1.equals(year1))
                        &&(month1.equals(month1))
                        &&(day1.equals(day1)))
                {
                    travel[counter].setTravelFrom(travelFrom);
                    travel[counter] .setTravelTo(travelTo);
                    travel[counter] .setYear(year);
                    travel[counter] .setMonth(month);
                    travel[counter] .setDay(day);
                    travelList2.add(travel[counter]);
                    counter++;

                }
            }

            entityManager.getTransaction().commit();
            entityManager.close();
            JPAUtil.shutdown();


            if (travelList.size() == 0) {
                out.println("NO MATCH!");
            } else {
                request.setAttribute("travellist ", travel);
                RequestDispatcher rd = request.getRequestDispatcher("Travel.jsp");
                rd.forward(request, response);

            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
