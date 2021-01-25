package com.maktab.online_bus_ticket_booking.dao;


import com.maktab.online_bus_ticket_booking.bean.User;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserUtil {

    private DataSource dataSource;

    public UserUtil(DataSource theDataSource) {
        dataSource = theDataSource;
    }

    public List<User> getUsers() throws Exception {

        List<User> userList = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {

            myConn = dataSource.getConnection();
            String sql = "select * from user";
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery(sql);
            while (myRs.next()) {

                int id = myRs.getInt("id");
                String firstName = myRs.getString("first_name");
                String lastName = myRs.getString("last_name");
                String gender = myRs.getString("gender");
                String userName = myRs.getString("username");
                String password = myRs.getString("password");
                User tempUser = new User(id, firstName, lastName,gender,userName,password);
                userList.add(tempUser);
            }

            return userList;
        }
        finally {
            close(myConn, myStmt, myRs);
        }
    }

    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

        try {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();   // doesn't really close it ... just puts back in connection pool
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void addUser(User user) throws Exception {

        String name = user.getFirstName();
        String lastname = user.getLastName();
        String  username = user.getUsername();
        String password = user.getPassword();
        String gender = user.getGender();

            Connection myConn = dataSource.getConnection();
            PreparedStatement ps= myConn .prepareStatement(
                    "INSERT INTO user\n" +
                            "(first_name,last_name,gender,username,password)\n" +
                            "VALUES\n" +
                            "(?,?,?,?,?)");
            ps.setString(1,name);
            ps.setString(2,lastname);
            ps.setString(3,gender);
            ps.setString(4,username);
            ps.setString(5,password);
            ps.executeUpdate();
            myConn.close();
            ps.close();



    }

    public User getUser(String theUserId) throws Exception {

        User theUser = null;

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        int userId;

        try {
            // convert student id to int
            userId = Integer.parseInt(theUserId);

            myConn = dataSource.getConnection();

            String sql = "select * from user where id=?";

            myStmt = myConn.prepareStatement(sql);

            myStmt.setInt(1, userId);
            myRs = myStmt.executeQuery();

            if (myRs.next()) {
                String firstName = myRs.getString("first_name");
                String lastName = myRs.getString("last_name");
                String gender = myRs.getString("gender");
                String userName = myRs.getString("username");
                String password = myRs.getString("password");

                // use the userId during construction
                theUser = new User(userId, firstName, lastName, gender,userName,password);
            }
            else {
                throw new Exception("Could not find student id: " + userId);
            }

            return theUser;
        }
        finally {

            close(myConn, myStmt, myRs);
        }
    }

    public void updateUser(User theUser) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            // get db connection
            myConn = dataSource.getConnection();

            // create SQL update statement
            String sql = "update student "
                    + "set first_name=?, last_name=?, gender=?, username=?, password=? "
                    + "where id=?";

            // prepare statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setString(1, theUser.getFirstName());
            myStmt.setString(2, theUser.getLastName());
            myStmt.setString(3, theUser.getGender());
            myStmt.setString(4, theUser.getUsername());
            myStmt.setString(5, theUser.getPassword());

            // execute SQL statement
            myStmt.execute();
        }
        finally {
            // clean up JDBC objects
            close(myConn, myStmt, null);
        }
    }

    public void deleteUser(String theStudentId) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            int theUserId = Integer.parseInt(theStudentId);

            myConn = dataSource.getConnection();

            // create sql to delete student
            String sql = "delete from user where id=?";

            // prepare statement
            myStmt = myConn.prepareStatement(sql);

            // set params
            myStmt.setInt(1, theUserId);

            // execute sql statement
            myStmt.execute();
        }
        finally {
            // clean up JDBC code
            close(myConn, myStmt, null);
        }
    }

    public static boolean validate(String name,String pass){
        boolean status=false;
        try{
            Connection myConn = null;
            Statement myStmt = null;
            ResultSet myRs = null;


                String sql = "select * from user";
                myStmt = myConn.createStatement();
                myRs = myStmt.executeQuery(sql);

                while (myRs.next()) {
                    String userName = myRs.getString("username");
                    String password = myRs.getString("password");
                }

            PreparedStatement ps = myConn.prepareStatement(
                    "select * from userreg where name=? and pass=?");
            ps.setString(1,name);
            ps.setString(2,pass);

            ResultSet rs=ps.executeQuery();
            status=rs.next();

        }catch(Exception e){System.out.println(e);}
        return status;
    }
}
