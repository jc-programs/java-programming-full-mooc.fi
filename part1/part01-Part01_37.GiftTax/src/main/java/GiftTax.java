
import java.util.Scanner;

public class GiftTax {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Value of the gift?");
        int value = Integer.valueOf(scan.nextLine());
        if (value < 5000) {
            System.out.println("No tax!");
        } else {
            double tax;
            int lowerLimit, lowerValue;
            if (value < 25000) {
                lowerLimit = 100;
                lowerValue = 5000;
                tax = 0.08;
            } else if (value < 55000) {
                lowerLimit = 1700;
                lowerValue = 25000;
                tax = 0.10;
            } else if (value < 200000) {
                lowerLimit = 4700;
                lowerValue = 55000;
                tax = 0.12;
            } else if (value < 1000000) {
                lowerLimit = 22100;
                lowerValue = 200000;
                tax = 0.15;
            } else {
                lowerLimit = 142100;
                lowerValue = 1000000;
                tax = 0.17;
            }
            double total = lowerLimit + (value - lowerValue) * tax;
            System.out.println("Tax: " + total);
        }
    }
}
