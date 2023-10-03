package seminars.seminarFour.main;

import java.util.Random;

public class HttpClient {

    Random random;

    public String get(String url){
        // тут должен быть код для выполнения запроса, а пока что возвращаю случайное число от 100 до 500
        return "" + (100 + random.nextInt(400));
    }
}
