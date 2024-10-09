/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

/**
 *
 * @author jc
 */
public enum Player {
    PLAYER1("X"),
    PLAYER2("O"),
    NOPLAYER(" ");

    private final String name;

    private Player(String name) {
        this.name = name;
    }

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false 
        return name.equals(otherName);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
