
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers = 0;
        int sum = 0;
        while (true) {
            int number = Integer.valueOf(scanner.nextLine());
            if (number == 0) {
                break;
            }
            if (number > 0) {
                numbers += 1;
                sum += number;
            }
        }
        if (numbers > 0) {
            double average = ((double) sum) / numbers;
            System.out.println(average);
        } else {
            System.out.println("Cannot calculate the average");
        }

    }
}
