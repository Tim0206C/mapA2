package com.example.assignment2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    NumberPicker numberPicker;
    TextView total;
    TextView productType;
    TextView quantity;
    ListView productAdapterList;

    ArrayList<Product> products;
    Product selected;
    HistoryManager historyManager;
    ProductsManager productsManager;

    ProductListAdapter adapter;

    Button manager;
    Button buy;

    //check the item and quantity is selected correctly or not, ready to BUY
    boolean ready;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ready = false;
        productsManager=((MyApp)getApplication()).productsManager;
        selected =((MyApp)getApplication()).selectedProduct;
        historyManager = ((MyApp)getApplication()).historyManager;
        quantity = findViewById(R.id.quantity);
        productType = findViewById(R.id.productType);
        total = findViewById(R.id.total);
        //setup the numberPicker
        numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMaxValue(100);
        numberPicker.setMinValue(0);
        numberPicker.setValue(0);

        manager = findViewById(R.id.manager);
        manager.setOnClickListener(this);
        buy = findViewById(R.id.buy);
        buy.setOnClickListener(this);

        numberPicker.setOnValueChangedListener((numberPicker, i, i1) -> {
            quantity.setText(String.valueOf(i1) );
            if (selected.getName().length()>0){
                //no enough quantity in stock
                if(selected.getQuantityInStock()<i1){
                    Toast.makeText(this,"No enough quantity in the stock!!!", Toast.LENGTH_LONG).show();
                }else{
                    ready=true;
                }
                double amount =Double.valueOf(String.valueOf((float)(selected.getPrice() *Integer.parseInt(quantity.getText().toString())))) ;
                total.setText(String.valueOf(amount));
            }
        });

        productAdapterList = findViewById(R.id.productList);
         products = productsManager.products;

        adapter = new ProductListAdapter(products,this);
        productAdapterList.setAdapter(adapter);
        productAdapterList.setOnItemClickListener((adapterView, view, position, l) -> {
            selected = (Product) adapterView.getItemAtPosition(position);
            String name = selected.getName();

            //check the quantity is selected or not
            if(quantity.getText().toString().matches("^[0-9]$|^[1-9][0-9]$|^(100)$")){

                double amount =Double.parseDouble(String.valueOf((float)(selected.getPrice() *Integer.parseInt(quantity.getText().toString())))) ;
                //double amount =selected.getPrice() *Integer.parseInt(quantity.getText().toString());
                total.setText(String.valueOf(amount));
                ready = true;
            }else{
                total.setText("Total");
            }
            productType.setText(name);

        });
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.manager:
                //open the manager activity
                Intent intent =new Intent(this,Manager.class);
                startActivity(intent);
                break;
            case R.id.buy:
                if(ready){
                    double amount =Double.valueOf(String.valueOf((float)(selected.getPrice() *Integer.parseInt(quantity.getText().toString())))) ;
                    String name = selected.getName();
                    int num = Integer.parseInt(quantity.getText().toString());
                    PurchaseReport report = new PurchaseReport(name,num,amount);
                    historyManager.addRecord(report);
                    productsManager.setQty(selected,num);

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Thank You for your purchase");
                    builder.setMessage("your purchase is " + num + " " + name + " for " + amount);
                    builder.show();

                    //reset the product adapter to show the quantity
                    adapter.notifyDataSetChanged();

                    //((MyApp)getApplication()).selectedProduct = new Product();
                    //reset the data to next purchase
                    selected = new Product();
                    ready = false;
                    productType.setText("Product Type");
                    quantity.setText("Quantity");
                    total.setText("Total");

                }else{
                    Toast.makeText(this,"All fields are required!!!", Toast.LENGTH_LONG).show();
                }
                //buy
                break;
        }
    }
}