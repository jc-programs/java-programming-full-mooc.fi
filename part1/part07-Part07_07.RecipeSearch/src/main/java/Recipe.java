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

public class Recipe {

    private String name;
    private int cookingTime;
    private ArrayList<String> ingredients;

    public Recipe(String name) {
        this(name, 0, new ArrayList<String>());
    }

    public Recipe(String name, int cookingTime) {
        this(name, cookingTime, new ArrayList<String>());
    }

    public Recipe(String name, int cookingTime, ArrayList<String> ingredients) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
    }

    public String getName() {
        return this.name;
    }

    public int getCookingTime() {
        return this.cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public void addIngredient(String ingredient) {
        this.ingredients.add(ingredient);
    }

    public ArrayList<String> getIngredients() {
        return this.ingredients;
    }

    @Override
    public String toString() {
        return this.name + ", cooking time: " + this.cookingTime + ".";
    }

}
