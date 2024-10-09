
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        while (true) {
            int number = Integer.valueOf(scanner.nextLine());
            if (number < 0) {
                break;
            }
            numbers.add(number);
        }
        numbers.stream()
                .filter(number -> (number > 0 && number < 6))
                .forEach(number -> System.out.println(number));
    }
}
