package com.example.juliefalcou.my_mvvm_app.Connexion;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.juliefalcou.my_mvvm_app.Directory.Contact;
import com.example.juliefalcou.my_mvvm_app.Directory.ContactViewModel;
import com.example.juliefalcou.my_mvvm_app.Directory.Display_repository;
import com.example.juliefalcou.my_mvvm_app.Directory.Modify_Contact;
import com.example.juliefalcou.my_mvvm_app.R;

import static com.example.juliefalcou.my_mvvm_app.Directory.Display_repository.ADD_CONTACT_REQUEST;

public class Profile extends AppCompatActivity {
    String category,campus;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(Profile.this,Modify_Contact.class);
        startActivityForResult(intent,ADD_CONTACT_REQUEST);


         /*Creation of spinner*/
            /*Spinner 1*/
        /*Spinner spinner1 = findViewById(R.id.category);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.category,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 category= (String) adapterView.getItemAtPosition(i);
             }
             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {
                 category="Empty";
             }
         });
        Spinner spinner2 = findViewById(R.id.campus);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.campus,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                campus= (String) adapterView.getItemAtPosition(i);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                campus="Empty";
            }
        });

        Initialization of buttons
        Button valid = findViewById(R.id.checkprofil);
        valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstname = ((EditText) findViewById(R.id.person_firstname)).getText().toString();
                String lastname = ((EditText)findViewById(R.id.person_lastname)).getText().toString();;
                String role = category;
                String place = campus;
                String email = ((EditText)findViewById(R.id.person_email)).getText().toString();
                String phonenumber = ((EditText)findViewById(R.id.person_phone)).getText().toString();
                String password =((EditText)findViewById(R.id.person_password)).getText().toString();

                Intent intent = new Intent(Profile.this,Modify_Contact.class);*/
                /*startActivityForResult(intent,ADD_CONTACT_REQUEST);
                ObjectPerson objectPerson = new ObjectPerson();
                objectPerson.place= campus;
                objectPerson.role= category;
                objectPerson.fname= ((EditText)findViewById(R.id.person_firstname)).getText().toString();
                objectPerson.lname= ((EditText)findViewById(R.id.person_lastname)).getText().toString();
                objectPerson.number= ((EditText)findViewById(R.id.person_phone)).getText().toString();
                objectPerson.password= ((EditText)findViewById(R.id.person_password)).getText().toString();
                objectPerson.mailadress= ((EditText)findViewById(R.id.person_email)).getText().toString();

                Context context = view.getRootView().getContext();
                boolean createSuccessful = new TableControllerPerson(context).create(objectPerson);
                if(createSuccessful){
                    Toast.makeText(context, "Student information was saved.", Toast.LENGTH_SHORT).show();
                    open_Choice();

                }else{
                    Toast.makeText(context, "Unable to save student information.", Toast.LENGTH_SHORT).show();
            }
                //open_Repository();
            }



        });*/

    }

    /*private void open_Choice() {
        Intent intent = new Intent(this, Choice.class);
        startActivity(intent);
    }*/

   /* private void open_Repository() {
        Intent intent = new Intent(this, Display_repository.class);
        startActivity(intent);
    }*/


}
