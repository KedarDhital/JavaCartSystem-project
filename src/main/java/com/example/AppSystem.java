package com.example;

public class AppSystem extends TheSystem {
    AppSystem() {
    }

    @Override
    public void display() {
        // Your code here
       System.out.printf("AppSystem Inventory:%n");
        System.out.printf("%-20s"+ //  itemName, displayed as a left justified string within a 20 ch field
                          "%-20s"+ // name
                          "%-10s"+ //price
                          "%10s%n", // available quantity
                "Name",
                "Description",
                "Price",
                "Available Quantity");
        System.out.println("------------------------------------------------------------------------");

      for(Item item: getItemCollection().values()){
            System.out.printf("%-20s"+
                    "%-20s"+
                    "%-10.2f"+ // price
                    "%10d%n",item.getItemName(), item.getItemDesc(),item.getItemPrice(),item.getAvailableQuantity());
          System.out.println("");

        }
    }

    @Override      // this overwrites the parents class add method
    public Boolean add(Item item) {
        // Your code here
        if (item == null) {
            return false;
        } else if (getItemCollection().containsKey(item.getItemName())) {
            System.out.println(item.getItemName() + "is already in the App System");
            return false;
        } else if (!getItemCollection().containsKey(item.getItemName())) {
            getItemCollection().put(item.getItemName(), item);
            return true;
        } else {
            return false;
        }
    }
    public Item reduceAvailableQuantity(String item_name) {
        if (getItemCollection().containsKey(item_name)) {
            Item newItem = getItemCollection().get(item_name);
            newItem.setAvailableQuantity(newItem.getAvailableQuantity() - 1);
                if(newItem.getAvailableQuantity() ==0){
                    getItemCollection().remove(item_name);
                }
            return newItem;
        } else if (!getItemCollection().containsKey(item_name)) {
            return null;

        } else
        return null;
    }
}
