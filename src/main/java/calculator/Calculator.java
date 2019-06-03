package calculator;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.security.InvalidParameterException;

public class Calculator {
    private double currentValue = 0;

    public double getCurrentValue() {
        return currentValue;
    }

    public void add(int number) {
        currentValue += number;
    }

    public void subtract(int number) {
        currentValue -= number;
    }

    public void multiply(int number) {
        if (number == 0) {
            throw new InvalidParameterException("couldn't multiply by zero");
        }
        currentValue *= number;
    }

    public void divide(int number) {
        if (number == 0) {
            throw new InvalidParameterException("couldn't divide by zero");
        }
        currentValue /= number;
    }

    public void explode() {
        throw new NotImplementedException();
    }

    public void reset() {
        currentValue = 0;
    }
}
