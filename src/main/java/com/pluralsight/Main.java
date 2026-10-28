package com.pluralsight;

import java.util.*;

public class Main {

    static ArrayList<Product> inventory = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        getInventory();
        mainDisplay();
    }

    private static void displayInventory() {
        print("We carry the following inventory: ");
        for (Product p: inventory) {
            print(String.format("id: %s name: %s - Price: $%.2f Count: %d",
                    p.getId(), p.getName(), p.getPrice(),p.getCount()));
        }
    }

    private static void mainDisplay(){
        print("""
                What do you want to do?
                1- List all products
                2- Lookup a product by its id
                3- Find all products within a price range
                4- Add a new product
                5- Quit the application""");
        System.out.print("Enter command: ");
        String commandInput = "";

        while (commandInput.isEmpty()) {
            commandInput = scanner.nextLine();
            boolean correctCommand=false;

            for (int i = 1; i < 6; i++) {
                correctCommand=commandInput.equals(String.valueOf(i));
                if (correctCommand) {break;}
            }
            if (!correctCommand) {
                commandInput="";
                print("Error Invalid command found! Please enter a valid command.");
                System.out.print("Enter command: ");
            }
        }

        switch (commandInput){
            case "1" -> displayInventory();
            case "2" -> {}
            case "3" -> {}
            case "4" -> {}
            default -> print("program has been ended");
        }

        if (!commandInput.equals("5")) {mainDisplay();}
    }

    private static void getInventory() {
        Product product1 = new Product("10' 2x4 (grade B)", "4567", 9.99,1);
        Product product2 = new Product("Box of nails", "2345", 9.29,1);
        Product product3 = new Product("Hammer", "1234", 19.49,1);
        Product product4 = new Product("Phone", "2468", 29.99,1);
        Product product5 = new Product("Bread", "0181", 11.99,1);
        inventory.add(product1);
        inventory.add(product2);
        inventory.add(product3);
        inventory.add(product4);
        inventory.add(product5);
    }

    private static void print(String text) {System.out.println(text);}
}