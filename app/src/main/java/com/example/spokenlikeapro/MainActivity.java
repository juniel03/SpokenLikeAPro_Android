package com.example.spokenlikeapro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            hideSystemUI.fullscreen(this);

    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI.fullscreen(this);

        }
    }

    public void goToRegister(View view) {
        Intent register = new Intent(MainActivity.this,register.class);
        startActivity(register);
    }

    public void forgotPassword(View view) {
        Intent forgotpassword = new Intent(MainActivity.this,forgotPassword.class);
        startActivity(forgotpassword);
    }

    public void login(View view) {
        Intent login = new Intent(MainActivity.this,loadingScreen.class);
        startActivity(login);
    }
}