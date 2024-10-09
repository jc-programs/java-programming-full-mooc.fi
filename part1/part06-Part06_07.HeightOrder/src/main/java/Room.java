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

public class Room {

    private ArrayList<Person> people;

    public Room() {
        this.people = new ArrayList<>();
    }

    public void add(Person person) {
        this.people.add(person);
    }

    public boolean isEmpty() {
        return this.people.isEmpty();
    }

    public ArrayList<Person> getPersons() {
        ArrayList<Person> clone = (ArrayList<Person>) this.people.clone();
        return clone;
    }

    public Person shortest() {
        if (this.isEmpty()) {
            return null;
        }
        Person shortets = this.people.get(0);
        for (Person p : this.people) {
            if (p.getHeight() < shortets.getHeight()) {
                shortets = p;
            }
        }
        return shortets;
    }

    public Person take() {
        if (this.isEmpty()) {
            return null;
        }
        Person shortest = this.shortest();
        people.remove(shortest);
        return shortest;
    }
}
