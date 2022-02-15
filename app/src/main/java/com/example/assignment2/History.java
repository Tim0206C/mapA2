package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class History extends AppCompatActivity {

   // ArrayList<PurchaseReport> reports;
    ListView historyList;
    HistoryAdapter adapter;
    HistoryManager historyManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        historyList = findViewById(R.id.historyList);
        historyManager = ((MyApp)getApplication()).historyManager;
        adapter = new HistoryAdapter(historyManager.reports,this);
        historyList.setAdapter(adapter);

        //click the report to see more details
        historyList.setOnItemClickListener((adapterView, view, i, l) -> {
            Log.d("DDD","DDD");
            Intent intent = new Intent(getApplication(), Detail.class);
            //passed the report list to History activity
            Log.d("ssss","SSs");
            intent.putExtra("detail",historyManager.reports.get(i));
            Log.d("AAA","AAA");
            startActivity(intent);
        });

    }
}