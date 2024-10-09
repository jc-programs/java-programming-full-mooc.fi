/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jc
 */
public class BirdWatcher {

    private String name;
    private String latinName;
    private int observations;

    public BirdWatcher(String name, String latinName) {
        this.name = name;
        this.latinName = latinName;
        this.observations = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getObservations() {
        return this.observations;
    }

    public void addObservation() {
        this.observations++;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.latinName + "): "
                + this.observations + " observation"
                + (this.observations == 1 ? "" : "s");
    }
}
