
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
public class ChangeHistory {

    private ArrayList<Double> history;

    public ChangeHistory() {
        // creates an empty ChangeHistory object.
        this.history = new ArrayList<>();
    }

    public void add(double status) {
        // adds provided status as the latest amount to remember in the change history.
        this.history.add(status);
    }

    public void clear() {
        // empties the history.
        this.history.clear();
    }

    public String toString() {
        // returns the string representation of the change history.
        // The string representation provided by the ArrayList class is sufficient.
        return this.history.toString();
    }

    public double maxValue() {
        // returns the largest value in the change history. If the history is empty, the method should return zero.
        if (this.history.size() == 0) {
            return 0.0;
        }
        double max = this.history.get(0);
        for (double status : this.history) {
            if (status > max) {
                max = status;
            }
        }
        return max;
    }

    public double minValue() {
        // returns the smallest value in the change history. If the history is empty, the method should return zero.
        if (this.history.size() == 0) {
            return 0.0;
        }
        double min = this.history.get(0);
        for (double status : this.history) {
            if (status < min) {
                min = status;
            }
        }
        return min;
    }

    public double average() {
        // returns the average of the values in the change history. If the history is empty, the method should return zero.
        if (this.history.size() == 0) {
            return 0.0;
        }
        double total = 0.0;
        for (double status : this.history) {
            total += status;
        }
        return total / this.history.size();
    }

}
