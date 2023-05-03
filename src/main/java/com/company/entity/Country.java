package com.company.entity;

import java.util.List;

public class Country {
private Integer id;
private String name;
private String nationality;
public Country() {

}
    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country(Integer id, String name, String nationality){
    this.id=id;
    this.name=name;
    this.nationality=nationality;
}

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
