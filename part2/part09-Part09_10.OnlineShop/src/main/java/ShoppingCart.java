
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jc
 */
public class ShoppingCart {

    private Map<String, Item> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void add(String product, int price) {
        // adds an item to the cart that matches the product given as a parameter, 
        // with the price given as a parameter.
        if (this.items.containsKey(product)) {
            Item item = this.items.get(product);
            item.increaseQuantity();
        } else {
            this.items.put(product, new Item(product, 1, price));
        }
    }

    public int price() {
        //  returns the total price of the shopping cart.
        int total = 0;
        for (Item item : this.items.values()) {
            total += item.price();
        }
        return total;
    }

    public void print() {
        for (Item item : this.items.values()) {
            System.out.println(item);
        }
    }

}
