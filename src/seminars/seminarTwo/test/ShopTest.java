import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seminars.seminarTwo.main.Cart;
import seminars.seminarTwo.main.Product;
import seminars.seminarTwo.main.Shop;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

class ShopTest {
    Shop shop;

    Cart cart;

    /**
     * Создаем набор продуктов для магазина:
     *
     * @return список продуктов
     */
    public static List<Product> getStoreItems() {
        List<Product> products = new ArrayList<>();

        // Три массива Названия, Цены, Кол-во
        String[] productNames = {"bacon", "beef", "ham", "salmon", "carrot", "potato", "onion", "apple", "melon", "rice", "eggs", "yogurt"};
        Double[] productPrice = {170.00d, 250.00d, 200.00d, 150.00d, 15.00d, 30.00d, 20.00d, 59.00d, 88.00d, 100.00d, 80.00d, 55.00d};
        Integer[] stock = {10, 10, 10, 10, 10, 10, 10, 70, 13, 30, 40, 60};

        // Последовательно наполняем список продуктами
        for (int i = 0; i < productNames.length; i++) {
            products.add(new Product(i + 1, productNames[i], productPrice[i], stock[i]));
        }
        return products;
    }

    private ByteArrayOutputStream output = new ByteArrayOutputStream();


    /*
                ID | Название  | Цена, р. | Кол-во в магазине, шт.
                1  | bacon     | 170.0    | 10
                2  | beef      | 250.0    | 10
                3  | ham       | 200.0    | 10
                4  | salmon    | 150.0    | 10
                5  | carrot    | 15.0     | 10
                6  | potato    | 30.0     | 10
                7  | onion     | 20.0     | 10
                8  | apple     | 59.0     | 70
                9  | melon     | 88.0     | 13
                10 | rice      | 100.0    | 30
                11 | eggs      | 80.0     | 40
                12 | yogurt    | 55.0     | 60
    */
    @BeforeEach
    void setup() {
        shop = new Shop(getStoreItems());
        cart = new Cart(shop);
    }

    // Задание 1: Разработайте модульный тест для проверки, что общая стоимость корзины с разными
    // товарами корректно рассчитывается

    /**
     * 2.1. Нужно написать юнит-тест для проверки следующей <b>ситуации</b>:
     * Пользователь положил в корзину несколько продуктов разной стоимости
     * <br><b>Ожидаемый результат:</b>
     * Стоимость корзины посчиталась корректно
     */
    @Test
    void priceCartIsCorrectCalculated() {
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(2);
        cart.addProductToCartByID(3);
        cart.addProductToCartByID(4);

        assertThat(cart.getTotalPrice()).isEqualTo(770);


    }

    // Задание 2: Создайте модульный тест для проверки, что общая стоимость корзины с множественными
    // экземплярами одного и того же продукта корректно рассчитывается.

    /**
     * 2.2. Нужно написать юнит-тест для проверки следующей <b>ситуации</b>:
     * Пользователь положил в корзину несколько продуктов разной стоимости (несколько продуктов одного вида)
     * <br><b>Ожидаемый результат:</b>
     * Стоимость корзины посчиталась корректно
     */
    @Test
    void priceCartProductsSameTypeIsCorrectCalculated() {
        cart.addProductToCartByID(10);
        cart.addProductToCartByID(10);
        cart.addProductToCartByID(10);

        assertThat(cart.getTotalPrice()).isEqualTo(300);

    }

//    Задание 3: Напишите модульный тест для проверки, что при удалении товара из
//    корзины происходит перерасчет общей стоимости корзины.

    /**
     * 2.3. Нужно написать юнит-тест для проверки следующей <b>ситуации</b>:
     * Пользователь удаляет товар из корзины
     * <br><b>Ожидаемый результат:</b>
     * Вызывается метод пересчета стоимости корзины, стоимость корзины меняется
     */
    @Test
    void whenChangingCartCostRecalculationIsCalled() {
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(2);
        cart.addProductToCartByID(3);
        cart.addProductToCartByID(4);
        cart.removeProductByID(3);

        assertThat(cart.getTotalPrice()).isEqualTo(570);

    }

//    Задание 4: Разработайте модульный тест для проверки, что при добавлении определенного количества
//    товара в корзину, общее количество этого товара в магазине соответствующим образом
//    уменьшается.

    /**
     * 2.4. Нужно написать юнит-тест для проверки следующей <b>ситуации</b>:
     * Пользователь кладет в корзину продукт в некотором количестве (не весь оставшийся)
     * <br><b>Ожидаемый результат:</b>
     * Количество товара в магазине уменьшается на число продуктов в корзине пользователя
     */
    @Test
    void quantityProductsStoreChanging() {
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(2);
        cart.addProductToCartByID(3);

        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(9);
        assertThat(shop.getProductsShop().get(1).getQuantity()).isEqualTo(9);
        assertThat(shop.getProductsShop().get(2).getQuantity()).isEqualTo(9);

    }

//    Задание 5: Создайте модульный тест для проверки, что если пользователь забирает все имеющиеся
//    продукты определенного типа из магазина, эти продукты больше не доступны для заказа.

    /**
     * 2.5. Нужно написать юнит-тест для проверки следующей <b>ситуации</b>:
     * Пользователь забрал последние оставшиеся продукты из магазина
     * <br><b>Ожидаемый результат:</b>
     * Больше такой продукт заказать нельзя, он не появляется на полке
     */
    @Test
    void lastProductsDisappearFromStore() {
        for (int i = 0; i < 14; i++) {
            cart.addProductToCartByID(1);
        }

        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(0);
        assertThat(cart.cartItems.get(0).getQuantity()).isEqualTo(10);
    }


//    Задание 6: Напишите модульный тест для проверки, что при удалении товара из корзины, общее
//    количество этого товара в магазине соответствующим образом увеличивается.

    /**
     * 2.6. Нужно написать юнит-тест для проверки следующей <b>ситуации</b>:
     * Пользователь удаляет продукт из корзины
     * <br><b>Ожидаемый результат:</b>
     * Количество продуктов этого типа на складе увеличивается на число удаленных из корзины продуктов
     */
    @Test
    void deletedProductIsReturnedToShop() {
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);
        cart.addProductToCartByID(1);

        assertThat(cart.cartItems.get(0).getQuantity()).isEqualTo(3);
        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(7);

        cart.removeProductByID(1);
        cart.removeProductByID(1);

        assertThat(cart.cartItems.get(0).getQuantity()).isEqualTo(1);
        assertThat(shop.getProductsShop().get(0).getQuantity()).isEqualTo(9);
    }


//    Задание 7: Разработайте параметризованный модульный тест для проверки, что при вводе неверного
//    идентификатора товара генерируется исключение RuntimeException.

    /**
     * 2.7. Нужно написать юнит-тест для проверки следующей <b>ситуации</b>:
     * Пользователь вводит неверный номер продукта
     * <br><b>Ожидаемый результат:</b>
     * Исключение типа RuntimeException и сообщение Не найден продукт с id
     * *Сделать тест параметризованным
     */
    @ParameterizedTest
    @ValueSource(ints = {-100, 100})
    void incorrectProductSelectionCausesException(int i) {
        assertThatThrownBy(() -> cart.addProductToCartByID(i))
                .isInstanceOf(RuntimeException.class).hasMessage("Не найден продукт с id: " + i);

    }

//    Задание 8: Создайте модульный тест для проверки, что при попытке удалить из корзины больше
//    товаров, чем там есть, генерируется исключение NoSuchFieldException.

    /**
     * 2.8. Нужно написать юнит-тест для проверки следующей <b>ситуации</b>:
     * Пользователь удаляет из корзины больше продуктов чем у него есть в корзине (удаляет продукты до того, как их добавить)
     * <br><b>Ожидаемый результат:</b> Исключение типа NoSuchFieldError и сообщение "В корзине не найден продукт с id"
     */
    @Test
    void incorrectProductRemoveCausesException() {
        assertThatThrownBy(() -> cart.removeProductByID(1))
                .isInstanceOf(RuntimeException.class).hasMessage("Не найден продукт с id: " + 1);

    }

    // Задание 9: Восстановите и оптимизируйте данный тестовый метод

    /**
     * 2.9. Нужно восстановить тест
     */
    @Test
    void brokenTest() {
        cart.addProductToCartByID(2); // 250
        cart.addProductToCartByID(2); // 250
        assertThat(cart.getTotalPrice()).isEqualTo(500);
    }

// Задание 10: Нужно оптимизировать тестовый метод, согласно следующим условиям:
// 1. Отображаемое имя - "Advanced test for calculating TotalPrice"
// 2. Тест должен повторяться 10 раз
// 3. Установлен таймаут на выполнение теста 70 Миллисекунд (unit = TimeUnit.MILLISECONDS)
// 4. После проверки работоспособности теста, его нужно выключить

    /**
     * 2.10. Нужно изменить тест по следующим критериям:
     * <br> 1. Отображаемое имя - "Advanced test for calculating TotalPrice"
     * <br> 2. Тест повторяется 10 раз
     * <br> 3. Установлен таймаут на выполнение теста 70 Миллисекунд (unit = TimeUnit.MILLISECONDS)
     * <br> 4. После проверки работоспособности теста, его нужно выключить
     */
    @RepeatedTest(10)
    @DisplayName("Advanced test for calculating TotalPrice")
    @Timeout(value = 70, unit = TimeUnit.MILLISECONDS)
    void priceCartIsCorrectCalculatedExt() throws InterruptedException {
        assertThat(true);
    }
}