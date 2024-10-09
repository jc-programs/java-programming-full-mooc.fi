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

public class Hold {

    private ArrayList<Suitcase> suitcases;
    private int maximumWeight;

    public Hold(int maximumWeight) {
        this.maximumWeight = maximumWeight;
        this.suitcases = new ArrayList<>();
    }

    public void addSuitcase(Suitcase suitcase) {
        if (this.totalWeigth() + suitcase.totalWeight() <= this.maximumWeight) {
            this.suitcases.add(suitcase);
        }
    }

    private int totalWeigth() {
        int weight = 0;
        for (Suitcase suitcase : this.suitcases) {
            weight += suitcase.totalWeight();
        }
        return weight;
    }

    public String toString() {
        if (this.suitcases.isEmpty()) {
            return "no suitcases (0 kg)";
        }
        int count = this.suitcases.size();
        int weight = this.totalWeigth();
        String plural = "";
        if (count > 1) {
            plural = "s";
        }
        return count + " suitcase" + plural + " (" + weight + " kg)";
    }
    
    public void printItems() {
        for (Suitcase suitcase : this.suitcases) {
            suitcase.printItems();
        }        
    }
}
