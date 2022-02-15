package com.example.assignment2;

import java.util.ArrayList;
import java.util.ListIterator;

public class ProductsManager {

    ArrayList <Product>products;

    public ProductsManager() {
        products = new ArrayList<>();
        Product p1 = new Product(20.44,"Pante",10);
        Product p2 = new Product(10.44,"Shoes",100);
        Product p3 = new Product(5.9,"Hats",30);
        products.add(p1);
        products.add(p2);
        products.add(p3);
    }

    public void setQty(Product buy ,int num) {
        ListIterator<Product> it = products.listIterator();
        while (it.hasNext()){
            String name = it.next().getName();
            if(name.equals(buy.getName())){
                it.previous();
                it.next().setQuantityInStock(buy.getQuantityInStock()-num);
            }
        }
    }

    public void addQty(Product add ,int num) {
        ListIterator<Product> it = products.listIterator();
        while (it.hasNext()){
            String name = it.next().getName();
            if(name.equals(add.getName())){
                it.previous();
                it.next().setQuantityInStock(add.getQuantityInStock()+num);
            }
        }
    }
}
