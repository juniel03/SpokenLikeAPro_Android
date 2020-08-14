package com.example.spokenlikeapro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.Toast;

public class mainScreen extends AppCompatActivity {

    ImageButton ivSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        hideSystemUI.fullscreen(this);
        ivSettings = (ImageButton) findViewById(R.id.ivSettings);
    }

    public void start(View view) {
        Intent accent = new Intent(mainScreen.this,accent.class);
        startActivity(accent);
    }

    public void menu(View view) {
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View popupView = layoutInflater.inflate(R.layout.main_menu_popup, null);

        final PopupWindow popupWindow = new PopupWindow(
                popupView,
                700,300);

        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                //TODO do sth here on dismiss
            }
        });
        Button btnProfile = (Button)popupView.findViewById(R.id.btnProfile);
        btnProfile.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent toprofile = new Intent(mainScreen.this,profile.class);
                startActivity(toprofile);
                popupWindow.dismiss();
            }});

        Button btnaccent = (Button)popupView.findViewById(R.id.btnAccent);
        btnaccent.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent toprofile = new Intent(mainScreen.this,accent.class);
                startActivity(toprofile);
                popupWindow.dismiss();
            }});

        popupWindow.showAsDropDown(view,-200,0);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI.fullscreen(this);
        }
    }
}