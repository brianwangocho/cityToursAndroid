package com.example.citytours;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    TextView signUpLink,signUpText;
    ImageView imageLogo;
    TextInputLayout username,password;
    Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        signUpLink = findViewById(R.id.signupLink);
        imageLogo = findViewById(R.id.image_logo);
        signUpText = findViewById(R.id.signUptext);
        username  = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);


        signUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Signup.class);
                Pair[] pairs =new Pair[5];
                pairs[0] = new Pair<View,String>(imageLogo,"logo_image");
                pairs[1] = new Pair<View,String>(signUpText,"logo_text");
                pairs[2] = new Pair<View,String>(username,"username-transition");
                pairs[3] = new Pair<View,String>(password,"password-transition");
                pairs[4] = new Pair<View,String>(password,"button-transition");


                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                  ActivityOptions  options = ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs);
                    startActivity(intent,options.toBundle());
                }



            }
        });

    }
}
