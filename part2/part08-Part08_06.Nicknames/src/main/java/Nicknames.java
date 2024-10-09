
import java.util.HashMap;

public class Nicknames {

    public static void main(String[] args) {
        // Do the operations required here!
        HashMap<String, String> namesNicknames = new HashMap<>();
        namesNicknames.put("matthew", "matt");
        namesNicknames.put("michael", "mix");
        namesNicknames.put("arthur", "artie");
        
        System.out.println(namesNicknames.get("matthew"));
    }

}
