package com.example.assignment2;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    double price;
    String name;
    int quantityInStock;


    public Product(double price, String name, int quantity) {
        this.price = price;
        this.name = name;
        this.quantityInStock = quantity;
    }

    public Product() {
        this.name = "";
    }


    protected Product(Parcel in) {
        price = in.readDouble();
        name = in.readString();
        quantityInStock = in.readInt();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(price);
        parcel.writeString(name);
        parcel.writeInt(quantityInStock);
    }

    //getter and setter for this.quantityInStock
    public int getQuantityInStock() {
        return this.quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
