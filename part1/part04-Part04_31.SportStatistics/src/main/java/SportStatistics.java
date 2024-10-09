
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Match> matches = new ArrayList<>();
        System.out.println("File:");
        String file = scan.nextLine();
        try (Scanner scanner = new Scanner(Paths.get(file))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] pieces = line.split(",");
                String homeTeam = pieces[0];
                String visitingTeam = pieces[1];
                int homePoints = Integer.valueOf(pieces[2]);
                int visitingPoints = Integer.valueOf(pieces[3]);
                matches.add(new Match(homeTeam,visitingTeam,homePoints,visitingPoints));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Team:");
        String team = scan.nextLine();
        int count = 0;
        int wins = 0;
        int losses = 0;
        for(Match m:matches){
            if (m.hasTeam(team)){
                count++;
                if (m.wins(team)){
                    wins++;
                }else{
                    losses++;
                }
            }
        }
        System.out.println("Games: " + count);
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        
        

    }

}
