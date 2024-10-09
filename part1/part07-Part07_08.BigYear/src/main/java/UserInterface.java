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
import java.util.Scanner;

public class UserInterface {

    private ArrayList<BirdWatcher> birds;
    private Scanner scanner;

    public UserInterface(ArrayList<BirdWatcher> birds, Scanner scan) {
        this.birds = birds;
        this.scanner = scan;
    }

    public void start() {
        while (true) {
            String command = this.ask("? ");
            if (command.equals("Quit")) {
                break;
            }

            if (command.equals("Add")) {
                this.addBird();
            } else if (command.equals("Observation")) {
                this.addObservation();
            } else if (command.equals("All")) {
                this.listAllBirds();
            } else if (command.equals("One")) {
                this.listOneBird();
            }
        }
    }

    private String ask(String question) {
        System.out.print(question);
        return this.scanner.nextLine();
    }

    private void addBird() {
        String name = this.ask("Name: ");
        String latinName = this.ask("Name in Latin: ");
        this.birds.add(new BirdWatcher(name, latinName));
    }

    private void addObservation() {
        int index = this.getIndexOfABird();
        if (index == -1) {
            System.out.println("Not a bird!");
            return;
        }
        this.birds.get(index).addObservation();
    }

    private void listAllBirds() {
        for (BirdWatcher bird : this.birds) {
            System.out.println(bird);
        }
    }

    private void listOneBird() {
        int index = this.getIndexOfABird();
        if (index == -1) {
            System.out.println("Not a bird!");
            return;
        }
        System.out.println(this.birds.get(index));
    }

    private int getIndexOfABird() {
        String name = this.ask("Bird? ");
        for (int i = 0; i < this.birds.size(); i++) {
            if (this.birds.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
