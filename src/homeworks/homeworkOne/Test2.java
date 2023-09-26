/* Мы хотим улучшить функциональность нашего интернет-магазина.
Ваша задача - добавить два новых метода в класс Shop:
Метод sortProductsByPrice(), который сортирует список продуктов по стоимости.
Метод getMostExpensiveProduct(), который возвращает самый дорогой продукт.
Напишите тесты, чтобы проверить,
что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
Используйте класс Product для создания экземпляров продуктов и класс Shop для написания методов сортировки и тестов. */

package homeworks.homeworkOne;

import static org.assertj.core.api.Assertions.*;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<Product> products = List.of(new Product[]{
                new Product("apple", 25),
                new Product("banana", 22),
                new Product("orange", 15),
                new Product("mellon", 35)
        });
        List<Product> sortedProducts = List.of(new Product[]{
                new Product("orange", 15),
                new Product("banana", 22),
                new Product("apple", 25),
                new Product("mellon", 35)
        });
        Product mostExpensiveProduct = new Product("mellon", 35);

        testShop(products, sortedProducts, mostExpensiveProduct);
    }

    public static void testShop(List<Product> products, List<Product> sortedProducts, Product mostExpensiveProduct) {
        Shop shop = new Shop();
        shop.setProducts(products);
        List<Product> resultShop = shop.getProducts();
        List<Product> resultSortedListProducts = shop.getSortedListProducts();
        Product resultMostExpensiveProduct = shop.getMostExpensiveProduct();

        assertThat(resultShop.size()).isEqualTo(products.size());

        for (int i = 0; i < resultShop.size(); i++) {
            assertThat(resultShop.get(i)).isEqualTo(products.get(i));
        }

        for (int i = 0; i < sortedProducts.size(); i++) {
            assertThat(resultSortedListProducts.get(i).getCost()).isEqualTo(sortedProducts.get(i).getCost());
            assertThat(resultSortedListProducts.get(i).getTitle()).isEqualTo(sortedProducts.get(i).getTitle());
        }

        assertThat(resultMostExpensiveProduct.getCost()).isEqualTo(mostExpensiveProduct.getCost());
        assertThat(resultMostExpensiveProduct.getTitle()).isEqualTo(mostExpensiveProduct.getTitle());
    }
}
