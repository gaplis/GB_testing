// У вас есть следующий метод, который использует assert-выражения из библиотеки AssertJ для проверки
// содержания массива строк:
// Создайте массив строк colors, который удовлетворяет всем этим условиям.


package seminars.seminarOne;

import static org.assertj.core.api.Assertions.*;

public class Test7 {
    public static void main(String[] args) {
        String[] colors = {"aqua", "orange", "yellow", "blue", "green", "violet", "gold",};
        testingJavaCollectionsAssertJ(colors);
    }

    public static void testingJavaCollectionsAssertJ(String[] colors) {
        assertThat(colors)
                .isNotEmpty()
                .hasSize(7)
                .doesNotHaveDuplicates()
                .contains("orange", "green", "violet")
                .endsWith("gold")
                .startsWith("aqua")
                .containsSequence("yellow", "blue")
                .doesNotContain("red", "black");
    }


}
