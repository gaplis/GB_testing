import homeworks.homeworkThree.main.MainHW;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.seminarThree.main.MoodAnalyser;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

class MainHWTest {

    //    Задание 1: Напишите тесты, покрывающие на 100% метод evenOddNumber, который проверяет,
    //    является ли переданное число четным или нечетным. (код приложен в презентации)
    MainHW mainHW;

    @BeforeEach
    void setUp(){
        mainHW = new MainHW();
    }

    @Test
    void evenNumberTest(){
        assertThat(mainHW.evenOddNumber(2)).isEqualTo("Четное");
    }

    @Test
    void oddNumberTest(){
        assertThat(mainHW.evenOddNumber(3)).isEqualTo("Нечетное");
    }

//    Задание 2: Разработайте и протестируйте метод numberInInterval, который проверяет,
//    попадает ли переданное число в интервал (25;100). (код приложен в презентации)
    @Test
    void numberInIntervalTest(){
        assertThat(mainHW.numberInInterval(26)).isTrue();
    }

    @Test
    void numberNotInInterval25Test(){
        assertThat(mainHW.numberInInterval(24)).isFalse();
    }

    @Test
    void numberNotInInterval100Test(){
        assertThat(mainHW.numberInInterval(101)).isFalse();
    }

}