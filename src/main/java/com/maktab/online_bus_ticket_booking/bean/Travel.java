package com.maktab.online_bus_ticket_booking.bean;

import java.time.LocalDate;
import java.time.LocalTime;

public class Travel {

    private Integer id;
    private String travelFrom;
    private String travelTo;
    private LocalDate date;
    private LocalTime time;
    private Integer travelId;

    public Travel(Integer id, String travelFrom, String travelTo, LocalDate date, LocalTime time, Integer travelId) {
        this.id = id;
        this.travelFrom = travelFrom;
        this.travelTo = travelTo;
        this.date = date;
        this.time = time;
        this.travelId = travelId;
    }

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Integer getTravelId() {
        return travelId;
    }

    public void setTravelId(Integer travelId) {
        this.travelId = travelId;
    }
}
