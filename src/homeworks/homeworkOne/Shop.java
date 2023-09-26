package homeworks.homeworkOne;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return отсортированный по возрастанию и цене список продуктов
     */
    public List<Product> getSortedListProducts() {
        List<Product> sortedProducts = new ArrayList<>(products);
        Comparator<Product> priceComparator = Comparator.comparing(Product::getCost);
        sortedProducts.sort(priceComparator);
        return sortedProducts;
    }

    /**
     * @return самый дорогой продукт
     */
    public Product getMostExpensiveProduct() {
        Product mostExpensiveProduct = null;
        int maxPrice = Integer.MIN_VALUE;

        for (Product product : products) {
            int price = product.getCost();
            if (price > maxPrice) {
                maxPrice = price;
                mostExpensiveProduct = product;
            }
        }
        return mostExpensiveProduct;
    }
}