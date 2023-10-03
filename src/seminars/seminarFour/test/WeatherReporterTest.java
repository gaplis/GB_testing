import org.junit.jupiter.api.Test;
import seminars.seminarFour.main.WeatherReporter;
import seminars.seminarFour.main.WeatherService;

import java.util.Random;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

class WeatherReporterTest {

//    Задание 3: Предположим, у вас есть класс WeatherService, который имеет метод getCurrentTemperature(),
//    обращающийся к внешнему API для получения информации о текущей температуре.
//    Вам нужно протестировать другой класс, WeatherReporter, который использует WeatherService.
//    Создайте мок-объект для WeatherService с использованием Mockito.

    @Test
    public void weatherReporterClassTest(){
        WeatherService weatherServiceMock = mock(WeatherService.class);

//        int temperature = 22 + new Random().nextInt(9);
        when(weatherServiceMock.getCurrentTemperature()).thenReturn(23);

        WeatherReporter weatherReporter = new WeatherReporter(weatherServiceMock);
        assertThat(weatherReporter.generateReport())
                .isEqualTo("Текущая температура: " + 23 + " градусов.");
    }

}