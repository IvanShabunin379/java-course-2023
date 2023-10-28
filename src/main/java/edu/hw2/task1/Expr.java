package edu.hw2.task1;

public sealed interface Expr {
    double evaluate();

    record Constant(double value) implements Expr {
        public double evaluate() {
            return value;
        }
    }

    record Negate(Expr expression) implements Expr {
        public double evaluate() {
            return -expression.evaluate();
        }
    }

    record Exponent(Expr base, int exponent) implements Expr {
        public double evaluate() {
            return Math.pow(base.evaluate(), exponent);
        }
    }

    record Addition(Expr left, Expr right) implements Expr {
        public double evaluate() {
            return left.evaluate() + right.evaluate();
        }
    }

    record Multiplication(Expr left, Expr right) implements Expr {
        public double evaluate() {
            return left.evaluate() * right.evaluate();
        }
    }
}

