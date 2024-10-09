package validating;

public class Calculator {

    public int factorial(int num) {
        if(num < 0){
            throw new IllegalArgumentException("num must be greater or equal to 0");
        }

        int answer = 1;
        for (int i = 1; i <= num; i++) {
            answer *= i;
        }

        return answer;
    }

    public int binomialCoefficent(int setSize, int subsetSize) {
        if(setSize < 0){
            throw new IllegalArgumentException("setSize must be greater or equal than 0");
        }else if(subsetSize < 0){
            throw new IllegalArgumentException("subsetSize must be greater or equal than 0");
        }else if(subsetSize > setSize){
            throw new IllegalArgumentException("setSize must be greater or equal than subsetSize");
        }

        int numerator = factorial(setSize);
        int denominator = factorial(subsetSize) * factorial(setSize - subsetSize);

        return numerator / denominator;
    }
}
