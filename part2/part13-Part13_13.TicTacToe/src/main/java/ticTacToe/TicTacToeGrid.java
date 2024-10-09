/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author jc
 */
public class TicTacToeGrid {

    private final int size = 3;
    private HashMap<Point, Player> grid;

    public TicTacToeGrid() {
        this.grid = new HashMap<>();
        for (Point p : this.getGridPoints()) {
            this.grid.put(p, Player.NOPLAYER);
        }
    }

    final public int getSize() {
        return this.size;
    }

    public Player getPlayer(Point point) {
        this.checkPoint(point);
        return this.grid.get(point);
    }

    public boolean isFull() {
        for (Point point : this.getGridPoints()) {
            if (this.grid.get(point).equals(Player.NOPLAYER)) {
                return false;
            }
        }

        return true;
    }

    private void checkPoint(Point point) {
        int x = point.getX();
        int y = point.getY();
        if (x < 0 || x >= this.size || y < 0 || y >= this.size) {
            String message = "Illegal coordinates. (x,y)=(" + point.getX() + "," + point.getY();
            message += ") values must be between 0 and " + (this.size - 1);
            throw new IllegalArgumentException(message);
        }
    }

    private void checkPlayer(Player player) {
        if (player.equals(Player.PLAYER1) || player.equals(player.PLAYER2)) {
            return;
        }

        String message = "Illegal player. Player=" + player;
        message += " and must be " + Player.PLAYER1 + " or " + Player.PLAYER2;
        throw new IllegalArgumentException(message);
    }

    public boolean isPlayable(Point point) {
        checkPoint(point);
        return this.grid.get(point).equals(Player.NOPLAYER);
    }

    public void setPlayer(Point point, Player player) {
        checkPoint(point);
        checkPlayer(player);
        if (!this.isPlayable(point)) {
            return;
        }

        this.grid.put(point, player);
    }

    public Player getWinner(Point point, Player player) {
        if (this.getWinner(point, player, this.getRowPoints(point.getY())).equals(player)) {
            return player;
        }
        if (this.getWinner(point, player, this.getColumnPoints(point.getX())).equals(player)) {
            return player;
        }
        if (this.getWinner(point, player, this.getDiagonalPoints(true)).equals(player)) {
            return player;
        }
        if (this.getWinner(point, player, this.getDiagonalPoints(false)).equals(player)) {
            return player;
        }
        return Player.NOPLAYER;
    }

    private Player getWinner(Point originPoint, Player player, List<Point> points) {
        if (!points.contains(originPoint)) {
            return Player.NOPLAYER;
        }

        for (Point point : points) {
            if (!this.grid.get(point).equals(player)) {
                return Player.NOPLAYER;
            }
        }

        return player;
    }

    private List<Point>  getRowPoints(int y) {
        ArrayList<Point> points = new ArrayList<>();
        for (int x = 0; x < this.size; x++) {
            points.add(new Point(x, y));
        }
        return points;
    }

    private List<Point> getColumnPoints(int x) {
        ArrayList<Point> points = new ArrayList<>();
        for (int y = 0; y < this.size; y++) {
            points.add(new Point(x, y));
        }
        return points;
    }

    private List<Point> getDiagonalPoints(boolean diagonal1) {
        ArrayList<Point> points = new ArrayList<>();
        for (int d = 0; d < this.size; d++) {
            points.add(new Point(d, diagonal1 ? d : this.size - 1 - d));
        }
        return points;
    }

    public List<Point> getGridPoints() {
        ArrayList<Point> points = new ArrayList<>();

        for (int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                points.add(new Point(x, y));
            }
        }
        return points;
    }
}
