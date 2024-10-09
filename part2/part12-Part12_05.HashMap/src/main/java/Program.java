
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // You can test the class here
        HashMap<String,Integer> myHashMap = new HashMap<>();

        myHashMap.add("uno", 1);
        myHashMap.add("dos", 2);
        myHashMap.add("tres", 3);
        myHashMap.add("cuatro", 4);
        myHashMap.add("cinco", 5);
        myHashMap.add("seis", 6);
        System.out.println("uno: " + myHashMap.get("uno")); 
        System.out.println("dos: " + myHashMap.get("dos")); 
        System.out.println("tres: " + myHashMap.get("tres")); 
        System.out.println("cuatro: " + myHashMap.get("cuatro")); 
        System.out.println("cinco: " + myHashMap.get("cinco")); 
        System.out.println("seis: " + myHashMap.get("seis")); 
        System.out.println("size(): " + myHashMap.size()); 
        myHashMap.remove("uno");
        myHashMap.remove("dos");
        myHashMap.remove("seis");
        System.out.println("size(): " + myHashMap.size()); 
        System.out.println("uno: " + myHashMap.get("uno")); 
        System.out.println("dos: " + myHashMap.get("dos")); 
        System.out.println("tres: " + myHashMap.get("tres")); 
        System.out.println("cuatro: " + myHashMap.get("cuatro")); 
        System.out.println("cinco: " + myHashMap.get("cinco")); 
        System.out.println("seis: " + myHashMap.get("seis")); 

    }

}
