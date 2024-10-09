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
import java.util.Arrays;

public class Statistics {

    private ArrayList<Integer> arrayOfPoints;
    private final static int maxGrade = 5;
    private final static int minGrade = 0;

    public Statistics() {
        this.arrayOfPoints = new ArrayList<>();
    }

    public boolean validPoints(int points) {
        return points >= 0 && points <= 100;
    }

    public void add(int points) {
        if (!validPoints(points)) {
            return;
        }
        this.arrayOfPoints.add(points);
    }

    public double average() {
        if (this.arrayOfPoints.size() == 0) {
            return -1.0;
        }
        int totalPoints = 0;
        for (int points : this.arrayOfPoints) {
            totalPoints += points;
        }
        return (double) totalPoints / this.arrayOfPoints.size();
    }

    public double passingGradeAverage() {
        if (this.arrayOfPoints.size() == 0) {
            return -1.0;
        }
        int totalPoints = 0;
        int count = 0;
        for (int points : this.arrayOfPoints) {
            if (points >= 50) {
                totalPoints += points;
                count++;
            }
        }
        if (count == 0) {
            return -1.0;
        }
        return (double) totalPoints / count;
    }

    public double passingPorcentage() {
        if (this.arrayOfPoints.size() == 0) {
            return -1.0;
        }
        int count = 0;
        for (int points : this.arrayOfPoints) {
            if (points >= 50) {
                count++;
            }
        }
        return 100.0 * count / this.arrayOfPoints.size();
    }

    public ArrayList<Integer> grades() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int g = maxGrade; g >= minGrade; g--) {
            list.add(g);
        }
        return list;
        // return new ArrayList<Integer>(Arrays.asList(5,4,3,2,1,0));
    }

    private int grade(int points) {
        if (!validPoints(points)) {
            return -1;
        }
        if (points < 50) {
            return 0;
        } else if (points < 60) {
            return 1;
        } else if (points < 70) {
            return 2;
        } else if (points < 80) {
            return 3;
        } else if (points < 90) {
            return 4;
        } else {
            return 5; // x >= 90 && x <= 100
        }
    }

    public int gradeCount(int grade) {
        if (!this.grades().contains(grade)) {
            return -1;
        }
        int count = 0;
        for (int points : this.arrayOfPoints) {
            if (this.grade(points) == grade) {
                count++;
            }
        }
        return count;
    }
}
