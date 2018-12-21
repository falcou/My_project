package com.example.juliefalcou.my_mvvm_app;

import android.arch.lifecycle.ViewModel;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

public class LoginViewModel extends ViewModel {

    private User user;
    private LoginCallback callback;

    public LoginViewModel(LoginCallback callback) {
        this.callback = callback;
        this.user = new User();
    }

    public TextWatcher getEmail (){

        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence sequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence sequence, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable sequence) {
                user.setEmail(sequence.toString());

            }
        };
    }

    public TextWatcher getPassword (){

        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence sequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence sequence, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable sequence) {
                user.setPassword(sequence.toString());

            }
        };
    }

    public void Connect (){
        if(user.isValid()){
            callback.Success("Login success !");

        }
        else{
            callback.Error("Login impossible!");
        }
    }





    /*void check_connection(EditText email, EditText password, View view, Application application) {
        boolean connect_successfull = false;
        boolean email_fail = false;
        boolean password_fail = false;
        String personemail, personpassword;
        Context context = view.getContext();
        ContactRepository repository = new ContactRepository(application);
        LiveData<List<Contact>> allContacts = repository.getAllContacts();
        for (int i = 0; i < allContacts.getValue().size(); i++) {
            personemail = allContacts.getValue().get(i).getEmail();
            personpassword = allContacts.getValue().get(i).getPassword();
            if (personemail.equalsIgnoreCase(email.getText().toString()) && !(personpassword.equalsIgnoreCase(password.getText().toString()))) {
                password_fail = true;
                Log.i("try", "Connection is impossible");
            } else if (personpassword.equalsIgnoreCase(password.getText().toString()) && !(personemail.equalsIgnoreCase(email.getText().toString()))) {
                email_fail = true;
            } else if (personpassword.equalsIgnoreCase(password.getText().toString()) && personemail.equalsIgnoreCase(email.getText().toString())) {
                connect_successfull = true;
                callback.Success("Connection is ok");
            } else {
            }
        }
    }*/
}

