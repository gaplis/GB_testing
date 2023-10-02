import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.seminarThree.main.MoodAnalyser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoodAnalyserTest {

    //    Задание 5: Примените подход TDD для создания нового класса MoodAnalyser, который оценивает настроение
//    выраженное во фразах.

    private MoodAnalyser moodAnalyser;

    @BeforeEach
    void startUp() {
        moodAnalyser = new MoodAnalyser();
    }

    @Test
    void testMoodAnalysisHappy() {
        assertThat(moodAnalyser.analyseMood("хорошее настроение!")).isEqualTo("happy");
    }

    @Test
    void testMoodAnalysisSad() {
        assertThat(moodAnalyser.analyseMood("плохое настроение!")).isEqualTo("sad");
    }

    @Test
    void testMoodAnalysisSoso() {
        assertThat(moodAnalyser.analyseMood("нейтральное настроение!")).isEqualTo("So so");
    }
}