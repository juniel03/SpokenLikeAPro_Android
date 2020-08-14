package com.example.spokenlikeapro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class loadingScreen extends AppCompatActivity {

    int progress = 0;
    ProgressBar simpleProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);
        hideSystemUI.fullscreen(this);
        simpleProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        setProgressValue(progress);


    }

    private void setProgressValue(final int progress) {
        // set the progress
        simpleProgressBar.setProgress(progress);
        // thread is used to change the progress value
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (progress == 100){
                    Intent mainscreen = new Intent(loadingScreen.this,mainScreen.class);
                    startActivity(mainscreen);
                }else {
                    setProgressValue(progress + 25);
                }
            }
        });
        thread.start();
    }
}