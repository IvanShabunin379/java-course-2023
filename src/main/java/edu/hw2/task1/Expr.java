package edu.hw2.task1;

public sealed interface Expr {
    double evaluate();

    public final record Constant(double value) implements Expr {
        public double evaluate() {
            return value;
        }
    }

    public final record Negate(Expr expression) implements Expr {
        public double evaluate() {
            return -expression.evaluate();
        }
    }

    public final record Exponent(Expr base, int exponent) implements Expr {
        public double evaluate() {
            return Math.pow(base.evaluate(), exponent);
        }
    }

    public final record Addition(Expr left, Expr right) implements Expr {
        public double evaluate() {
            return left.evaluate() + right.evaluate();
        }
    }

    public final record Multiplication(Expr left, Expr right) implements Expr {
        public double evaluate() {
            return left.evaluate() * right.evaluate();
        }
    }
}

