
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne
        System.out.println("Input numbers, type \"end\" to stop.");
        ArrayList<String> numbers = new ArrayList<>();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            numbers.add(input);
        }
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String input = scanner.nextLine();
        double average;
        if (input.equals("n")) {
            average = numbers.stream()
                    .mapToInt(number -> Integer.valueOf(number))
                    .filter(number -> number < 0)
                    .average()
                    .getAsDouble();
        } else {
            average = numbers.stream()
                    .mapToInt(number -> Integer.valueOf(number))
                    .filter(number -> number > 0)
                    .average()
                    .getAsDouble();
        }
        System.out.println("Average of the positive numbers: " + average);

    }
}
