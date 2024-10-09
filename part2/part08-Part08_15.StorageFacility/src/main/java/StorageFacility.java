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
import java.util.HashMap;
import java.util.Map;

public class StorageFacility {

    private HashMap<String, ArrayList<String>> storages;

    public StorageFacility() {
        this.storages = new HashMap<>();

    }

    public void add(String unit, String item) {
        // adds the parameter item to the storage unit that is also given as a parameter.
        this.storages.putIfAbsent(unit, new ArrayList<>());
        this.storages.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit) {
        // returns a list that contains all the items in the storage unit indicated by the parameter.
        // If there is no such storage unit or it contains no items, the method should return an empty list.
        if (!this.storages.containsKey(storageUnit)) {
            return new ArrayList<>();
        }
        return this.storages.get(storageUnit);
    }

    public void remove(String storageUnit, String item) {
        // removes the given item from the given storage unit. 
        // NB! Only removes one item — if there are several items with the same name, the rest still remain.
        // If the storage unit would be empty after the removal, the method also removes the unit.
        if (!this.storages.containsKey(storageUnit)) {
            return;
        }
        ArrayList<String> items = this.storages.get(storageUnit);
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals(item)) {
                items.remove(i);
                break;
            }
        }
        if (items.size() == 0) {
            this.storages.remove(storageUnit);
        }
    }

    public ArrayList<String> storageUnits() {
        // returns the names of the storage units as a list. NB! Only the units that contain items are listed.
        ArrayList<String> unitsWithContents = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : this.storages.entrySet()) {
            if (entry.getValue().size() > 0) {
                unitsWithContents.add(entry.getKey());
            }
        }
        return unitsWithContents;
    }

}
