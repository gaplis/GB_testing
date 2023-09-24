package lections.lectionOne.main.java;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    public static void main(String[] args) {
//        if (4 != Calculator.calculation(2, 2, '+')) {
//            throw new AssertionError("Ошибка в методе");
//        }
//
//        if (2 != Calculator.calculation(4, 2, '-')) {
//            throw new AssertionError("Ошибка в методе");
//        }
//
//        if (4 != Calculator.calculation(8, 2, '/')) {
//            throw new AssertionError("Ошибка в методе");
//        }
//
//        if (6 != Calculator.calculation(3, 2, '*')) {
//            throw new AssertionError("Ошибка в методе");
//        }

//        assert 4 == Calculator.calculation(2, 2, '+');
//        assert 2 == Calculator.calculation(4, 2, '-');
//        assert 4 == Calculator.calculation(8, 2, '/');
//        assert 9 == Calculator.calculation(3, 2, '*'); // намеренная ошибка

        assertThat(Calculator.calculation(2, 2, '+')).isEqualTo(4);
        assertThat(Calculator.calculation(4, 2, '-')).isEqualTo(2);
        assertThat(Calculator.calculation(8, 2, '/')).isEqualTo(4);
        assertThat(Calculator.calculation(3, 2, '*')).isEqualTo(8); // намеренная ошибка

        assertThatThrownBy(() -> Calculator.calculation(8, 4, '_'))
                .isInstanceOf(IllegalStateException.class);

//        try {
//            Calculator.calculation(8, 4, '_');
//        } catch (IllegalStateException e) {
//            if (!e.getMessage().equals("Unexpected value operation: _")) {
//                throw new AssertionError("Ошибка в методе");
//            }
//        }
    }
}
