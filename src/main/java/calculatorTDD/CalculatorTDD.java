package calculatorTDD;

public class CalculatorTDD {

    private double currentNumber;

    public void add(int number) {
        currentNumber += number;
    }

    public void subtract(int number) {
        currentNumber -= number;
    }

    public double getCurrentValue() {
        return currentNumber;
    }

    public void multiple(int number) {
        currentNumber *= number;
    }

    public void divide(int number) {
        currentNumber /= number;
    }

    public void reset() {
        currentNumber = 0;
    }

}
