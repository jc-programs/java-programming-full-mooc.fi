
import java.util.Arrays;

public class MainProgram {

    public static void main(String[] args) {
        // write your test code here
        // int[] array = {3, 1, 5, 99, 3, 12};
        int[] array = {-1, 3, 1, 2};
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static int smallest(int[] array) {
        // write your code here
        int smallest = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }
        return smallest;
    }

    public static int indexOfSmallest(int[] array) {
        // write your code here
        int indexSmallest = 0;
        int smallest = array[indexSmallest];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallest) {
                indexSmallest = i;
                smallest = array[i];
            }
        }
        return indexSmallest;
    }

    public static int indexOfSmallestFrom(int[] array, int startIndex) {
        // write your code here
        int indexSmallest = startIndex;
        int smallest = array[indexSmallest];
        for (int i = startIndex; i < array.length; i++) {
            if (array[i] < smallest) {
                indexSmallest = i;
                smallest = array[i];
            }
        }
        return indexSmallest;
    }

    public static void swap(int[] array, int index1, int index2) {
        // write your code here
        if (index1 == index2) {
            return;
        }
        
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public static void sort(int[] array) {
        int index = 0;
        while (index < array.length) {
            int indexSmallest = indexOfSmallestFrom(array, index);
            swap(array, index, indexSmallest);
            index++;
        }
    }
}
