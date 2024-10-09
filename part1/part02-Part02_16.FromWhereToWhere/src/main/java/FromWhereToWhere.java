
import java.util.Scanner;

public class FromWhereToWhere {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your program here
        System.out.print("Where to? ");
        int stop = Integer.valueOf(scanner.nextLine());
        System.out.print("Where from? ");
        int start = Integer.valueOf(scanner.nextLine());
        if (start <= stop) {
            for (int n = start; n <= stop; n++) {
                System.out.println(n);
            }
        }
    }
}
