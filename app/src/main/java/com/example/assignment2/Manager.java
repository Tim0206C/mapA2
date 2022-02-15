package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Manager extends AppCompatActivity implements View.OnClickListener {
Button historyBtn;
Button restockBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        historyBtn = findViewById(R.id.historyBtn);
        historyBtn.setOnClickListener(this);
        restockBtn=findViewById(R.id.restockBtn);
        restockBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent;
        switch (id){
            case R.id.historyBtn:
                //open the History activity
                intent =new Intent(this,History.class);
                startActivity(intent);
                break;
            case R.id.restockBtn:
                intent =new Intent(this,Restock.class);
                startActivity(intent);
                break;
        }
    }
}