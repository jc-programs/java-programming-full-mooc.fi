
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jc
 */
public class VehicleRegistry {

    private HashMap<LicensePlate, String> carOwners;

    public VehicleRegistry() {
        this.carOwners = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String owner) {
        // assigns the owner it received as a parameter to a car that corresponds
        // to the license plate received as a parameter. 
        // If the license plate doesn't have an owner, the method returns true.
        // If the license already has an owner attached, the method returns false and does nothing.
        if (this.carOwners.containsKey(licensePlate)) {
            return false;
        }
        this.carOwners.put(licensePlate, owner);
        return true;
    }

    public String get(LicensePlate licensePlate) {
        // returns the owner of the car corresponding to the license plate received as a parameter.
        // If the car isn't in the registry, the method returns null.
        if (!this.carOwners.containsKey(licensePlate)) {
            return null;
        }
        return this.carOwners.get(licensePlate);
    }

    public boolean remove(LicensePlate licensePlate) {
        // removes the license plate and attached data from the registry.
        // The method returns true if removed successfully and false if the license plate wasn't in the registry.
        if (!this.carOwners.containsKey(licensePlate)) {
            return false;
        }

        this.carOwners.remove(licensePlate);
        return true;
    }

    public void printLicensePlates() {
        // prints the license plates in the registry.
        for (LicensePlate licensePlate : this.carOwners.keySet()) {
            System.out.println(licensePlate);
        }
    }

    public void printOwners() {
        // prints the owners of the cars in the registry. 
        // Each name should only be printed once, even if a particular person owns more than one car.
        ArrayList<String> ownersPrinted = new ArrayList<>();
        for (String owner : this.carOwners.values()) {
            if (!ownersPrinted.contains(owner)) {
                System.out.println(owner);
                ownersPrinted.add(owner);
            }
        }
    }

}
