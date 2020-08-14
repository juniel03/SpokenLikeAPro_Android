package com.example.spokenlikeapro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class accent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accent);
        hideSystemUI.fullscreen(this);
    }

    public void toHome(View view) {
        Intent tohome = new Intent(accent.this,mainScreen.class);
        startActivity(tohome);
    }

    public void toLevel(View view) {
        Intent toLevel = new Intent(accent.this,level.class);
        startActivity(toLevel);
    }

    public void british(View view) {

    }

    public void australian(View view) {

    }
}