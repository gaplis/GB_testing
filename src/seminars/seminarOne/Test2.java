// Разберемся с использованием условий в утверждениях на примере переменной x.
// Нужно исправить код так, чтобы метод не выбрасывал ошибку.

package seminars.seminarOne;

public class Test2 {
    public static void main(String[] args) {
        assertConditionB();
    }

    public static void assertConditionB() {
//        int x = -1; // было
        int x = 1; // стало
        assert x >= 0;
    }

}
