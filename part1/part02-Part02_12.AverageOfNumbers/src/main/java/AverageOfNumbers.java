
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers = 0;
        int sum = 0;
        while (true) {
            System.out.println("Give a number:");
            int number = Integer.valueOf(scanner.nextLine());
            if (number == 0) {
                break;
            }
            numbers += 1;
            sum += number;
        }
        double average = ((double)sum) / numbers;
        System.out.println("Average of the numbers: " + average);

    }
}
