package com.maktab.online_bus_ticket_booking;



import javax.persistence.*;


//private Integer id;
//private String travelFrom;
//private String travelTo;
//private String year;
//private String month;
//private String day;
//private String time;
//private String date;
//private Integer travelId;

@Entity
@Table(name = "Travel")
public class Travel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "travelFrom",   length = 40)
    private String travelFrom;

    @Column(name = "travelTo",   length = 65)
    private String travelTo;

    @Column(name = "year",   length = 80, unique = true)
    private String year;

    @Column(name = "month",  length = 40)
    private String month;

    @Column(name = "day",  length = 65)
    private String day;

    @Column(name = "time",  length = 65)
    private String time;

    @Column(name = "date",  length = 65)
    private String date;

    @Column(name = "SpecificId",  length = 65)
    private String SpecificId;

    public String getSpecificId() {
        return SpecificId;
    }

    public void setSpecificId(String specificId) {
        SpecificId = specificId;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
