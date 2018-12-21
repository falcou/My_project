package com.example.juliefalcou.my_mvvm_app.Directory;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.juliefalcou.my_mvvm_app.R;

public class Modify_Contact extends AppCompatActivity {
    public static final String EXTRA_ID =
            "com.example.juliefalcou.my_mvvm_app.EXTRA_ID";
    public static final String EXTRA_FIRSTNAME =
            "com.example.juliefalcou.my_mvvm_app.EXTRA_FIRSTNAME";
    public static final String EXTRA_LASTNAME =
            "com.example.juliefalcou.my_mvvm_app.EXTRA_LASTNAME";
    public static final String EXTRA_ROLE =
            "com.example.juliefalcou.my_mvvm_app.EXTRA_ROLE";
    public static final String EXTRA_PLACE =
            "com.example.juliefalcou.my_mvvm_app.EXTRA_PLACE";
    public static final String EXTRA_EMAIL =
            "com.example.juliefalcou.my_mvvm_app.EXTRA_EMAIL";
    public static final String EXTRA_PHONENUMBER =
            "com.example.juliefalcou.my_mvvm_app.EXTRA_PHONENUMBER";
    public static final String EXTRA_PASSWORD =
            "com.example.juliefalcou.my_mvvm_app.EXTRA_PASSWORD";


    private EditText editTextFirstname, editTextLastname, editTextPlace, editTextEmail, editTextPhonenumber, editTextPassword, editTextRole;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_contact);

        ImageButton call = findViewById(R.id.Modify_contact_call);


        editTextFirstname = findViewById(R.id.Modify_contact_firstname);
        editTextLastname = findViewById(R.id.Modify_contact_lastname);
        editTextRole = findViewById(R.id.Modify_contact_role);
        editTextPlace = findViewById(R.id.Modify_contact_place);
        editTextEmail = findViewById(R.id.Modify_contact_email);
        editTextPhonenumber = findViewById(R.id.Modify_contact_phonenumber);
        editTextPassword = findViewById(R.id.Modify_contact_password);

        Intent intent = getIntent();

        Log.i("try",editTextPhonenumber.getText().toString());
        call.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the intent.
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                // Set the data for the intent as the phone number.
                dialIntent.setData(Uri.parse("tel:"+editTextPhonenumber.getText().toString()));
                // If package resolves to an app, send intent.
                if (dialIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(dialIntent);
                } else {
                    Log.e("try", "Can't resolve app for ACTION_DIAL Intent.");
                }
            }});
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);


        if (intent.hasExtra(EXTRA_ID)){
            setTitle("Edit Contact");
            editTextFirstname.setText(intent.getStringExtra(EXTRA_FIRSTNAME));
            editTextLastname.setText(intent.getStringExtra(EXTRA_LASTNAME));
            editTextRole.setText(intent.getStringExtra(EXTRA_ROLE));
            editTextPlace.setText(intent.getStringExtra(EXTRA_PLACE));
            editTextEmail.setText(intent.getStringExtra(EXTRA_EMAIL));
            editTextPhonenumber.setText(intent.getStringExtra(EXTRA_PHONENUMBER));
            editTextPassword.setText(intent.getStringExtra(EXTRA_PASSWORD));
        }
        else{
        setTitle("Add Contact");}
    }

    private void saveContact() {
        String firstname= editTextFirstname.getText().toString();
        String lastname = editTextLastname.getText().toString();
        String role = editTextRole.getText().toString();
        String place = editTextPlace.getText().toString();
        String email = editTextEmail.getText().toString();
        String phonenumber = editTextPhonenumber.getText().toString();
        String password = editTextPassword.getText().toString();

        if (firstname.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a firstname", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(lastname.trim().isEmpty()){
            Toast.makeText(this, "Please insert a lastname", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(role.trim().isEmpty()){
            Toast.makeText(this, "Please insert a role", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(place.trim().isEmpty()){
            Toast.makeText(this, "Please insert a campus", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(email.trim().isEmpty()){
            Toast.makeText(this, "Please insert an email", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(phonenumber.trim().isEmpty()){
            Toast.makeText(this, "Please insert a phone number", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(password.trim().isEmpty()){
            Toast.makeText(this, "Please insert a password", Toast.LENGTH_SHORT).show();
            return;
        }


        Intent data = new Intent();
        data.putExtra(EXTRA_FIRSTNAME, firstname);
        data.putExtra(EXTRA_LASTNAME, lastname);
        data.putExtra(EXTRA_ROLE, role);
        data.putExtra(EXTRA_PLACE, place);
        data.putExtra(EXTRA_EMAIL, email);
        data.putExtra(EXTRA_PHONENUMBER, phonenumber);
        data.putExtra(EXTRA_PASSWORD, password);

        int id = getIntent().getIntExtra(EXTRA_ID,-1);
        if (id!=-1){
            data.putExtra(EXTRA_ID,id);
        }
        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_contact_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_contact:
                saveContact();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
