package com.maktab.online_bus_ticket_booking.controller;

import com.maktab.online_bus_ticket_booking.bean.Travel;

import javax.annotation.Resource;
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
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@WebServlet("/TravelcontrollerServlet")
public class TravelcontrollerServlet extends HttpServlet {

    @Resource(name = "jdbc/bus_tickets_booking")
    private DataSource dataSource;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String travelFrom = request.getParameter("travel_from");
        String travelTo = request.getParameter("travel_to");
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(year).append("-").append(month).append("-").append(day);
        String date = stringBuilder.toString();
        List<Travel> travelList = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from travel\n" +
                    "where travel_from = ? and travel_to = ? and date = ? order by date ");
            ps.setString(1,travelFrom);
            ps.setString(2,travelTo);
            ps.setString(3,date);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()){
                Travel travel = new Travel();
                travel.setId(resultSet.getInt("id"));
                travel.setTravelFrom(resultSet.getString("travel_from"));
                travel.setTravelTo(resultSet.getString("travel_to"));
                travel.setDate(resultSet.getString("date"));
                travel.setTime(resultSet.getString("time"));
                travel.setTravelId(resultSet.getInt("travel_id"));
                travelList.add(travel);

            }
            if(travelList.size() == 0){
                out.println("NO MATCH!");
            }else {
                request.setAttribute("travelList", travelList);
                RequestDispatcher rd = request.getRequestDispatcher("travel.jsp");
                rd.forward(request, response);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
