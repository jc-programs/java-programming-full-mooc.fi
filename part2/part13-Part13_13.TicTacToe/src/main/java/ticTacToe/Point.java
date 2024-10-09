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
public class Point implements Comparable<Point> {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }

        Point other = (Point) object;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.x;
        hash = 29 * hash + this.y;
        return hash;
    }

    @Override
    public int compareTo(Point other) {
        int compare = Integer.compare(this.x, other.x);
        if (compare != 0) {
            return compare;
        } else {
            return Integer.compare(this.y, other.y);
        }
    }

}
