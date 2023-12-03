package edu.hw7.task2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FactorialCalculatorTest {
    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "1, 1",
        "5, 120",
        "10, 3628800",
    })
    public void whenNonNegativeNumberShouldCalculateFactorialCorrectly(int input, long expected) {
        assertThat(FactorialCalculator.calculateFactorial(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"-1", "-10"})
    public void whenNegativeNumberShouldThrowException(int input) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> FactorialCalculator.calculateFactorial(input));
    }
}
