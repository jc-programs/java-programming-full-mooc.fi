public class Hideout<T> {

    private T value;

    public Hideout(){
        this.value = null;
    }


    public void putIntoHideout(T toHide){
        // puts an object with a type in accordance with the type parameter given 
        // to the the class into the hideout. In case an object is already in the hideout, it will disappear.
        this.value = toHide;
    }

    public T takeFromHideout(){
        // takes out the object with a type in accordance with the type parameter given to the the class 
        // from the hideout. In case there is nothing in the hideout, we return null. 
        // Calling the method returns the object in the hideout and removes the object from the hideout.
        T value = this.value;
        this.value = null;
        return value;
    }

    public boolean isInHideout(){
        // returns the value true if there is an object in the hideout. In case there isn't an object
        // in the hideout, it should return the value false.
        return this.value != null;
    }

}
