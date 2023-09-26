package homeworks.homeworkOne;

public class Product {
    private int cost; // Стоимость продукта
    private String title; // Название

    public Product(String title, Integer cost) {
        this.cost = cost;
        this.title = title;
    }


    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}