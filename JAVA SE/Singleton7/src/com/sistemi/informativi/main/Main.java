package com.sistemi.informativi.main;

import com.sistemi.informativi.singleton.Product;

public class Main {
    public static void main(String[] args) {
        Product product = Product.getProduct("Prodotto x", 35);
        Product product2 = Product.getProduct("Prodotto y", 45);
        System.out.println(product);
        System.out.println(product2);
    }
}
