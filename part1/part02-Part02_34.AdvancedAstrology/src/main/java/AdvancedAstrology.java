
public class AdvancedAstrology {

    public static void printStars(int number) {
        // part 1 of the exercise
        while (number > 0) {
            System.out.print("*");
            number--;
        }
        System.out.println("");
    }

    public static void printSpaces(int number) {
        // part 1 of the exercise
        while (number > 0) {
            System.out.print(" ");
            number--;
        }
    }

    public static void printTriangle(int size) {
        // part 2 of the exercise
        int initialSize = size;
        for (int n = 1; n <= size; n++) {
            printSpaces(size - n);
            printStars(n);
        }
    }

    public static void christmasTree(int height) {
        // part 3 of the exercise
        if (height < 3) {
            return;
        }
        int width = height * 2 - 1;
        for (int h = 0; h < height; h++) {
            printSpaces(height - h - 1);
            printStars(h * 2 + 1);
        }
        printSpaces(height - 2);
        printStars(3);
        printSpaces(height - 2);
        printStars(3);
    }

    public static void main(String[] args) {
        // The tests are not checking the main, so you can modify it freely.

        printTriangle(5);
        System.out.println("---");
        christmasTree(4);
        System.out.println("---");
        christmasTree(10);
    }
}
