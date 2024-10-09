
import java.util.Scanner;

public class IsItTrue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give a string: ");
        String in = scanner.nextLine();
        if (in.equals("true")) {
            System.out.println("You got it right!");
        } else {
            System.out.println("Try again!");
        }
    }
}
