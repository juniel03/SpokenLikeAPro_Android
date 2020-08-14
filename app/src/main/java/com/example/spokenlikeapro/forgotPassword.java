package com.example.spokenlikeapro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class forgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        hideSystemUI.fullscreen(this);
    }

    public void toHome(View view) {
        Intent tohome = new Intent(forgotPassword.this,MainActivity.class);
        startActivity(tohome);
    }
}