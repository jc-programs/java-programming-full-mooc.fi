/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jc
 */
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class UserIterface {

    ArrayList<Recipe> recipes;
    private Scanner scanner;

    public UserIterface(ArrayList<Recipe> recipes, Scanner scan) {
        this.recipes = recipes;
        this.scanner = scan;
    }

    public void start() {
        System.out.print("File to read: ");
        String file = this.scanner.nextLine();
//        String file = "recipes.txt";
//        System.out.println(file);
        System.out.println();
        readRecipesFromFile(file);
        printCommands();
        while (true) {
            System.out.print("Enter command: ");
            String command = this.scanner.nextLine();
            if (command.equals("stop")) {
                break;
            }

            System.out.println();
            if (command.equals("list")) {
                printRecipes(this.recipes);
            }
            if (command.equals("find name")) {
                findRecipesByName();
            }
            if (command.equals("find cooking time")) {
                findRecipesByCookingTIme();
            }
            if (command.equals("find ingredient")) {
                findRecipesByIngredient();
            }
            
            System.out.println();
        }
    }

    private void findRecipesByName() {
        System.out.print("Searched word: ");
        String word = this.scanner.nextLine();
        printRecipes(findRecipesByName(word));
    }

    private ArrayList<Recipe> findRecipesByName(String name) {
        ArrayList<Recipe> list = new ArrayList<>();
        for (Recipe r : this.recipes) {
            if (r.getName().contains(name)) {
                list.add(r);
            }
        }
        return list;
    }

    private void findRecipesByCookingTIme() {
        System.out.print("Max cooking time: ");
        int cookingTime = Integer.valueOf(this.scanner.nextLine());
        printRecipes(findRecipesByCookingTIme(cookingTime));
    }

    private ArrayList<Recipe> findRecipesByCookingTIme(int cookingTime) {
        ArrayList<Recipe> list = new ArrayList<>();
        for (Recipe r : this.recipes) {
            if (r.getCookingTime() <= cookingTime) {
                list.add(r);
            }
        }
        return list;
    }

    private void findRecipesByIngredient() {
        System.out.print("Ingredient: ");
        String ingredient = this.scanner.nextLine();
        printRecipes(findRecipesByIngredient(ingredient));
    }

    private ArrayList<Recipe> findRecipesByIngredient(String ingredient) {
        ArrayList<Recipe> list = new ArrayList<>();
        for (Recipe r : this.recipes) {
            if (r.getIngredients().contains(ingredient)) {
                list.add(r);
            }
        }
        return list;
    }

    private void printRecipes(ArrayList<Recipe> recipes) {
        System.out.println("Recipes:");
        for (Recipe recipe : recipes) {
            System.out.println(recipe);
        }
    }

    private void printCommands() {
        System.out.println("Commands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");
        System.out.println();
    }

    private void readRecipesFromFile(String file) {
        try (Scanner scanner = new Scanner(Paths.get(file))) {
            while (scanner.hasNextLine()) {
                String name = scanner.nextLine();
                int cookingTime = Integer.valueOf(scanner.nextLine());
                Recipe recipe = new Recipe(name, cookingTime);
                this.recipes.add(recipe);
                while (true) {
                    String ingredient = scanner.nextLine();
                    if (ingredient.equals("")) {
                        break;
                    }
                    recipe.addIngredient(ingredient);
                }
            }
        } catch (Exception e) {
            // System.out.println("Error: " + e.getMessage());
        }

    }
}
