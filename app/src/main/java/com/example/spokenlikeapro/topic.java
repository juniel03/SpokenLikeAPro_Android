package com.example.spokenlikeapro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class topic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        hideSystemUI.fullscreen(this);
    }

    public void toHome(View view) {
        Intent tohome = new Intent(topic.this,level.class);
        startActivity(tohome);
    }

    public void toRecord(View view) {
        Intent Record = new Intent(topic.this,playScreen.class);
        startActivity(Record);
    }
}