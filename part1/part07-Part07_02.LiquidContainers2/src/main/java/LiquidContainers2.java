
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container first = new Container();
        Container second = new Container();

        while (true) {
            System.out.println("first: " + first);
            System.out.println("second: " + second);
            System.out.print("> ");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);
            if (command.equals("add")) {
                first.add(amount);
            } else if (command.equals("move")) {
                int firstContains = first.contains();
                if (amount > firstContains) {
                    second.add(firstContains);
                    first.remove(firstContains);
                } else {
                    first.remove(amount);
                    second.add(amount);
                }
            } else if (command.equals("remove")) {
                second.remove(amount);
            }
        }
    }

}
