/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jc
 */
public class ProductWarehouseWithHistory extends ProductWarehouse {

    private ChangeHistory changeHistory;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        this.changeHistory = new ChangeHistory();
        this.addToWarehouse(initialBalance);
        // this.changeHistory.add(this.getBalance());
    }

    public String history() {
        return this.changeHistory.toString();
    }

    public void addToWarehouse(double amount) {
        // works just like the method in the Warehouse class, 
        // but we also record the changed state to the history. 
        // NB: the value recorded in the history should be the warehouse's balance after adding, 
        // not the amount added!
        super.addToWarehouse(amount);
        this.changeHistory.add(this.getBalance());
    }

    public double takeFromWarehouse(double amount) {
        // works just like the method in the Warehouse class, 
        // but we also record the changed state to the history. 
        // NB: the value recorded in the history should be the warehouse's balance after removing, 
        // not the amount removed!
        double remaining = super.takeFromWarehouse(amount);
        this.changeHistory.add(this.getBalance());
        return remaining;
    }

    public void printAnalysis() {
        // which prints history related information for the product in the way presented in the example.
        System.out.println("Product: " + this.getName());
        System.out.println("History: " + this.changeHistory);
        System.out.println("Largest amount of product: " + this.changeHistory.maxValue());
        System.out.println("Smallest amount of product: " + this.changeHistory.minValue());
        System.out.println("Average: " + this.changeHistory.average());
    }
}
