package com.maktab.online_bus_ticket_booking;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstName",   length = 40)
    private String firstName;

    @Column(name = "lastName",   length = 65)
    private String Lastname;

    @Column(name = "email",   length = 80, unique = true)
    private String email;

    @Column(name = "User",  length = 40)
    private String user;

    @Column(name = "pass",  length = 65)
    private String pass;

    @Column(name = "gender",  length = 65)
    private String gender;

    public User(int id, String firstName, String lastName, String gender, String userName, String password) {
    }

    public User() {

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String fnamename) {
        this.firstName = fnamename;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
