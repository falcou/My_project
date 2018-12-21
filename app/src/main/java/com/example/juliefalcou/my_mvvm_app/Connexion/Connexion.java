package com.example.juliefalcou.my_mvvm_app.Connexion;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.juliefalcou.my_mvvm_app.Directory.Contact;
import com.example.juliefalcou.my_mvvm_app.Directory.ContactRepository;
import com.example.juliefalcou.my_mvvm_app.Directory.Display_repository;
import com.example.juliefalcou.my_mvvm_app.R;

import java.util.List;

public class Connexion extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);


        /*Initialization of buttons*/
        Button connectaccess = findViewById(R.id.Connect_access);
        Button connectprofile = findViewById(R.id.Connect_profile);

        /* Recovery of identifiants  */
        final EditText email = findViewById (R.id.Connect_email);
        final EditText password = findViewById (R.id.Connect_password);

        /*Access for the rest of app*/
        connectaccess.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                check_connexion(email,password,view,getApplication());
            }
        });

        /*Access for profile*/
        connectprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_Profile();
            }
        });
    }

    private void open_Profile() {
        Intent intent = new Intent(this,Profile.class);
        startActivity(intent);
    }

    private void open_Display() {
        Intent intent = new Intent(this, Display_repository.class);
        startActivity(intent);
    }

    void check_connexion(EditText email, EditText password, View view, Application application) {
        boolean connect_successfull = false;
        boolean email_fail = false;
        boolean password_fail = false;
        String personemail = null, personpassword=null;
        Context context = view.getContext();
        ContactRepository repository = new ContactRepository(application);
        LiveData<List<Contact>> allContacts = repository.getAllContacts();

        if(!email.getText().toString().isEmpty()&& !password.getText().toString().isEmpty()){
            open_Display();
        }
        else if(!email.getText().toString().isEmpty() && password.getText().toString().isEmpty()){
            Toast.makeText(context, "Password is ok but not the email address", Toast.LENGTH_SHORT).show();
        }
        else if(email.getText().toString().isEmpty() && !password.getText().toString().isEmpty()){
            Toast.makeText(context, "Email address is ok but not the password", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Connection is impossible", Toast.LENGTH_SHORT).show();
        }
        /*personemail = allContacts.getValue().get(0).getEmail();
        personpassword = allContacts.getValue().get(0).getPassword();*/
        /*for (int i = 0; i < allContacts.getValue().size(); i++) {


            if (personemail.equalsIgnoreCase(email.getText().toString()) && !(personpassword.equalsIgnoreCase(password.getText().toString()))) {
                password_fail = true;
                Log.i("try", "Connection is impossible");
            } else if (personpassword.equalsIgnoreCase(password.getText().toString()) && !(personemail.equalsIgnoreCase(email.getText().toString()))) {
                email_fail = true;
            } else if (personpassword.equalsIgnoreCase(password.getText().toString()) && personemail.equalsIgnoreCase(email.getText().toString())) {
                connect_successfull = true;

            } else {
            }
        }*/
        /*if (password_fail){
            Toast.makeText(context, "Email address is ok but not the password", Toast.LENGTH_SHORT).show();
        }
        else if (email_fail) {
            Toast.makeText(context, "Password is ok but not the email address", Toast.LENGTH_SHORT).show();
        }
        else if (connect_successfull){
            Toast.makeText(context, "Connection is ok", Toast.LENGTH_SHORT).show();
            open_Display();
        }
        else{
            Toast.makeText(context, "Connection is impossible", Toast.LENGTH_SHORT).show();
        }*/

    }

}
