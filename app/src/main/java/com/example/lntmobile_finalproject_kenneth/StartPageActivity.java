package com.example.lntmobile_finalproject_kenneth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class StartPageActivity extends AppCompatActivity {


    private Button login, regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        login=findViewById(R.id.button_LoginStart);
        regis=findViewById(R.id.button_RegisStart);

        login.setOnClickListener(view -> {
            startActivity(new Intent(StartPageActivity.this, LoginActivity.class));
        });

        regis.setOnClickListener(view -> {
            startActivity(new Intent(StartPageActivity.this, RegisterActivity.class));
        });
    }
}