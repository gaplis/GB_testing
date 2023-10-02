import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seminars.seminarThree.main.MoodAnalyser;
import seminars.seminarThree.main.SomeService;
import seminars.seminarThree.main.User;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
    // 3.1.

//    Задание 1: Создайте набор тестов, полностью покрывающих все ветви кода функции fizzBuzz. Эта
//    функция принимает на вход число и возвращает "Fizz", если число делится на 3, "Buzz",
//    если число делится на 5, и "FizzBuzz", если число делится на 15. Если число не делится ни
//    на 3, ни на 5, ни на 15, функция возвращает входное число в виде строки.

    private SomeService someService;

    @BeforeEach
    void setUp() {
        someService = new SomeService();
    }

    @Test
    void testReturnFizz() {
        assertThat(someService.fizzBuzz(3)).isEqualTo("Fizz");
    }

    @Test
    void testReturnBuzz() {
        assertThat(someService.fizzBuzz(5)).isEqualTo("Buzz");
    }

    @Test
    void testReturnFizzBuzz() {
        assertThat(someService.fizzBuzz(15)).isEqualTo("FizzBuzz");
    }

    @Test
    void testReturnEcho() {
        assertThat(someService.fizzBuzz(14)).isEqualTo("" + 14);
    }

//    Задание 2: Разработайте тесты для метода firstLast6, где на вход подается массив чисел, а метод
//    возвращает true, если первое или последнее число в массиве равно 6, иначе false.

    @Test
    void checkFirstArray() {
        assertThat(someService.firstLast6(new int[]{6, 2, 3, 0})).isTrue();
    }

    @Test
    void checkLastArray() {
        assertThat(someService.firstLast6(new int[]{1, 2, 3, 6})).isTrue();
    }

    @Test
    void checkArray() {
        assertThat(someService.firstLast6(new int[]{6, 2, 3, 6})).isTrue();
    }

    @Test
    void checkOutArray() {
        assertThat(someService.firstLast6(new int[]{1, 2, 3, 1})).isFalse();
    }

//    Задание 3: Создайте тесты, обеспечивающие полное покрытие кода метода calculatingDiscount, который принимает сумму
//    покупки и размер скидки, затем вычисляет и возвращает сумму с учетом скидки. Метод должен обрабатывать
//    исключения, связанные с некорректным размером скидки или отрицательной суммой покупки.

    @Test
    void discountDegreeZeroTest() {
        assertThatThrownBy(() -> someService.calculatingDiscount(-100, 10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть отрицательной");
    }

    @Test
    void percentSubZeroTest() {
        assertThatThrownBy(() -> someService.calculatingDiscount(100, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }

    @Test
    void percentUpHundredTest() {
        assertThatThrownBy(() -> someService.calculatingDiscount(100, 101))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 20, 40, 60, 80, 100})
    void goodDiscountTest(int i) {
        assertThat(someService.calculatingDiscount(1000, i)).isEqualTo(1000 - (1000 / 100) * i);
    }

//    Задача 4: Разработайте метод luckySum и напишите для него тесты. Этот метод принимает на вход три числа и возвращает
//    их сумму. Однако, если одно из чисел равно 13, то оно не учитывается при подсчете суммы.
//            Так, например, если b равно 13, то считается сумма только a и c

    @Test
    void luckySumA() {
        assertThat(someService.luckySum(13, 2, 3)).isEqualTo(5);
    }

    @Test
    void luckySumB() {
        assertThat(someService.luckySum(2, 13, 3)).isEqualTo(5);
    }

    @Test
    void luckySumC() {
        assertThat(someService.luckySum(3, 2, 13)).isEqualTo(5);
    }

    @Test
    void luckySumAB() {
        assertThat(someService.luckySum(13, 13, 3)).isEqualTo(3);
    }

    @Test
    void luckySumAC() {
        assertThat(someService.luckySum(13, 3, 13)).isEqualTo(3);
    }

    @Test
    void luckySumBC() {
        assertThat(someService.luckySum(3, 13, 13)).isEqualTo(3);
    }

    @Test
    void luckySumABC() {
        assertThat(someService.luckySum(13, 13, 13)).isEqualTo(0);
    }

    @Test
    void luckySumNot13() {
        assertThat(someService.luckySum(3, 2, 1)).isEqualTo(6);
    }

}