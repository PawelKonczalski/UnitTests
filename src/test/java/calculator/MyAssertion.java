package calculator;

import org.junit.jupiter.api.Assertions;

public class MyAssertion {

    public static void assertZeroDividing(double liczba) {
        if(liczba == 0){
            Assertions.fail("You can't divide by zero");
        }
    }

    public static void assertZeroMultiple(double liczba) {
        if(liczba == 0){
            Assertions.fail("You can't multiple by zero");
        }
    }

    public static void assertTheCalculatorIsReset(Calculator calculator) {
        if(calculator.getCurrentValue() != 0){
            Assertions.fail("Calculator is not reset");
        }
    }


}

