package com.example.spokenlikeapro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.Toast;

public class postRecord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_record);
        hideSystemUI.fullscreen(this);
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI.fullscreen(this);
        }
    }

    public void Menu1(View view) {
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View popupView = layoutInflater.inflate(R.layout.popup, null);

        final PopupWindow popupWindow = new PopupWindow(
                popupView,
                700, 700);

        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                //TODO do sth here on dismiss
            }
        });

        Button upload = (Button)popupView.findViewById(R.id.btnUpload);
        upload.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "upload", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }});

        Button send = (Button)popupView.findViewById(R.id.btnSend);
        send.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "send", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }});

        Button save = (Button)popupView.findViewById(R.id.btnSave);
        save.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }});

        Button delete = (Button)popupView.findViewById(R.id.btnDelete);
        delete.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "delete", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }});


        popupWindow.showAsDropDown(view,-450,-900);

    }

    public void repeat(View view) {
        Intent repeat = new Intent(postRecord.this,playScreen.class);
        startActivity(repeat);
    }

    public void next(View view) {
        Intent next = new Intent(postRecord.this,playScreen.class);
        startActivity(next);
    }

    public void toHome(View view) {
        Intent tohome = new Intent(postRecord.this,mainScreen.class);
        startActivity(tohome);
    }
}