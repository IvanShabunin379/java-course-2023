package edu.hw2.task1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ExprTest {

    @Test
    public void constantShouldReturnItself() {
        Expr.Constant constant = new Expr.Constant(5.0);
        assertThat(constant.evaluate()).isEqualTo(5.0);
    }

    @Test
    public void negateShouldReturnNegativeExpression() {
        Expr.Negate negate = new Expr.Negate(new Expr.Constant(3.0));
        assertThat(negate.evaluate()).isEqualTo(-3.0);
    }

    @Test
    public void exponentShouldReturnBaseToExponentDegree() {
        Expr.Exponent exponent = new Expr.Exponent(new Expr.Constant(2.0), 3);
        assertThat(exponent.evaluate()).isEqualTo(8.0);
    }

    @Test
    public void additionShouldReturnSumOfLeftAndRight() {
        Expr.Addition addition = new Expr.Addition(new Expr.Constant(2.0), new Expr.Constant(3.0));
        assertThat(addition.evaluate()).isEqualTo(5.0);
    }

    @Test
    public void multiplicationShouldReturnProductOfLeftAndRight() {
        Expr.Multiplication multiplication = new Expr.Multiplication(new Expr.Constant(2.0), new Expr.Constant(3.0));
        assertThat(multiplication.evaluate()).isEqualTo(6.0);
    }
}
