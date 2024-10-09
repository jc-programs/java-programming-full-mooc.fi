
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = 0;
        int count = 0;
        int sum = 0;
        String name = "";
        while (true) {
            String text = scanner.nextLine();
            if (text.equals("")) {
                break;
            }

            String[] pieces = text.split(",");
            int year = Integer.valueOf(pieces[1]);
            sum += year;
            count++;
            if (max < pieces[0].length()) {
                max = pieces[0].length();
                name = pieces[0];
            }
        }
        System.out.println("Longest name: " + name);
        System.out.println("Average of the birth years: " + ((double) sum / count));
    }
}
