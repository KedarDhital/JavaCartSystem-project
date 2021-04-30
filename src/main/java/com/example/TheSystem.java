package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public abstract class TheSystem {
    private HashMap<String, Item> itemCollection;

    TheSystem() {
        // Your code here
        this.itemCollection = new HashMap<>();
        BufferedReader reader = null;
        try {
            // create file object
            File itemFile = new File("src/main/resources/sample.txt");
            // create buffered reader object from the file.
            reader = new BufferedReader(new FileReader(itemFile));
            String line = null;
            if (getClass().getSimpleName().equals("AppSystem")) {
                while ((line = reader.readLine()) != null) {
                    String[] itemInfo = line.split("\\s\\s");
                    itemCollection.put(itemInfo[0], new Item(itemInfo[0], itemInfo[1], Double.parseDouble(itemInfo[2]), Integer.parseInt(itemInfo[3])));

                }
            }
        } catch (IOException e) {
            System.out.println("There was an error reading from the file");
            // finally block close the BufferedReader
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {

                }
            }
        }

    }

    public HashMap<String, Item> getItemCollection() {
        // Your code here
        return itemCollection;
    }

    public Boolean checkAvailability(Item item) {
        if (item.getQuantity() >= item.getAvailableQuantity()) {
            System.out.println("System is unable to add" + item.getItemName() + "to the card. " +
                    "System only has " + item.getAvailableQuantity() + "" + item.getItemName() + "s.");

            return false;

        } else {
            return true;
        }
    }

    public Boolean add(Item item) {
        // Your code here
        if (item == null) {
            return false;
        } else if ((itemCollection.containsKey(item.getItemName()) && checkAvailability(item))) {
            item.setQuantity(item.getQuantity() + 1);
            return true;
        } else if (!itemCollection.containsKey(item.getItemName())) {
            itemCollection.put(item.getItemName(), item);
            return true;
        } else {
            return false;
        }
    }

    public Item remove(String itemName) {
        if (itemCollection.containsKey(itemName)) {
            return itemCollection.remove(itemName);
        } else {
            return null;
        }
    }
        public abstract void display ();

    }

