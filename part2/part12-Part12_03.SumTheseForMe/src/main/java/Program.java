
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // test your method here


    }

    public static int sum(int[] array, int fromWhere, int toWhere, int smallest, int largest) {
        fromWhere =
                fromWhere < 0 ? 0 : (fromWhere > array.length - 1 ? array.length - 1 : fromWhere);
        toWhere = toWhere < 0 ? 0 : (toWhere > array.length - 1 ? array.length - 1 : toWhere);
        int total = 0;
        for (int i = fromWhere; i <= toWhere; i++) {
            if (array[i] >= smallest && array[i] <= largest) {
                total += array[i];
            }
        }
        return total;
    }
}
