package com.example.spokenlikeapro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Start extends AppCompatActivity {


    Guideline guidelinemid;
    Guideline guidelinelt;
    Guideline guidelinelb;
    Guideline guidelinert;
    Guideline guidelinerb;
    ConstraintLayout.LayoutParams paramsmid;
    ConstraintLayout.LayoutParams paramslt;
    ConstraintLayout.LayoutParams paramslb;
    ConstraintLayout.LayoutParams paramsrt;
    ConstraintLayout.LayoutParams paramsrb ;
    private boolean isPremiumclicked = false;
    private boolean isRegularclicked = false;
    Button btnPremium;
    Button btnRegular;
    ImageView ivPrem;
    ImageView ivReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        hideSystemUI.fullscreen(this);

        guidelinemid =  (Guideline) findViewById(R.id.guidelinemid);
        guidelinelt =   (Guideline) findViewById(R.id.guidelinelt);
        guidelinelb =   (Guideline) findViewById(R.id.guidelinelb);
        guidelinert =   (Guideline) findViewById(R.id.guidelinert);
        guidelinerb =   (Guideline) findViewById(R.id.guidelinerb);

        paramsmid = (ConstraintLayout.LayoutParams) guidelinemid.getLayoutParams();
        paramslt = (ConstraintLayout.LayoutParams) guidelinelt.getLayoutParams();
        paramslb = (ConstraintLayout.LayoutParams) guidelinelb.getLayoutParams();
        paramsrt = (ConstraintLayout.LayoutParams) guidelinert.getLayoutParams();
        paramsrb = (ConstraintLayout.LayoutParams) guidelinerb.getLayoutParams();

        btnPremium = (Button) findViewById(R.id.btnPrem);
        btnRegular = (Button) findViewById(R.id.btnReg);

        ivPrem  =   (ImageView) findViewById(R.id.ivPrem);
        ivReg   =   (ImageView) findViewById(R.id.ivRegular);

        ivPrem.setElevation(10);
        ivReg.setElevation(10);

    }


    public void isRegular(View view) {
        paramsmid.guidePercent = 0.40f;
        paramslt.guidePercent = 0.60f;
        paramslb.guidePercent = 0.80f;
        paramsrt.guidePercent = 0.56f;
        paramsrb.guidePercent = 0.84f;
        guidelinemid.setLayoutParams(paramsmid);
        guidelinelt.setLayoutParams(paramslt);
        guidelinelb.setLayoutParams(paramslb);
        guidelinert.setLayoutParams(paramsrt);
        guidelinerb.setLayoutParams(paramsrb);
        isRegularclicked = !isRegularclicked; // toggle the boolean flag
        view.setBackgroundResource(isRegularclicked ? R.drawable.first_btn_clicked : R.drawable.first_btn_background);
        btnRegular.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
        ivReg.setImageResource(R.drawable.checked);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent start = new Intent(Start.this,MainActivity.class);
                startActivity(start);
                btnPremium.setEnabled(false);
            }
        }, 500);
    }
    public void isPremium(View view) {
        paramsmid.guidePercent = 0.60f;
        paramslt.guidePercent = 0.56f;
        paramslb.guidePercent = 0.84f;
        paramsrt.guidePercent = 0.60f;
        paramsrb.guidePercent = 0.80f;
        guidelinemid.setLayoutParams(paramsmid);
        guidelinelt.setLayoutParams(paramslt);
        guidelinelb.setLayoutParams(paramslb);
        guidelinert.setLayoutParams(paramsrt);
        guidelinerb.setLayoutParams(paramsrb);
        isPremiumclicked = !isPremiumclicked; // toggle the boolean flag
        view.setBackgroundResource(isPremiumclicked ? R.drawable.first_btn_clicked : R.drawable.first_btn_background);
        btnPremium.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
        ivPrem.setImageResource(R.drawable.checked);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent start = new Intent(Start.this,MainActivity.class);
                startActivity(start);
                btnRegular.setEnabled(false);
            }
        }, 500);
    }
}