package com.maktab.online_bus_ticket_booking.dao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TicketUtil {

    private DataSource dataSource;
    public TicketUtil(DataSource theDataSource) {
        dataSource = theDataSource;
    }

    public void addTicket(int userId,int travelId) throws Exception{
        Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement("insert into ticket " +
                "(user_id,travel_id) value (?,?)");
        ps.setInt(1,userId);
        ps.setInt(2,travelId);
        ps.executeUpdate();
        ps.close();
        connection.close();
    }

    public Integer findUserId(String username) throws Exception{
        int id = 0;
        Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement("select id from user where username = ?");
        ps.setString(1,username);
        ps.executeQuery();
        ResultSet resultSet = ps.getResultSet();
        while (resultSet.next()) {
            id = resultSet.getInt("id");
        }
        return id;
    }

}
