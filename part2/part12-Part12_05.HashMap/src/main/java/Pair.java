public class Pair<KeyType, ValueType> {

    private KeyType key;
    private ValueType value;

    public Pair(KeyType key, ValueType value) {
        this.key = key;
        this.value = value;
    }

    public KeyType getKey() {
        return key;
    }

    public ValueType getValue() {
        return value;
    }

    public void setValue(ValueType value) {
        this.value = value;
    }
}
