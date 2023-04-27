package com.example.lntmobile_finalproject_kenneth;

public class Data {
    private String ID;
    private String email;
    private String name;
    private String pass;

    public Data(){

    }

    public Data(String ID, String email, String name, String pass) {
        this.ID = ID;
        this.email = email;
        this.name = name;
        this.pass = pass;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
