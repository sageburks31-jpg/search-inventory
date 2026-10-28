package com.pluralsight;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        List<Product> inventory = getInventory();
        System.out.println("We carry the following inventory: ");
        for (Product p: inventory) {
            System.out.printf("id: %s name: %s - Price: $%.2f Count: %d%n",
                    p.getId(), p.getName(), p.getPrice(),p.getCount());
        }
    }

    private static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();
        Product product1 = new Product("10' 2x4 (grade B)", "4567", 9.99,1);
        Product product2 = new Product("Box of nails", "2345", 9.29,1);
        Product product3 = new Product("Hammer", "1234", 19.49,1);
        inventory.add(product1);
        inventory.add(product2);
        inventory.add(product3);
        return inventory;
    }
}