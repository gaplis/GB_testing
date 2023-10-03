import org.junit.jupiter.api.Test;
import seminars.seminarFour.main.HttpClient;
import seminars.seminarFour.main.WebService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class WebServiceTest {

//  Задание 7: Вам нужно написать тест с использованием моков для класса, который выполняет HTTP-запросы.
//  Условие: У вас есть класс HttpClient с методом public String get(String url), который выполняет
//  HTTP-запрос и возвращает результат. Вам необходимо проверить правильность работы класса
//  WebService, который использует HttpClient для получения данных с веб-сайта.

    @Test
    void getHttpTest(){
        HttpClient httpClientMock = mock(HttpClient.class);

        when(httpClientMock.get(anyString())).thenReturn("200");

        WebService webService = new WebService(httpClientMock);

        assertThat(webService.getHttp(anyString())).isEqualTo("200");

        verify(httpClientMock, times(1));
    }
}
