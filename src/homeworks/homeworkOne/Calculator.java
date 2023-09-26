package homeworks.homeworkOne;

public class Calculator {
    public static double calculateDiscount(double sumPurchase, int discount) {
        double result;

        if (discount < 0) {
            throw new ArithmeticException("Скидка не может быть меньше 0%!");
        } else if (discount > 100) {
            throw new ArithmeticException("Скидка не может быть больше 100%!");
        } else if (sumPurchase < 0) {
            throw new ArithmeticException("Сумма покупки не может быть меньше 0 у.е.!");
        } else {
            double sumDiscount = sumPurchase * discount / 100;
            result = sumPurchase - sumDiscount;
        }

        return result;
    }
}
