package com.example.spokenlikeapro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class windows extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_windows);
        hideSystemUI.fullscreen(this);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        hideSystemUI.fullscreen(this);
    }

    public void pop(View view) {
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View popupView = layoutInflater.inflate(R.layout.main_menu_popup, null);

        final PopupWindow popupWindow = new PopupWindow(
                popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                //TODO do sth here on dismiss
            }
        });

        Button btnDismiss = (Button)popupView.findViewById(R.id.btnAccent);
        btnDismiss.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "YEY!", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }});


        popupWindow.showAsDropDown(view,-250,0);

    }

}