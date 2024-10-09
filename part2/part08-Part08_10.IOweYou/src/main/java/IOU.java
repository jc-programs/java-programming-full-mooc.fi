/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jc
 */
import java.util.HashMap;

public class IOU {

    private HashMap<String, Double> debts;

    public IOU() {
        this.debts = new HashMap<>();
    }

    public void setSum(String toWhom, double amount) {
        // saves the amount owed and the person owed to to the IOU.
        this.debts.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
        // returns the amount owed to the person whose name is given as a parameter. If the person
        return this.debts.getOrDefault(toWhom, 0.0);
    }

}
