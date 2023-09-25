// Найдите и исправьте логическую ошибку в коде, который планирует поздравление с Новым Годом в полночь.


package seminars.seminarOne;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test4 {
    public static void main(String[] args) {
        happyNY();
    }

    public static void happyNY() {
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String currentDateTime = dateFormat.format(calendar.getTime());

        // ошибка в том, что проверяется дата и время 01.01.2024 00:00:00,
        // то есть если будет 00:00:01 и т.д., то будет ошибка
        assert currentDateTime.equals("01/01/2024 00:00:00") : "Еще 2023 год :(";
        System.out.println("С новым годом!");
    }

}
