/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jc
 */
public class Item {

    private String product;
    private int qty;
    private int unitPrice;

    public Item(String product, int qty, int unitPrice) {
        // a constructor that creates an item corresponding to the product given as a parameter. 
        // qty tells us how many of the product are in the item, 
        // while unitPrice is the price of a single product.
        this.product = product;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public int price() {
        // return the price of the item. You get the items price by multiplying 
        // its unit price by its quantity(qty).
        return this.qty * this.unitPrice;
    }

    public void increaseQuantity() {
        // increases the quantity by one.
        this.qty++;
    }

    public String toString() {
        // returns the string representation of the item. which must match the format shown in the example below.
        return this.product + ": " + this.qty;
    }

}
