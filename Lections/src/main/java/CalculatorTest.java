package main.java;

public class CalculatorTest {
    public static void main(String[] args) {
        if (4 != Calculator.calculation(2, 2, '+')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (2 != Calculator.calculation(4, 2, '-')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (4 != Calculator.calculation(8, 2, '/')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (6 != Calculator.calculation(3, 2, '*')) {
            throw new AssertionError("Ошибка в методе");
        }

        try {
            Calculator.calculation(8, 4, '_');
        } catch (IllegalStateException e) {
            if (!e.getMessage().equals("Unexpected value operation: _")) {
                throw new AssertionError("Ошибка в методе");
            }
        }
    }
}
