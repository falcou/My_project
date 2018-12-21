package com.example.juliefalcou.my_mvvm_app;

import android.databinding.BaseObservable;
import android.support.annotation.NonNull;
import android.text.TextUtils;

public class User extends BaseObservable {

    @NonNull
    String email, password;

    public User(){

    }

    public User(String email, String password){
        this.email = email;
        this.password = password;

    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public  boolean isValid(){
        return !TextUtils.isEmpty(getEmail()) && !TextUtils.isEmpty(getPassword());
    }
}
