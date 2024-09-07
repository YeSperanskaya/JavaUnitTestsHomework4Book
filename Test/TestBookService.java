
import org.junit.jupiter.api.Test;
import seminars.fourth.book.Book;
import seminars.fourth.book.BookRepository;
import seminars.fourth.book.BookService;


import static org.assertj.core.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TestBookService {
    BookRepository bookRepository = mock(BookRepository.class);
    BookService bookService = new BookService(bookRepository);

    @Test
    void testGetBookInZero() {
        when(bookService.findBookById("0")).thenReturn(mock(Book.class));
        assertThat(bookService.findBookById("0")).isInstanceOf(Book.class);
    }
    @Test
    void testGetBookNull() {
        when(bookService.findBookById("null")).thenReturn(null);
        assertThat(bookService.findBookById("null")).isNull();
    }
    @Test
    void testGetAllBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("1984", "George Orwell", "12345"));
        when(bookRepository.findAll()).thenReturn(books);
        List<Book> foundBooks = bookService.findAllBooks();
        assertEquals(1, foundBooks.size());
        assertEquals("George Orwell", foundBooks.get(0).getTitle());
    }
    @Test
    void testGetEmptyAllBooks() {
        List<Book> books = new ArrayList<>();
        when(bookRepository.findAll()).thenReturn(books);
        List<Book> foundBooks = bookService.findAllBooks();
        assertEquals(0, foundBooks.size());
    }



}
