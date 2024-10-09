import java.util.ArrayList;


public class HashMap<KeyType, ValueType> {
    private ArrayList<Pair<KeyType, ValueType>>[] values;
    private int firstFreeIndex;

    public HashMap() {
        this.values = new ArrayList[32];
        this.firstFreeIndex = 0;
    }

    public int size() {
        return this.firstFreeIndex;
    }

    private ArrayList<Pair<KeyType, ValueType>> getListBasedOnKey(KeyType key) {
        int hashValue = Math.abs(key.hashCode() % values.length);
        if (values[hashValue] == null) {
            values[hashValue] = new ArrayList<>();
        }

        return values[hashValue];
    }

    private int getIndexOfKey(ArrayList<Pair<KeyType, ValueType>> myList, KeyType key) {
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getKey().equals(key)) {
                return i;
            }
        }

        return -1;
    }

    private void grow() {
        // create a new array
        ArrayList<Pair<KeyType, ValueType>>[] newArray = new ArrayList[this.values.length * 2];

        for (int i = 0; i < this.values.length; i++) {
            // copy the values of the old array into the new one
            copy(newArray, i);
        }

        // replace the old array with the new
        this.values = newArray;
    }

    private void copy(ArrayList<Pair<KeyType, ValueType>>[] newArray, int fromIdx) {
        for (int i = 0; i < this.values[fromIdx].size(); i++) {
            Pair<KeyType, ValueType> value = this.values[fromIdx].get(i);

            int hashValue = Math.abs(value.getKey().hashCode() % newArray.length);
            if (newArray[hashValue] == null) {
                newArray[hashValue] = new ArrayList<>();
            }

            newArray[hashValue].add(value);
        }
    }

    public void add(KeyType key, ValueType value) {
        ArrayList<Pair<KeyType, ValueType>> valuesAtIndex = getListBasedOnKey(key);
        int index = getIndexOfKey(valuesAtIndex, key);

        if (index < 0) {
            valuesAtIndex.add(new Pair<>(key, value));
            this.firstFreeIndex++;
        } else {
            valuesAtIndex.get(index).setValue(value);
        }

        if (1.0 * this.firstFreeIndex / this.values.length > 0.75) {
            grow();
        }
    }

    private Object[] getPair(KeyType key) {
        ArrayList<Pair<KeyType, ValueType>> valuesAtIndex = getListBasedOnKey(key);
        if (valuesAtIndex.size() == 0) {
            return null;
        }

        int index = getIndexOfKey(valuesAtIndex, key);
        if (index < 0) {
            return null;
        }

        Object[] res = new Object[2];
        res[0] = valuesAtIndex;
        res[1] = valuesAtIndex.get(index);
        return res;
    }

    public ValueType get(KeyType key) {
        Object[] res = this.getPair(key);
        if (res == null) {
            return null;
        }

        Pair<KeyType, ValueType> pair = (Pair<KeyType, ValueType>) res[1];
        return pair.getValue();
    }

    public ValueType remove(KeyType key) {
        Object[] res = this.getPair(key);
        if (res == null) {
            return null;
        }

        ArrayList<Pair<KeyType, ValueType>> valuesAtIndex =
                (ArrayList<Pair<KeyType, ValueType>>) res[0];
        Pair<KeyType, ValueType> pair = (Pair<KeyType, ValueType>) res[1];
        valuesAtIndex.remove(pair);
        return pair.getValue();
        // ArrayList<Pair<KeyType, ValueType>> valuesAtIndex = getListBasedOnKey(key);
        // if (valuesAtIndex.size() == 0) {
        // return null;
        // }

        // int index = getIndexOfKey(valuesAtIndex, key);
        // if (index < 0) {
        // return null;
        // }

        // Pair<KeyType, ValueType> pair = valuesAtIndex.get(index);
        // valuesAtIndex.remove(pair);
        // return pair.getValue();
    }

}
