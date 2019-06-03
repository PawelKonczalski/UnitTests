package calculatorTDD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTDDTest {
    private CalculatorTDD calculator;

    @BeforeEach
    void setUp() {
        calculator = new CalculatorTDD();
    }

    @Test
    void shouldAddNumber() {
        //given
        int number = 5;
        //when
        calculator.add(number);
        //then
        assertThat(calculator.getCurrentValue()).isEqualTo(number);
    }

    @Test
    void shouldAddTwoNumber() {
        //given
        int number = 5;
        int expected = 10;
        //when
        calculator.add(number);
        calculator.add(number);
        //then
        assertThat(calculator.getCurrentValue()).isEqualTo(expected);
    }

    @Test
    void shouldSubtractNumber() {
        //given
        int number = 5;
        int expected = -5;
        //when
        calculator.subtract(number);
        //then
        assertThat(calculator.getCurrentValue()).isEqualTo(expected);
    }

    @Test
    void shouldMultipleNumber() {
        //given
        int number = 5;
        int expected = 25;
        //when
        calculator.add(number);
        calculator.multiple(number);
        //then
        assertThat(calculator.getCurrentValue()).isEqualTo(expected);
    }

    @Test
    void shouldDivideNumber() {
        //given
        int number = 2;
        double expected = 2.5;
        //when
        calculator.add(5);
        calculator.divide(number);
        //then
        assertThat(calculator.getCurrentValue()).isEqualTo(expected);
    }

    @Test
    void shouldResetCalculator() {
        //given
        double expected = 0;
        //when
        calculator.reset();
        //then
        assertThat(calculator.getCurrentValue()).isEqualTo(expected);
    }

}