package com.example.assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductListAdapter extends BaseAdapter {

    ArrayList<Product> productList;
    Context context;

    public ProductListAdapter(ArrayList<Product> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }


    @Override
    public int getCount() {
        return this.productList.size();
    }

    @Override
    public Object getItem(int i) {
        return this.productList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.item_list,null);
        TextView price = view.findViewById(R.id.itemPrice);
        TextView name = view.findViewById(R.id.itemName);
        TextView quantity = view.findViewById(R.id.itemQuantity);

        price.setText(String.valueOf(productList.get(i).getPrice()));
        name.setText(productList.get(i).getName());
        quantity.setText(String.valueOf(productList.get(i).getQuantityInStock()));
        return view;
    }
}
