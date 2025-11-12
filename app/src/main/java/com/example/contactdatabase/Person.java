package com.example.contactdatabase;

import java.util.Date;
public class Person {
    private String name;
    private String dob;
    private String email;
    private int id;

    public Person(String name, String dob, String email){
        this.name = name;
        this.dob = dob;
        this.email = email;
    }
    public Person(int id,String name, String dob, String email){
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getDOB(){return dob;}
    public void setDOB(String dob){this.dob = dob;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    public int getId(){return id;}

    public void setId(int id) {
        this.id = id;
    }
}
