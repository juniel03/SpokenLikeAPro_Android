package com.example.spokenlikeapro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class level extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        hideSystemUI.fullscreen(this);
    }

    public void toHome(View view) {
        Intent tohome = new Intent(level.this,mainScreen.class);
        startActivity(tohome);
    }

    public void toTopic(View view) {
        Intent toTopic = new Intent(level.this,topic.class);
        startActivity(toTopic);
    }
}