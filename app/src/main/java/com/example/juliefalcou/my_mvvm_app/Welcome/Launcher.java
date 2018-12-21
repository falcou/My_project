package com.example.juliefalcou.my_mvvm_app.Welcome;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.juliefalcou.my_mvvm_app.Connexion.Connexion;
import com.example.juliefalcou.my_mvvm_app.Directory.Display_repository;
import com.example.juliefalcou.my_mvvm_app.Directory.Modify_Contact;
import com.example.juliefalcou.my_mvvm_app.R;

public class Launcher extends AppCompatActivity {

    public static Application context;

    /*We launch the app and this activity*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher);

        Button launcherbutton = findViewById(R.id.Launcher_button);
        launcherbutton .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_Connexion();
            }
        });

    }

    private void open_Connexion() {
        Intent intent = new Intent(this,Connexion.class);
        startActivity(intent);
    }

    private void open_Repository() {
        Intent intent = new Intent(this,Display_repository.class);
        startActivity(intent);
    }
}
