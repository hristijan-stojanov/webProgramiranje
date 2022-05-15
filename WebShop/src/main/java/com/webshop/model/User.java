package com.webshop.model;
import javax.persistence.*;

@Entity
public class User {
    @Id
    String username;
    String password;
    String FirstName;
    String LastName;
    int PhoneNumber;
    String Adres;
    @Enumerated(EnumType.STRING)
    Role role;

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
        FirstName = "";
        LastName ="";
        PhoneNumber=0;
        Adres="";

    }

    public User(String username, String password, String firstName, String lastName, int phoneNumber, String adres) {
        this.username = username;
        this.password = password;
        FirstName = firstName;
        LastName = lastName;
        PhoneNumber = phoneNumber;
        Adres = adres;
        this.role = Role.ROLE_USER;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public String getAdres() {
        return Adres;
    }

    public User() {

    }




    public String getUsername() {
        return username;
    }



    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
       this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
