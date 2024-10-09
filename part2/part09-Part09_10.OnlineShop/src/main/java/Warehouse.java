
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jc
 */
public class Warehouse {

    private Map<String, Integer> prices;
    private Map<String, Integer> stock;

    public Warehouse() {
        this.prices = new HashMap<>();
        this.stock = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        // which adds a product to the warehouse with the price and stock balance given as parameters.
        this.prices.put(product, price);
        this.stock.put(product, stock);
    }

    public int price(String product) {
        // which returns the price of the product it received as a parameter. 
        // If the product hasn't been added to the warehouse, the method must return -99
        if (!this.prices.containsKey(product)) {
            return -99;
        }

        return this.prices.get(product);
    }

    public int stock(String product) {
        // returns the current remaining stock of the product in the warehouse. 
        // If the product hasn't been added to the warehouse, the method must return 0.
        if (!this.stock.containsKey(product)) {
            return 0;
        }

        return this.stock.get(product);
    }

    public boolean take(String product) {
        // reduces the stock remaining for the product it received as a parameter by one, 
        // and returns true if there was stock remaining. 
        // If the product was not available in the warehouse the method returns false. 
        // A products stock can't go below zero.
        if (!this.stock.containsKey(product)) {
            return false;
        }

        int currentStock = this.stock.get(product);
        if (currentStock == 0) {
            return false;
        }

        this.stock.put(product, currentStock - 1);
        return true;
    }

    public Set<String> products() {
        // returns the names of the products in the warehouse as a Set
        return this.stock.keySet();
    }

}
