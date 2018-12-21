package com.example.juliefalcou.my_mvvm_app;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


import com.example.juliefalcou.my_mvvm_app.Connexion.Profile;
import com.example.juliefalcou.my_mvvm_app.Directory.Display_repository;
import com.example.juliefalcou.my_mvvm_app.databinding.ActivityMainBinding;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements LoginCallback {

    private ActivityMainBinding my_binding;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*my_binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        my_binding.setViewModel(ViewModelProviders.of(this,new LoginViewModelFactory(this)).get(LoginViewModel.class));*/
    }

    @Override
    public void Success(String message) {
        Toasty.success(this,"Login success !",Toast.LENGTH_LONG);
        open_Profile();
    }

    @Override
    public void Error(String message) {
        Toasty.error(this,"Login is impossible !",Toast.LENGTH_LONG);
    }


    public void Success2() {
        open_Display();
    }


    private void open_Profile() {
        Intent intent = new Intent(this,Profile.class);
        startActivity(intent);
    }

    private void open_Display() {
        Intent intent = new Intent(this, Display_repository.class);
        startActivity(intent);
    }

}
