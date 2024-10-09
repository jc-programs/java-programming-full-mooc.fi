
import java.nio.file.Paths;
import java.util.Scanner;

public class RecordsFromAFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of the file:");
        String file = scanner.nextLine();

        try (Scanner scanner2 = new Scanner(Paths.get(file))) {
            while (scanner2.hasNextLine()) {
                String line = scanner2.nextLine();
                String[] pieces = line.split(",");
                String name = pieces[0];
                int years = Integer.valueOf(pieces[1]);
                System.out.print(name + " age: " + years);
                if (years == 1) {
                    System.out.println(" year");
                } else {
                    System.out.println(" years");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
