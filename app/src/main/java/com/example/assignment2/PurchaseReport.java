package com.example.assignment2;

import java.io.Serializable;
import java.util.Date;

public class PurchaseReport implements Serializable {
    int quality;
    double amount;
    Date date;
    String name;

    public PurchaseReport(String name,int quality,double amount) {
        this.name=name;
        this.quality = quality;
        this.amount = amount;
        date = new Date();
    }

    public int getQuality() {
        return this.quality;
    }

    public double getAmount() {
        return this.amount;
    }

    public Date getDate() {
        return this.date;
    }

    public String getName() {
        return this.name;
    }

}
