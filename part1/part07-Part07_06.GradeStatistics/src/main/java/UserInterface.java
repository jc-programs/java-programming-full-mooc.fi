/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jc
 */
import java.util.Scanner;

public class UserInterface {

    private Statistics statistics;
    private Scanner scanner;

    public UserInterface(Statistics stats, Scanner scan) {
        this.statistics = stats;
        this.scanner = scan;
    }

    public void start() {
        System.out.println("Enter point totals, -1 stops:");
        while (true) {
            int points = Integer.valueOf(this.scanner.nextLine());
            if (points == -1) {
                printStats();
                break;
            }

            if (this.statistics.validPoints(points)) {
                this.statistics.add(points);
            }
        }
    }

    private void printStats() {
        System.out.println("Point average (all): " + this.statistics.average());
        System.out.println("Point average (passing): " + this.statistics.passingGradeAverage());
        double p = this.statistics.passingPorcentage();
        System.out.println("Pass percentage: " + (p == -1.0 ? '-' : p));
        System.out.println("Grade distribution:");
        for (int grade : this.statistics.grades()) {
            System.out.println(grade + ": " + getStars(this.statistics.gradeCount(grade)));

        }
    }

    private String getStars(int n) {
        String res = "";
        for (int i = 0; i < n; i++) {
            res += "*";
        }
        return res;
    }
}
