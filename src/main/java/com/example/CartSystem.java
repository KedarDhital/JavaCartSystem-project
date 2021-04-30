package com.example;

public class CartSystem extends TheSystem {
    CartSystem() {
        super();
    }

   @Override
    public void display() {
        Double subTotal = 0.0;
        Double preTaxTotal = 0.0;
        Double tax = 0.0;
        Double total = 0.0;
    //    System.out.printf("%40s%n", "Cart:");
       System.out.println("Cart:");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-20s%-10s%-10s%-10s%n",
                "Name", "Description", "Price", "Quantity","Sub Total");
        for(Item item: getItemCollection().values()){
           subTotal = item.getItemPrice() * item.getQuantity();
            System.out.printf("%-20s%-20s%-10.2f%-10d%-10.2f%n",item.getItemName(), item.getItemDesc(),item.getItemPrice(),item.getQuantity(),subTotal);
    }
        preTaxTotal +=subTotal;
        tax = subTotal * 0.05;
        total = subTotal + tax;
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%20.2f%n","Pre-tax Total", preTaxTotal);
        System.out.printf("%-20s%20.2f%n", "Tax", tax);
        System.out.printf("%-20s%20.2f%n", "Total", total);
        System.out.println();
} }
