/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jc
 */
import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card> {

    public int compare(Card c1, Card c2) {
        int comparison = c1.getSuit().ordinal() - c2.getSuit().ordinal();
        return comparison == 0 ? c1.getValue() - c2.getValue() : comparison;
    }
}
