import org.junit.jupiter.api.Test;
import seminars.seminarFour.main.DataProcessor;
import seminars.seminarFour.main.Database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class DataProcessorTest {
//    Задание 6: Вам требуется протестировать класс, который обрабатывает запросы к базе данных.
//            Условие: У вас есть класс Database с методом public List<String> query(String sql), который выполняет SQLзапрос и возвращает результат.
//    Вам необходимо проверить правильность работы класса DataProcessor, который использует Database для
//    выполнения запроса и обработки результатов.


    @Test
    public void dbSqlTest(){
        Database databaseMock = mock(Database.class);
        DataProcessor dataProcessor = new DataProcessor(databaseMock);

        List<String> expectedResult = new ArrayList<>(Arrays.asList("res1", "res2"));

        String query = "SELECT * FROM mytable;";

        when(databaseMock.query(query)).thenReturn(expectedResult);

        List<String> asctualResult = dataProcessor.processData(query);

        verify(databaseMock).query(query);

        assertEquals(asctualResult, expectedResult);
    }
}