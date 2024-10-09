package validating;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {

        if (name == null){
            throw new IllegalArgumentException("name can not be null");
        }else if( name.equals("")){
            throw new IllegalArgumentException("name can not be empty");
        }else if( name.length() > 40){
            throw new IllegalArgumentException("name can not be longer than 40 characters");
        }else if (age<0 || age > 120){
            throw new IllegalArgumentException("age should be a value between 0 and 120");
        }

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
