package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {


    Calculator calculator = new Calculator();

    @Test
    void shouldAddTwoNumbers() {

        calculator.add(5);
        calculator.add(5);

        assertEquals(10, calculator.getCurrentValue());
    }

    @Test
    void shouldSubtractTwoNumbers() {

        calculator.subtract(5);
        calculator.subtract(5);

        assertEquals(-10, calculator.getCurrentValue());
    }

    @Test
    void shouldMultiplyTwoNumbers() {

        calculator.add(5);

        //MyAssertion.assertZeroMultiple(calculator.getCurrentValue());

        calculator.multiply(2);

        assertEquals(10, calculator.getCurrentValue());
    }

    @Test
    void shouldDivideTwoNumbers() {

        calculator.add(5);

        //MyAssertion.assertZeroDividing(calculator.getCurrentValue());

        calculator.divide(2);

        assertEquals(2.5, calculator.getCurrentValue());
    }

    @Test
    double shoulCalculatorResetWork() {

        calculator.add(5);
        //when
        calculator.reset();
        //then
        //MyAssertion.assertTheCalculatorIsReset(calculator);
        return calculator.getCurrentValue();
    }

    @Test
    void ShouldThrowAnInvalidOperationExceptionDuringDividingByZero() {
        //when
        InvalidParameterException invalidParameterException = assertThrows(
                InvalidParameterException.class,
                () -> calculator.divide(0));
        //then
        assertTrue(invalidParameterException.getMessage().contains("couldn't divide by zero"));
    }

    @Test
    void ShouldThrowAnInvalidOperationExceptionDuringMultiplyByZero() {
        //when
        InvalidParameterException invalidParameterException = assertThrows(
                InvalidParameterException.class,
                () -> calculator.multiply(0));
        //then
        assertTrue(invalidParameterException.getMessage().contains("couldn't multiply by zero"));
    }

    @Test
    void ShouldResetEqualsZero() {

        assertEquals(0, shoulCalculatorResetWork());
    }

    @Test
    void ShouldThrowAnInvalidOperationExceptionExplode() {
        //when
        NotImplementedException notImplementedException = assertThrows(
                NotImplementedException.class,
                () -> calculator.explode());
        //then
        assertEquals(notImplementedException, notImplementedException);
    }

    @ParameterizedTest
    @CsvSource({"15, 20, 35", "2, 5, 7", "20, 20, 40"})
    void Should_Sum_Two_Numbers(int firstNumber, int secondNumber, int expectedValue) {
        //given
        Calculator calculator = new Calculator();
        //when
        calculator.add(firstNumber);
        calculator.add(secondNumber);
        //then
        Assertions.assertEquals(expectedValue, calculator.getCurrentValue());
    }


    @ParameterizedTest
    @CsvSource({"15, 20, -5", "2, 5, -3", "20, 20, 0"})
    void Show_Difference_Two_Numbers(int firstNumber, int secondNumber, int expectedValue) {
        //given
        Calculator calculator = new Calculator();
        //when
        calculator.add(firstNumber);
        calculator.subtract(secondNumber);
        //then
        Assertions.assertEquals(expectedValue, calculator.getCurrentValue());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test_sum_numbers.csv")
    void Should_Sum_Two_Number_CSV(int firstNumber, int secondNumber, int expectedValue) {
        //given
        Calculator calculator = new Calculator();
        //when
        calculator.add(firstNumber);
        calculator.add(secondNumber);
        //then
        Assertions.assertEquals(expectedValue, calculator.getCurrentValue());
    }


}