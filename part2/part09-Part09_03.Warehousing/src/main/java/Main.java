
public class Main {

    public static void main(String[] args) {
        // here you can write code to test your classes
        ProductWarehouseWithHistory pwh = new ProductWarehouseWithHistory("beer", 10, 2);
        System.out.println("pwh.history()");
 // expected:<[2.0[]]> but was:<[2.0[, 2.0]]>
    }
}

