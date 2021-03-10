package com.company.entities;

public class User {


    private String name ;
    private String surname ;
    private int yin ;
    private String login ;
    private String password ;
    private String telephone ;

    public User(String name, String surname, int yin, String login, String password, String telephone) {
        this.name = name;
        this.surname = surname;
        this.yin = yin;
        this.login = login;
        this.password = password;
        this.telephone = telephone;
    }
    public User(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYin() {
        return yin;
    }

    public void setYin(int yin) {
        this.yin = yin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}