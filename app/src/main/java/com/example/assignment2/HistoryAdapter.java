package com.example.assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryAdapter extends BaseAdapter {
    ArrayList<PurchaseReport> reportList;
    Context context;

    public HistoryAdapter(ArrayList<PurchaseReport> reportList, Context context) {
        this.reportList = reportList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.reportList.size();
    }

    @Override
    public Object getItem(int i)  {
        return this.reportList.get(i);
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

        price.setText(String.valueOf(reportList.get(i).getAmount()));
        name.setText(reportList.get(i).getName());
        quantity.setText(String.valueOf(reportList.get(i).getQuality()));
        return view;
    }
}
