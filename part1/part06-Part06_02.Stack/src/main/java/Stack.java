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

public class Stack {

    private ArrayList<String> stack;

    public Stack() {
        this.stack = new ArrayList<>();
    }

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public void add(String value) {
        this.stack.add(value);
    }

    public String take() {
        if (this.stack.isEmpty()) {
            return null;
        }
        int index = this.stack.size() - 1;
        String value = this.stack.get(index);
        this.stack.remove(index);
        return value;
    }

    public ArrayList<String> values() {
        return (ArrayList<String>) this.stack.clone();
        // ArrayList<String> clone = new ArrayList<String>(this.stack);
        // return clone;
    }

}
