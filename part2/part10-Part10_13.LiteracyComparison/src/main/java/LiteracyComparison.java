
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LiteracyComparison {

    public static void main(String[] args) {
        // Adult literacy rate, population 15+ years, female (%),Zimbabwe,2015,85.28513
        // 0: theme,
        // 1: age group, 
        // 2: gender, 
        // 3: country, 
        // 4: year, 
        // 5: literacy percent.
        List<String> lines = new ArrayList<String>();
        try {
            lines = Files.readAllLines(Paths.get("literacy.csv"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        lines.stream()
                .map(string -> string.split(","))
                .sorted((o1, o2) -> Double.valueOf(o1[5]).compareTo(Double.valueOf(o2[5])))
                .forEach(parts -> {
                    System.out.println(parts[3] + " (" + parts[4] + ")," 
                            + parts[2].replace(" (%)", "") + ", " + parts[5]);
                });
    }
}
