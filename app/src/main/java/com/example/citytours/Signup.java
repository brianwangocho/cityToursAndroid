package com.example.citytours;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;

public class Signup extends AppCompatActivity {
    TextInputLayout username,password,fullname,email,phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        fullname = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phoneNumber);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

    }


    private Boolean validateName(){
        String name = fullname.getEditText().getText().toString();
        if(name.isEmpty()){
            fullname.setError("Field cant be empty");
            return false;

        }
        fullname.setError(null);
        fullname.setEnabled(false);
        return  true;

    }

    private Boolean validateUsername(){
        String val = username.getEditText().getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";
        if(val.isEmpty()){
            username.setError("Field cant be empty");
            return false;

        }
        else if(val.length()>=15){
            username.setError("username is too long");
            return false;

        }
        else if(!val.matches(noWhiteSpace))
        {
            username.setError("white spaces are not allowed");
            return false;

        }
        username.setError(null);
        username.setEnabled(false);
        return  true;

    }

    private Boolean validateEmail(){
        String val = email.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9]+@[a-z]+\\.+[a-z]+";

        if(val.isEmpty()){
            email.setError("Field cant be empty");
            return false;

        }
        if(!val.matches(emailPattern)){
            email.setError("enter a valid email address");
            return false;


        }
        email.setError(null);
        email.setEnabled(false);
        return  true;

    }

    private Boolean validatePhone(){
        String val = phone.getEditText().getText().toString();
        if(val.isEmpty()){
            phone.setError("Field cant be empty");
            return false;

        }
        phone.setError(null);
        phone.setErrorEnabled(false);
        return  true;

    }

    private Boolean validatePassword(){
        String val = password.getEditText().getText().toString();
        String passwordVal =  "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";
        if(val.isEmpty()){
            password.setError("Field cant be empty");
            return false;

        }
        else if(!val.matches(passwordVal)){
            password.setError("password is too weak");
            return false;


        }
        password.setError(null);
        password.setErrorEnabled(false);
        return  true;

    }


    public void registerUser(View view){

        if( !validateName()|| !validateEmail() ||
                !validatePhone() || !validateUsername() || !validatePassword()
        ){
            return;
        }

    }
}
