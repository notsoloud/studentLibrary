package com.driver.test;

import com.driver.models.*;
import com.driver.repositories.*;
import com.driver.services.*;
import com.driver.models.*;
import com.driver.repositories.*;
import com.driver.services.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static com.driver.models.CardStatus.ACTIVATED;
import static com.driver.models.CardStatus.DEACTIVATED;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestCases {

    @InjectMocks
    AuthorService authorService1;
    @InjectMocks
    BookService bookService2;
    @InjectMocks
    CardService cardService3;
    @InjectMocks
    StudentService studentService4;
    @InjectMocks
    TransactionService transactionService5;

    @Mock
    AuthorRepository authorRepository1;
    @Mock
    BookRepository bookRepository1;
    @Mock
    CardRepository cardRepository1;
    @Mock
    StudentRepository studentRepository1;
    @Mock
    TransactionRepository transactionRepository1;

    @Mock
    AuthorRepository authorRepository2;
    @Mock
    BookRepository bookRepository2;
    @Mock
    CardRepository cardRepository2;
    @Mock
    StudentRepository studentRepository2;
    @Mock
    TransactionRepository transactionRepository2;

    @Mock
    AuthorRepository authorRepository3;
    @Mock
    BookRepository bookRepository3;
    @Mock
    CardRepository cardRepository3;
    @Mock
    StudentRepository studentRepository3;
    @Mock
    TransactionRepository transactionRepository3;

    @Mock
    CardService cardService4;
    @Mock
    AuthorRepository authorRepository4;
    @Mock
    BookRepository bookRepository4;
    @Mock
    CardRepository cardRepository4;
    @Mock
    StudentRepository studentRepository4;
    @Mock
    TransactionRepository transactionRepository4;

    @Mock
    AuthorRepository authorRepository5;
    @Mock
    BookRepository bookRepository5;
    @Mock
    CardRepository cardRepository5;
    @Mock
    StudentRepository studentRepository5;
    @Mock
    TransactionRepository transactionRepository5;

    private List<Book> bookList2 = new ArrayList<>();
    List<Student> students4 = new ArrayList<>();
    Student student9 = new Student();
    Card card9 = new Card();

    @Before
    public void setUp(){
        transactionService5.max_allowed_books = 1;
        transactionService5.getMax_allowed_days = 3;
        transactionService5.fine_per_day = 5;

        Author author15 = new Author("1", "1@gmail.com", 23, "INDIA");
        Author author25 = new Author("2", "2@gmail.com", 47, "USA");

        Book book15 = new Book("A", Genre.FICTIONAL, author15);
        Book book25 = new Book("B", Genre.PHYSICS, author15);
        Book book35 = new Book("C", Genre.PHYSICS, author25);

        book25.setAvailable(Boolean.FALSE);

        Card card15 = new Card();
        card15.setBooks(new ArrayList<>());
        Card card25 = new Card();
        card25.setCardStatus(CardStatus.DEACTIVATED);
        Card card35 = new Card();
        List<Book> booksOnCard35 = new ArrayList<>();
        booksOnCard35.add(book35);
        card35.setBooks(booksOnCard35);

        when(bookRepository5.findById(1)).thenReturn(Optional.of(book15));
        when(bookRepository5.findById(2)).thenReturn(Optional.of(book25));

        when(cardRepository5.findById(1)).thenReturn(Optional.of(card15));
        when(cardRepository5.findById(2)).thenReturn(Optional.of(card25));
        when(cardRepository5.findById(3)).thenReturn(Optional.of(card35));

        Transaction transaction5 = new Transaction();
        transaction5.setBook(book15);
        transaction5.setCard(card15);
        transaction5.setTransactionStatus(TransactionStatus.SUCCESSFUL);
        transaction5.setIssueOperation(Boolean.TRUE);
        Integer daysAfterTransaction = 5;
        Integer millisAfterTransaction = daysAfterTransaction * 86400000;
        transaction5.setTransactionDate(new Date(System.currentTimeMillis() - millisAfterTransaction));

        List<Transaction> transactions5 = new ArrayList<>();
        transactions5.add(transaction5);

        when(transactionRepository5.find(1, 1, TransactionStatus.SUCCESSFUL, true)).thenReturn(transactions5);


        Student student14 = new Student("1@gmail.com", "1", 1, "India");
        Student student24 = new Student("2@gmail.com", "2", 2, "USA");
        Student student34 = new Student("3@gmail.com", "3", 3, "UK");
        Student student44 = new Student("4@gmail.com", "4", 4, "China");

        students4.add(student14);
        students4.add(student24);
        students4.add(student34);
        students4.add(student44);

        when(studentRepository4.findByEmailId(anyString())).thenReturn(student14);
        when(studentRepository4.findById(anyInt())).thenReturn(Optional.of(student24));

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

        student9.setAge(23);
        student9.setCountry("INDIA");
        student9.setName("Accio");
        student9.setEmailId("accio@gmail.com");
        doAnswer((test) -> {
            card9.setCardStatus(DEACTIVATED);
            return null;
        }).when(cardRepository3).deactivateCard(student9.getId(),
                DEACTIVATED.toString());

    }


    @Test
    public void testIssueBookWhenBookNotAvailable(){
        try{
            transactionService5.issueBook(1, 2);
        }
        catch (Exception e){
            assert(e.getMessage().equals("Book is either unavailable or not present"));
        }
    }

    @Test
    public void testIssueBookWhenCardNotActivated(){
        try{
            transactionService5.issueBook(2, 1);
        }
        catch (Exception e){
            assert(e.getMessage().equals("Card is invalid"));
        }
    }

    @Test
    public void testIssueBookWhenCardLimitExceeds(){
        try{
            transactionService5.issueBook(3, 1);
        }
        catch (Exception e){
            assert(e.getMessage().equals("Book limit has reached for this card"));
        }
    }

    @Test
    public void testIssueBookWhenTransactionSuccessful(){
        String transactionId = null;
        try{
            transactionId = transactionService5.issueBook(1, 1);
        }
        catch (Exception e){
            assert (e == null);
        }
        assertNotNull(transactionId);
    }

    @Test
    public void testReturnBook(){
        Transaction transaction = null;
        try{
            transaction = transactionService5.returnBook(1, 1);
        }
        catch (Exception e){
            assert (e == null);
        }
        assertNotNull(transaction);
        assert(transaction.getFineAmount()==10);
    }

    @Test
    public void testGetDetails(){
        String email = "1@gmail.com";
        Student student = studentService4.getDetailsByEmail(email);
        assert((student.getEmailId()=="1@gmail.com") && (student.getName()=="1") && (student.getAge()==1) && (student.getCountry()=="India"));
    }

    @Test
    public void testGetDetailsById(){
        Integer id = students4.get(1).getId();
        Student student = studentService4.getDetailsById(id);
        assert(student.getId()==id);
    }

    @Test
    public void testCreateStudent(){
        Student student = students4.get(3);
        studentService4.createStudent(student);
    }

    @Test
    public void testUpdateStudent(){
        Student student = students4.get(2);
        studentService4.updateStudent(student);
    }

    @Test
    public void testDeleteStudent(){
        Integer id = students4.get(0).getId();
        studentService4.deleteStudent(id);
    }

    @Test
    public void testCreateAndReturn(){
        Card card = cardService3.createAndReturn(student9);
        assert(card.getCardStatus() == ACTIVATED);
        assert(card.getStudent() == student9);
    }

    @Test
    public void testDeactivateCard(){
        cardService3.deactivateCard(student9.getId());
        assert(card9.getCardStatus() == DEACTIVATED);
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
    public void testCreate(){
        authorService1.create(new Author("1", "1@gmail.com", 21, "India"));
    }
}
