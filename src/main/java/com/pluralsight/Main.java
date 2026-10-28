package com.pluralsight;

import java.util.*;
import java.io.*;

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

    private static void mainDisplay() {
        print("""
                What do you want to do?
                1- List all products
                2- Lookup a product by its id
                3- Find all products within a price range
                4- Add a new product
                5- Quit the application""");
        String commandInput = "";

        while (commandInput.isEmpty()) {
            System.out.print("Enter command: ");
            commandInput = scanner.nextLine();
            boolean correctCommand = false;

            for (int i = 1; i <= 5; i++) {
                correctCommand = commandInput.equals(String.valueOf(i));
                if (correctCommand) {break;}
            }
            if (!correctCommand) {
                commandInput="";
                print("Error Invalid command found! Please enter a valid command.");
            }
        }

        switch (commandInput){
            case "1" -> displayInventory();
            case "2" -> {}
            case "3" -> {}
            case "4" -> {}
            default -> print("program has been ended");
        }
        if (!commandInput.equals("5")) {
            System.out.print("""
                    enter R to return to main
                    enter E to end program"""+" ");
            commandInput = "";

            while (commandInput.isEmpty()) {
                System.out.print("Enter command: ");
                commandInput = scanner.nextLine().toLowerCase();
                boolean correctCommand;
                correctCommand = commandInput.equals("r") || commandInput.equals("e");

                if (!correctCommand) {
                    commandInput = "";
                    print("Error Invalid command found! Please enter a valid command.");
                } else if (commandInput.equals("r")) {mainDisplay();}
            }
        }
        scanner.close();
    }

    private static void getInventory() {
        try {
            FileReader fileReader = new FileReader("Inventory.txt");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
            while((input = bufReader.readLine()) != null) {
                System.out.println(input);
                String[] lineSegment=input.split("\\|");
                Product product1 = new Product(lineSegment[1], lineSegment[0], Double.parseDouble(lineSegment[2]),1);
                inventory.add(product1);
            }
            bufReader.close();
        }
        catch(IOException e) {print(e);}
    }

    private static void print(IOException e) {System.out.println(e);}

    private static void print(String text) {System.out.println(text);}
}