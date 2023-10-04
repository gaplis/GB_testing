package homeworks.homeworkFour.test;


import homeworks.homeworkFour.main.Book;
import homeworks.homeworkFour.main.BookRepository;
import homeworks.homeworkFour.main.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {
//    Задание 2: У вас есть класс BookService, который использует интерфейс BookRepository для получения информации
//    о книгах из базы данных. Ваша задача написать unit-тесты для BookService,
//    используя Mockito для создания мок-объекта BookRepository.
    private BookService bookService;
    private BookRepository bookRepositoryMock;

    @BeforeEach
    void setUp() {
        bookRepositoryMock = mock(BookRepository.class);
        bookService = new BookService(bookRepositoryMock);
    }

    @Test
    void findBookByIdTest(){
        String bookId = "1";
        Book expectedBook = new Book(bookId, "Book 1", "Author 1");
        when(bookRepositoryMock.findById(bookId)).thenReturn(expectedBook);

        Book result = bookService.findBookById(bookId);

        assertEquals(expectedBook, result);
    }

    @Test
    void findAllBooksTest(){
        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Book("1", "Book 1", "Author 1"));
        expectedBooks.add(new Book("2", "Book 2", "Author 2"));

        when(bookRepositoryMock.findAll()).thenReturn(expectedBooks);
        List<Book> result = bookService.findAllBooks();

        assertEquals(expectedBooks, result);
    }
}