package com.example.assignment2;

import android.app.Application;

public class MyApp extends Application {
    ProductsManager productsManager = new ProductsManager();
    Product selectedProduct = new Product();
    HistoryManager historyManager = new HistoryManager();
}
