/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jc
 */
public class ProductWarehouse extends Warehouse {

    private String name;

    public ProductWarehouse(String productName, double capacity) {
        super(capacity);
        this.name = productName;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    
    @Override
    public String toString(){
            //- Returns the state of the object represented as a string like this Juice: balance = 64.5, space left 123.5
        return this.name + ": " + super.toString();
    }
            

}
