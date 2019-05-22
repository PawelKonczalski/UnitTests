package calculator;

public class Calculator {
    private int currentValue = 0;

    public int getCurrentValue() {
        return currentValue;
    }

    public void add(int number) {
        currentValue += number;
    }

    public void subtract(int number) {
        currentValue -= number;
    }

    public void multiply(int number) {
        currentValue *= number;
    }

    public void divide(int number) {
        currentValue *= number;
    }
}
