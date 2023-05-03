package com.company.entity;

public class Skill {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Skill() {
    }

    public Skill(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

