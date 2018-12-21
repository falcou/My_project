package com.example.juliefalcou.my_mvvm_app.Directory;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "List_of_contacts")
public class Contact {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String firstname,lastname,role,place,email,phonenumber,password;

    public Contact(String firstname, String lastname, String role, String place, String email, String phonenumber, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
        this.place = place;
        this.email = email;
        this.phonenumber = phonenumber;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getRole() {
        return role;
    }

    public String getPlace() {
        return place;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getPassword(){return password;}

    public Character getFirst_letter(){ return lastname.toUpperCase().charAt(0);}

    public String getName(){ return getFirstname()+" "+getLastname(); }
}
