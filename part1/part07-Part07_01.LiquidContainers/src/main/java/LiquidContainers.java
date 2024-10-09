
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        int first = 0;
        int second = 0;
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("first: " + first + "/" + 100);
            System.out.println("second: " + second + "/" + 100);

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);
            if (amount < 0) {
                ;
            } else if (command.equals("add")) {
                first += amount;
                if (first > 100) {
                    first = 100;
                }

            } else if (command.equals("move")) {
                if (amount > first) {
                    second += first;
                    first = 0;
                } else {
                    first -= amount;
                    second += amount;
                    if (second > 100) {
                        second = 100;
                    }
                }
            } else if (command.equals("remove")) {
                if (amount > second) {
                    second = 0;
                } else {
                    second -= amount;
                }
            }
        }
    }

}
