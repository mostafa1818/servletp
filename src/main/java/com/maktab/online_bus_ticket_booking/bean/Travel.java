package com.maktab.online_bus_ticket_booking.bean;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class Travel {

    private Integer id;
    private String travelFrom;
    private String travelTo;
    private String year;
    private String month;
    private String day;
    private String time;
    private String date;
    private Integer travelId;

    public Travel(){}



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTravelFrom() {
        return travelFrom;
    }

    public void setTravelFrom(String travelFrom) {
        this.travelFrom = travelFrom;
    }

    public String getTravelTo() {
        return travelTo;
    }

    public void setTravelTo(String travelTo) {
        this.travelTo = travelTo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getTravelId() {
        return travelId;
    }

    public void setTravelId(Integer travelId) {
        this.travelId = travelId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
