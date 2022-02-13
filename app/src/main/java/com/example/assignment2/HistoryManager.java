package com.example.assignment2;
import java.util.ArrayList;

public class HistoryManager{

    ArrayList<PurchaseReport> reports;

    public HistoryManager() {
        reports = new ArrayList<>();
    }

    public void addRecord(PurchaseReport p ){
        reports.add(p);
    }
}
