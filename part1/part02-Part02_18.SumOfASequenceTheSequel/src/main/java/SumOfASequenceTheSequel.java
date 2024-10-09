
import java.util.Scanner;

public class SumOfASequenceTheSequel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("First number? ");
        int start = Integer.valueOf(scanner.nextLine());
        System.out.print("Last number? ");
        int stop = Integer.valueOf(scanner.nextLine());
        int sum = 0;
        for (int i = start; i <= stop; i++) {
            sum += i;
        }
        System.out.println("The sum is " + sum);
    }
}
