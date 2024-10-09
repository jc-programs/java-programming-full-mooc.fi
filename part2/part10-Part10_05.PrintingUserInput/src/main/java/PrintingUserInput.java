
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingUserInput {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> strings = new ArrayList<>();
        while (true) {
            String string = scanner.nextLine();
            if (string.equals("")) {
                break;
            }
            strings.add(string);
        }
        strings.stream().forEach(string -> System.out.println(string));
    }
}
