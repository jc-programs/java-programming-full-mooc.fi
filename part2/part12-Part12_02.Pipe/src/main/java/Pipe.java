import java.util.LinkedList;
import java.util.Queue;

public class Pipe<T> {
    private LinkedList<T> values;

    public Pipe(){
        this.values = new LinkedList<T>();
    }

    public void putIntoPipe(T value){
        // puts an object with a type in accordance with the type parameter given to the the class into the pipe.
        this.values.add(value);
    }

    public T takeFromPipe(){
        // takes out the value, which has been in the pipe the longest.
        // In case there is nothing in the pipe, return null. Calling the method returns the value,
        // which has been in the pipe the longest, and removes it from the pipe.
        return this.values.poll();
    }

    public boolean isInPipe(){
        // returns the value true if the pipe has values. In case the pipe is empty, it returns the value false.
        return !this.values.isEmpty();
    }

}
