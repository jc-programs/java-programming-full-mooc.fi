/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jc
 */
public class Container {

    private int capacity;
    final static int maxCapacity = 100;
    
    public Container(){
        this.capacity = 0;
    }

    public int contains() {
        return this.capacity;
    }

    public void add(int amount) {
        // which adds the amount of liquid given as a parameter to the container. 
        // If the amount is negative, no liquid is added. 
        // A container can hold a maximum of 100 units of liquid.
        if (amount > 0) {
            this.capacity += amount;
            if (this.capacity > maxCapacity) {
                this.capacity = maxCapacity;
            }
        }
    }

    public void remove(int amount) {
        // which removes the amount of liquid given as a parameter from the container.
        // If the amount is negative, no liquid is removed.
        // A container can never hold less than 0 units of liquid.
        if (amount > 0) {
            this.capacity -= amount;
            if (this.capacity < 0) {
                this.capacity = 0;
            }
        }
    }

    public String toString() {
        return "" + this.capacity + "/" + maxCapacity;
    }

}
