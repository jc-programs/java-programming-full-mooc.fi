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
import java.util.Iterator;
import java.util.List;

public class Employees {

    private List<Person> employees;

    public Employees() {
        this.employees = new ArrayList<>();
    }

    public void add(Person personToAdd) {
        // adds the given person to the employees list
        this.employees.add(personToAdd);
    }

    public void add(List<Person> peopleToAdd) {
        // adds the given list of people to the employees list
        this.employees.addAll(peopleToAdd);
    }

    public void print() {
        // prints all employees
        Iterator<Person> i = this.employees.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    public void print(Education education) {
        // prints the employees whose education matches the education given as a parameter.
        Iterator<Person> i = this.employees.iterator();
        while (i.hasNext()) {
            Person p = i.next();
            if (p.getEducation() == education) {
                System.out.println(p);
            }
        }
    }
    
    public void fire(Education education){
        Iterator<Person> i = this.employees.iterator();
        while (i.hasNext()) {
            Person p = i.next();
            if (p.getEducation() == education) {
                i.remove();
            }
        }
    }

}
