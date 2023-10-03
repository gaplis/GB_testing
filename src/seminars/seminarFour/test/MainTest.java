import org.junit.jupiter.api.Test;


import java.util.*;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class MainTest {

//    Задание 1: Создать мок-объект Iterator, настроить поведение так, чтобы за два вызова next() Iterator
//    вернул два слова “Hello World”, и проверить это поведение с помощью утверждений

    /**
     * 4.1. Создать мок-объект Iterator, настроить поведение так,
     * чтобы за два вызова next() Iterator вернул два слова  “Hello World”,
     * и проверить это поведение с помощью утверждений
     */
      @Test
      public void iteratorWillReturnHelloWorld() {
          // Arrange
          Iterator iteratorMock = mock(Iterator.class);
          when(iteratorMock.next()).thenReturn("Hello", "World");
          // Act
          String result = iteratorMock.next() + " " + iteratorMock.next();
          // Assert
          assertEquals("Hello World", result);
      }

}