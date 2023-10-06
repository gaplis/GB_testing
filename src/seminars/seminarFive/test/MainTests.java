import org.junit.jupiter.api.Test;
import seminars.seminarFive.main.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTests {

    //Задание 1: Создайте два модуля. Первый модуль генерирует список случайных чисел. Второй модуль находит
    //максимальное число в этом списке.
    //Вам нужно сначала написать юнит-тесты для каждого модуля, затем написать интеграционный
    //тест, который проверяет, что оба модуля работают вместе правильно

    @Test
    void testGenerateRandomNumber(){
        RandomNumberModule randomNumberModule =  new RandomNumberModule();
        assertThat(randomNumberModule.generateList(5).size()).isEqualTo(5);
    }

    @Test
    void testMaxNumber(){
        MaxNumberModule maxNumberModule = new MaxNumberModule();
        assertThat(maxNumberModule.takeMaxNumber(Arrays.asList(1, 4, 6, 3, 8))).isEqualTo(8);
    }

    @Test
    void testIntegration(){
        RandomNumberModule randomNumberModule =  new RandomNumberModule();
        MaxNumberModule maxNumberModule = new MaxNumberModule();
        List<Integer> listNumbers = randomNumberModule.generateList(5);
        assertThat(maxNumberModule.takeMaxNumber(listNumbers)).isEqualTo(Collections.max(listNumbers));
    }

    //Задание 2: У вас есть два класса - UserService и UserRepository. UserService использует UserRepository для
    //получения информации о пользователе. Ваша задача - написать интеграционный тест, который
    //проверяет, что UserService и UserRepository работают вместе должным образом.

    UserRepository repository = new UserRepository();
    UserService service = new UserService(repository);

    @Test
    void userIntegrationTest(){
        int userID = 3;
        String expectedUserName = "User " + userID;
        String actualUserName = service.getUserName(userID);

        assertEquals(expectedUserName, actualUserName);
    }

    //Задание 3: У вас есть сервис по обработке заказов, состоящий из двух классов: OrderService и
    //PaymentService. Класс OrderService обрабатывает заказы и делает вызовы к
    //PaymentService для обработки платежей. Ваша задача - написать интеграционный тест,
    //который проверяет, что OrderService и PaymentService взаимодействуют корректно

    @Test
    void payTest(){
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        String orderId = "0012";
        double amount = 500.0;

        assertTrue(orderService.placeOrder(orderId, amount));
    }
}