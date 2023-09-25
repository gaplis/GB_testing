// Попробуем сделать наш код более надежным, предотвратив переполнение переменной.
// Исправьте метод сложения двух чисел так, чтобы при переполнении переменной выбрасывалось
// предупреждение.


package seminars.seminarOne;

public class Test3 {
    public static void main(String[] args) {
        sum(2147483647, 10);
    }

    public static int sum(int a, int b) {
        assert (Integer.MAX_VALUE - a > b) : "Variable overflow while summing";
        return a + b;
    }


}
