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

public class Abbreviations {

    private HashMap<String, String> hashmap;

    public Abbreviations() {
        this.hashmap = new HashMap<>();
    }

    public void addAbbreviation(String abbreviation, String explanation) {
        // adds a new abbreviation and its explanation.
        this.hashmap.put(abbreviation, explanation);
    }

    public boolean hasAbbreviation(String abbreviation) {
        // checks if an abbreviation has already been added; returns true if it has and false if it has not.
        return this.hashmap.containsKey(abbreviation);
    }

    public String findExplanationFor(String abbreviation) {
        // finds the explanation for an abbreviation; returns null if the abbreviation has not been added yet.
        if (this.hasAbbreviation(abbreviation)) {
            return this.hashmap.get(abbreviation);
        }
        return null;
    }

}
