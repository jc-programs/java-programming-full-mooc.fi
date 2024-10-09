
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = 0;
        int second = 0;

        while (true) {
            System.out.println("First: " + first + "/100");
            System.out.println("Second: " + second + "/100");
            System.out.print("> ");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);
            if (amount <=0 ){
                continue;
            }
            if (command.equals("add")){
                first += amount;
                if (first > 100){
                    first = 100;
                }
            }
            else if (command.equals("move")){
                int amountToMove = first < amount ? first : amount;
                first -= amountToMove;
                second += amountToMove;
                if (second > 100){
                    second = 100;
                }
            }
            else if (command.equals("remove")){
                second -= amount;
                if (second < 0){
                    second = 0;
                }
            }
        }
    }

}
