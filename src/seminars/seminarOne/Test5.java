// Исправьте код метода, предполагая что условие утверждения написано верно.

package seminars.seminarOne;

import java.util.ArrayList;

public class Test5 {
    public static void main(String[] args) {
        checkingShoppingCart();
    }

    public static void checkingShoppingCart() {
        ArrayList<String> productCategories = new ArrayList<>();
        productCategories.add("fruits");
        productCategories.add("vegetables");
        productCategories.add("bakery");
        productCategories.add("drinks");
        ArrayList<String> products = new ArrayList<>();
        products.add("apple");
        products.add("tomato");
        products.add("bread");
        products.add("water");
        for (String product : products) {
            switch (product) {
                case "apple" -> System.out.println("category: " + productCategories.get(0));
                case "tomato" -> System.out.println("category: " + productCategories.get(1));
                case "bread" -> System.out.println("category: " + productCategories.get(2));
                case "water" -> System.out.println("category: " + productCategories.get(3));
                default -> {
                    assert false : "Unknown category for the product " + product;
                }
            }
        }
    }


}
