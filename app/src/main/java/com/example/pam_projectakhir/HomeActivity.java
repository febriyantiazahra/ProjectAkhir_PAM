package com.example.pam_projectakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {
    LinearLayout btnAbout, btnSetting, btnHelp, btnFAQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnAbout = (LinearLayout) findViewById(R.id.about);
        btnSetting = (LinearLayout) findViewById(R.id.setting);
        btnHelp = (LinearLayout) findViewById(R.id.help);
        btnFAQ = (LinearLayout) findViewById(R.id.input);

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutIntent =new Intent(HomeActivity.this, SyaratActivity.class);
                startActivity(aboutIntent);
            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutIntent = new Intent(HomeActivity.this, InputDataActivity.class);
                startActivity(aboutIntent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutIntent = new Intent(HomeActivity.this, AboutActivity.class);
                startActivity(aboutIntent);
            }
        });

        btnFAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutIntent = new Intent(HomeActivity.this, MainMenuActivity.class);
                startActivity(aboutIntent);
            }
        });
    }
}