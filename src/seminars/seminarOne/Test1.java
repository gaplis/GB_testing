// Давайте представим, что вы работаете над календарным приложением и вам нужно убедиться, что
// количество выходных в неделе правильно установлено.
// Исправьте следующий код так, чтобы утверждение было верно и код не выбрасывал ошибку

package seminars.seminarOne;

public class Test1 {
    public static void main(String[] args) {
        assertConditionA();
    }

    public static void assertConditionA() {
        String[] weekends = {"Суббота", "Воскресенье"};
        // assert weekends.length == 3; // было
        assert weekends.length == 2; // стало
        System.out.println("В неделе " + weekends.length + " дня выходных");
    }
}
