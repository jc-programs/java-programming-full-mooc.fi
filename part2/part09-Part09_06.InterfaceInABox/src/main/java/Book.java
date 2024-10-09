/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jc
 */
public class Book implements Packable {

    private String author;
    private String title;
    private double weight;

    public Book(String author, String title, double weight) {
        this.author = author;
        this.title = title;
        this.weight = weight;

    }

    public double weight() {
        return weight;
    }

    @Override
    public String toString() {
        return this.author + ": " + this.title;
    }
}
