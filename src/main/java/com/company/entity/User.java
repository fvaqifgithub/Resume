package com.company.entity;

import com.company.entity.Country;

import java.sql.Date;

public class User {
    private int id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private Date birthdate;
    private Country country;
    private Country birthplace;

    public User(int id){
        this.id=id;
    }
    public User() {
    }

    public User(int id,String name, String surname, String phone, String email, Date birthdate, Country birthplace, Country country) {
       this.id=id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.birthdate = birthdate;
        this.country = country;
        this.birthplace = birthplace;
    }

    public Country getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(Country birthplace) {
        this.birthplace = birthplace;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthdate=" + birthdate +
                ", nationality=" + country +
                ", birthplace=" + birthplace +
                '}';
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Country getNationality() {
        return country;
    }

    public void setNationality(Country country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
