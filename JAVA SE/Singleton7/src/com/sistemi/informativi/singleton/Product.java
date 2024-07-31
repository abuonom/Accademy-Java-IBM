package com.sistemi.informativi.singleton;

public class Product {

    //VAR DI ISTANZA(condivisa solo dall'oggetto istanziato)
    private String name;
    private float price;

    //VAR DI CLASSE (variabile dichiarata static, che viene condivisa da tutte le istanze)
    private static Product product;

    public static Product getProduct(String name, float price) {
        if (product == null){
            product = new Product(name, price);
        }
        return product;
    }

    private Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
