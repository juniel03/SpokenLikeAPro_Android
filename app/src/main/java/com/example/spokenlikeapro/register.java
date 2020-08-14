package com.example.spokenlikeapro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        hideSystemUI.fullscreen(this);

    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI.fullscreen(this);
        }
    }

    public void toHome(View view) {
        Intent tohome = new Intent(register.this,MainActivity.class);
        startActivity(tohome);
    }
}