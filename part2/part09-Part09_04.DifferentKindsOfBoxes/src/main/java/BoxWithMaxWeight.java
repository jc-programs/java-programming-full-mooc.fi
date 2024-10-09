
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jc
 */
public class BoxWithMaxWeight extends Box {

    private int capacity;
    private ArrayList<Item> items;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    private int itemsWeight() {
        int total = 0;
        for (Item item : this.items) {
            total += item.getWeight();
        }
        return total;
    }

    public void add(Item item) {
        if (this.itemsWeight() + item.getWeight() > this.capacity) {
            return;
        }

        this.items.add(item);
    }

    public boolean isInBox(Item item) {
        return this.items.contains(item);
    }
}
