package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Detail extends AppCompatActivity {
    TextView name;
    TextView amount;
    TextView date;
    PurchaseReport selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        name = findViewById(R.id.reportItemName);
        amount = findViewById(R.id.reportAmount);
        date = findViewById(R.id.reportDate);
        //get the selected report object from History activity
        selected = (PurchaseReport) getIntent().getExtras().getSerializable("detail");

        //set the text view
        String tem = "Product: " + selected.getName();
        name.setText(tem);
        tem = "Price: " + String.valueOf(selected.getAmount());
        amount.setText(tem);
        tem = "Purchase Date" + String.valueOf(selected.getDate());
        date.setText(tem);
        selected = null;

    }
}