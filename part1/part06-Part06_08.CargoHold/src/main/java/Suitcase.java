/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jc
 */
import java.util.ArrayList;

public class Suitcase {

    private int maximumWeight;
    private ArrayList<Item> items;

    public Suitcase(int maximumWeight) {
        this.maximumWeight = maximumWeight;
        this.items = new ArrayList<>();
    }

    public int totalWeight() {
        int weight = 0;
        for (Item item : this.items) {
            weight += item.getWeight();
        }
        return weight;
    }

    public void addItem(Item item) {
        if (item.getWeight() + this.totalWeight() <= this.maximumWeight) {
            this.items.add(item);
        }
    }

    public String toString() {
        if (this.items.isEmpty()) {
            return "no items (0 kg)";
        }
        int count = 0;
        int weight = 0;
        for (Item item : this.items) {
            count++;
            weight += item.getWeight();
        }
        String plural = "";
        if (count > 1) {
            plural = "s";
        }
        return count + " item" + plural + " (" + weight + " kg)";
    }

    public void printItems() {
        for (Item item : this.items) {
            System.out.println(item);
        }
    }

    public Item heaviestItem() {
        if (this.items.isEmpty()) {
            return null;
        }
        Item heaviest = this.items.get(0);
        for (Item item : this.items) {
            if (item.getWeight() > heaviest.getWeight()) {
                heaviest = item;
            }
        }
        return heaviest;

    }
}
