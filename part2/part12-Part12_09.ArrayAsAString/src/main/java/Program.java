
public class Program {

    public static void main(String[] args) {
        // Test your method here
    }

    public static String arrayAsString(int[][] array) {
        StringBuilder res = new StringBuilder();
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                res.append(array[row][column]);
            }
            res.append("\n");
        }
        return res.toString();
    }
}
