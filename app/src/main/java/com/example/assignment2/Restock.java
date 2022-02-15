package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Restock extends AppCompatActivity implements View.OnClickListener {

    ProductsManager productsManager;
    ListView restockAdapterList;
    Button okBtn;
    Button cancelBtn;
    Product selected;
    EditText newQuantity;
    ProductListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);

        okBtn = findViewById(R.id.confirmBtn);
        okBtn.setOnClickListener(this);
        cancelBtn = findViewById(R.id.cancelBtn);
        cancelBtn.setOnClickListener(this);
        newQuantity = findViewById(R.id.addQuantity);

        productsManager = ((MyApp)getApplication()).productsManager;
        restockAdapterList = findViewById(R.id.restockList);

         adapter = new ProductListAdapter(productsManager.products,this);
        restockAdapterList.setAdapter(adapter);
        selected = new Product();

        restockAdapterList.setOnItemClickListener((adapterView, view, position, l) -> {
            selected = (Product) adapterView.getItemAtPosition(position);
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.confirmBtn:
                reStock();
                break;
            case R.id.cancelBtn:
                //go back to main activity
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }

    }

    private void reStock(){
        int quantity=newQuantity.getText().toString().isEmpty()?0:Integer.parseInt(newQuantity.getText().toString());
        if(selected.getName().length()>0 && quantity>0){
            productsManager.addQty(selected,quantity);
            selected = new Product();
//            ProductListAdapter adapter = new ProductListAdapter(productsManager.products,this);
//            restockAdapterList.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }else{
            Toast.makeText(this, "All fields are REQUIRED", Toast.LENGTH_LONG).show();
        }
    }
}