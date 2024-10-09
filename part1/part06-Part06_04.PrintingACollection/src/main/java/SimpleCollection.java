
import java.util.ArrayList;

public class SimpleCollection {

    private String name;
    private ArrayList<String> elements;

    public SimpleCollection(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public void add(String element) {
        this.elements.add(element);
    }

    public ArrayList<String> getElements() {
        return this.elements;
    }
    
    public String toString(){
        if (this.elements.isEmpty()){
            return "The collection " + this.name + " is empty.";
        }
        
        int size = this.elements.size();
        String output = "The collection "+ this.name + " has " + size;
        if (size == 1){
            output += " element:";
        }else{
            output += " elements:";
        }
        for(String element:this.elements){
            output += "\n" + element;
        }
        return output;
    }
}
