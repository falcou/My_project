package com.example.juliefalcou.my_mvvm_app;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private LoginCallback loginCallback;

    public LoginViewModelFactory(LoginCallback loginCallback){
        this.loginCallback = loginCallback;

    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)new LoginViewModel(loginCallback);
    }
}
