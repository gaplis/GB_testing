/* В классе Calculator создайте метод calculateDiscount,
который принимает сумму покупки и процент скидки и возвращает сумму с учетом скидки.
Ваша задача - проверить этот метод с использованием библиотеки AssertJ.
Если метод calculateDiscount получает недопустимые аргументы, он должен выбрасывать исключение ArithmeticException.
Не забудьте написать тесты для проверки этого поведения. */

package homeworks.homeworkOne;

import static org.assertj.core.api.Assertions.*;

public class Test1 {
    public static void main(String[] args) {
        testsCalculator();
    }

    public static void testsCalculator() {
        assertThat(Calculator.calculateDiscount(1000, 20)).isEqualTo(800);
        assertThat(Calculator.calculateDiscount(500.50, 10)).isEqualTo(450.45);
        assertThat(Calculator.calculateDiscount(1000, 0)).isEqualTo(1000);
        assertThat(Calculator.calculateDiscount(0, 50)).isEqualTo(0);

        assertThatThrownBy(() -> Calculator.calculateDiscount(1000, 110))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка не может быть больше 100%!");
        assertThatThrownBy(() -> Calculator.calculateDiscount(1000, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка не может быть меньше 0%!");
        assertThatThrownBy(() -> Calculator.calculateDiscount(-1000, 0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть меньше 0 у.е.!");
        assertThatThrownBy(() -> Calculator.calculateDiscount(-1000, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка не может быть меньше 0%!");
    }
}
