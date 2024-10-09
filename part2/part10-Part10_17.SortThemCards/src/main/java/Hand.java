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
import java.util.Collections;

public class Hand implements Comparable<Hand> {
    
    private ArrayList<Card> cards;
    
    public Hand() {
        this.cards = new ArrayList<>();
    }
    
    public void add(Card card) {
        this.cards.add(card);
    }
    
    public void print() {
        for (Card c : this.cards) {
            System.out.println(c);
        }
    }
    
    public void sort() {
        Collections.sort(this.cards);
    }
    
    @Override
    public int compareTo(Hand other) {
        int thisHand = this.cards.stream()
                .mapToInt(card -> card.getValue())
                .sum();
        int otherHand = other.cards.stream()
                .mapToInt(card -> card.getValue())
                .sum();
        return thisHand - otherHand;
    }
    
    public void sortBySuit() {
        Collections.sort(this.cards, new BySuitInValueOrder());
    }
}
