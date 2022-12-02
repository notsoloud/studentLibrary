package com.example.library.studentlibrary.services;

import com.example.library.studentlibrary.models.Author;
import com.example.library.studentlibrary.models.Book;
import com.example.library.studentlibrary.models.Genre;
import com.example.library.studentlibrary.repositories.BookRepository;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
    @InjectMocks BookService bookService2;

    @Mock
    BookRepository bookRepository2;

    private AuthorServiceTest authorServiceTest = new AuthorServiceTest();

    private List<Book> bookList2 = new ArrayList<>();

    @Before
    public void setUp(){
        Author author12 = new Author("1", "1@gmail.com", 23, "INDIA");
        Author author22 = new Author("2", "2@gmail.com", 47, "USA");

        Book book12 = new Book("A", Genre.FICTIONAL, author12);
        Book book22 = new Book("B", Genre.PHYSICS, author12);
        Book book32 = new Book("C", Genre.PHYSICS, author12);
        Book book42 = new Book("D", Genre.PHYSICS, author22);
        Book book52 = new Book("E", Genre.BOTANY, author22);
        Book book62 = new Book("F", Genre.FICTIONAL, author22);

        book12.setAvailable(Boolean.FALSE);
        book62.setAvailable(Boolean.FALSE);

        bookList2.add(book12);
        bookList2.add(book22);
        bookList2.add(book32);
        bookList2.add(book42);
        bookList2.add(book52);
        bookList2.add(book62);

        List<Book> expectedNoInputNull = new ArrayList<>();
        for(Book book: bookList2){
            if((book.isAvailable() == Boolean.TRUE) && (book.getGenre() == Genre.PHYSICS) && (book.getAuthor().getName() == "1")){
                expectedNoInputNull.add(book);
            }
        }

        List<Book> expectedAuthorNull = new ArrayList<>();
        for(Book book: bookList2){
            if((book.isAvailable() == Boolean.TRUE) && (book.getGenre() == Genre.PHYSICS)){
                expectedAuthorNull.add(book);
            }
        }

        List<Book> expectedGenreNull = new ArrayList<>();
        for(Book book: bookList2){
            if((book.isAvailable() == Boolean.TRUE) && (book.getAuthor().getName() == "2")){
                expectedGenreNull.add(book);
            }
        }

        List<Book> expectedNotAvailable = new ArrayList<>();
        for(Book book: bookList2){
            if(book.isAvailable() == Boolean.FALSE){
                expectedNotAvailable.add(book);
            }
        }

        when(bookRepository2.findBooksByGenreAuthor(anyString(), anyString(), anyBoolean())).thenReturn(expectedNoInputNull);
        when(bookRepository2.findBooksByAuthor(anyString(), anyBoolean())).thenReturn(expectedGenreNull);
        when(bookRepository2.findBooksByGenre(anyString(), anyBoolean())).thenReturn(expectedAuthorNull);
        when(bookRepository2.findByAvailability(Boolean.FALSE)).thenReturn(expectedNotAvailable);
    }

    @Test
    public void testCreateBook(){
        bookService2.createBook(bookList2.get(0));
    }

    @Test
    public void testGetBooksWhenNoInputNull(){
        HashSet<Book> res = new HashSet<>(bookService2.getBooks("PHYSICS", Boolean.TRUE, "1"));
        assert(res.size() == 2);
        for(Book book: res){
            assert((book.isAvailable() == Boolean.TRUE) && (book.getGenre() == Genre.PHYSICS) && (book.getAuthor().getName() == "1"));
        }
    }

    @Test
    public void testGetBooksWhenGenreNull(){
        HashSet<Book> res = new HashSet<>(bookService2.getBooks(null, Boolean.TRUE, "2"));
        assert(res.size() == 2);
        for(Book book: res){
            assert((book.isAvailable() == Boolean.TRUE) && (book.getAuthor().getName() == "2"));
        }
    }

    @Test
    public void testGetBooksWhenAuthorNull(){
        HashSet<Book> res = new HashSet<>(bookService2.getBooks("PHYSICS", Boolean.TRUE, null));
        assert(res.size() == 3);
        for(Book book: res){
            assert((book.isAvailable() == Boolean.TRUE) && (book.getGenre() == Genre.PHYSICS));
        }
    }

    @Test
    public void testGetBooksWhenNotAvailable(){
        HashSet<Book> res = new HashSet<>(bookService2.getBooks(null, Boolean.FALSE, null));
        assert(res.size() == 2);
        for(Book book: res){
            assert(book.isAvailable() == Boolean.FALSE);
        }
    }

    @Test
    public void runAuthorServiceTest(){
        authorServiceTest.testCreate();
    }
}
