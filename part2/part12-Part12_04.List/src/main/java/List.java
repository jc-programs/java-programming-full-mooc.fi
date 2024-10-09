public class List<Type> {
    private Type[] values;
    private int firstFreeIndex;

    public List() {
        this.values = (Type[]) new Object[10];
        this.firstFreeIndex = 0;
    }

    public void add(Type value) {
        if (this.firstFreeIndex == this.values.length) {
            this.grow();
        }

        this.values[this.firstFreeIndex] = value;
        this.firstFreeIndex++;
    }

    private void grow() {
        int newSize = this.values.length + this.values.length / 2;
        Type[] newValues = (Type[]) new Object[newSize];
        for (int i = 0; i < this.firstFreeIndex; i++) {
            newValues[i] = this.values[i];
        }

        this.values = newValues;
    }

    public int indexOfValue(Type value) {
        for (int i = 0; i < this.firstFreeIndex; i++) {
            if (this.values[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }

    public boolean contains(Type value) {
        return this.indexOfValue(value) >= 0;
    }

    private void moveToTheLeft(int fromIndex) {
        for (int i = fromIndex; i < this.firstFreeIndex - 1; i++) {
            this.values[i] = this.values[i + 1];
        }
    }

    public void remove(Type value) {
        int indexOfValue = indexOfValue(value);
        if (indexOfValue < 0) {
            return; // not found
        }

        moveToTheLeft(indexOfValue);
        this.firstFreeIndex--;
    }

    public Type value(int index) {
        if (index < 0 || index >= this.firstFreeIndex) {
            throw new ArrayIndexOutOfBoundsException(
                    "Index " + index + " outside of [0, " + (this.firstFreeIndex - 1) + "]");
        }

        return this.values[index];
    }

    public int size() {
        return this.firstFreeIndex;
    }
}
