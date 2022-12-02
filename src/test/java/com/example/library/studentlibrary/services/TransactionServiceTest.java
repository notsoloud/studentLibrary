//package com.example.library.studentlibrary.services;
//
//import com.example.library.studentlibrary.models.*;
//import com.example.library.studentlibrary.repositories.BookRepository;
//import com.example.library.studentlibrary.repositories.CardRepository;
//import com.example.library.studentlibrary.repositories.TransactionRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import static org.junit.Assert.assertNotNull;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class TransactionServiceTest {
//    @InjectMocks TransactionService transactionService5;
//
//    @Mock
//    BookRepository bookRepository5;
//
//    @Mock
//    CardRepository cardRepository5;
//
//    @Mock
//    TransactionRepository transactionRepository5;
//
//    @Before
//    public void setUp(){
//
//        transactionService5.max_allowed_books = 1;
//        transactionService5.getMax_allowed_days = 3;
//        transactionService5.fine_per_day = 5;
//
//        Author author15 = new Author("1", "1@gmail.com", 23, "INDIA");
//        Author author25 = new Author("2", "2@gmail.com", 47, "USA");
//
//        Book book15 = new Book("A", Genre.FICTIONAL, author15);
//        Book book25 = new Book("B", Genre.PHYSICS, author15);
//        Book book35 = new Book("C", Genre.PHYSICS, author25);
//
//        book25.setAvailable(Boolean.FALSE);
//
//        Card card15 = new Card();
//        card15.setBooks(new ArrayList<>());
//        Card card25 = new Card();
//        card25.setCardStatus(CardStatus.DEACTIVATED);
//        Card card35 = new Card();
//        List<Book> booksOnCard35 = new ArrayList<>();
//        booksOnCard35.add(book35);
//        card35.setBooks(booksOnCard35);
//
//        when(bookRepository5.findById(1)).thenReturn(Optional.of(book15));
//        when(bookRepository5.findById(2)).thenReturn(Optional.of(book25));
//        //when(bookRepository2.findById(3)).thenReturn(null);
//
//        when(cardRepository5.findById(1)).thenReturn(Optional.of(card15));
//        when(cardRepository5.findById(2)).thenReturn(Optional.of(card25));
//        when(cardRepository5.findById(3)).thenReturn(Optional.of(card35));
//        //when(cardRepository3.findById(4)).thenReturn(null);
//
//        Transaction transaction5 = new Transaction();
//        transaction5.setBook(book15);
//        transaction5.setCard(card15);
//        transaction5.setTransactionStatus(TransactionStatus.SUCCESSFUL);
//        transaction5.setIssueOperation(Boolean.TRUE);
//        Integer daysAfterTransaction = 5;
//        Integer millisAfterTransaction = daysAfterTransaction * 86400000;
//        transaction5.setTransactionDate(new Date(System.currentTimeMillis() - millisAfterTransaction));
//
//        List<Transaction> transactions5 = new ArrayList<>();
//        transactions5.add(transaction5);
//
//        when(transactionRepository5.find(1, 1, TransactionStatus.SUCCESSFUL, true)).thenReturn(transactions5);
//    }
//
//    @Test
//    public void testIssueBookWhenBookNotAvailable(){
//        try{
//            transactionService5.issueBook(1, 2);
//        }
//        catch (Exception e){
//            assert(e.getMessage().equals("Book is either unavailable or not present"));
//        }
//    }
//
//    @Test
//    public void testIssueBookWhenCardNotActivated(){
//        try{
//            transactionService5.issueBook(2, 1);
//        }
//        catch (Exception e){
//            assert(e.getMessage().equals("Card is invalid"));
//        }
//    }
//
//    @Test
//    public void testIssueBookWhenCardLimitExceeds(){
//        try{
//            transactionService5.issueBook(3, 1);
//        }
//        catch (Exception e){
//
//            assert(e.getMessage().equals("Book limit has reached for this card"));
//        }
//    }
//
//    @Test
//    public void testIssueBookWhenTransactionSuccessful(){
//        String transactionId = null;
//        try{
//            transactionId = transactionService5.issueBook(1, 1);
//        }
//        catch (Exception e){
//            assert (e == null);
//        }
//        assertNotNull(transactionId);
//    }
//
//    @Test
//    public void testReturnBook(){
//        Transaction transaction = null;
//        try{
//            transaction = transactionService5.returnBook(1, 1);
//        }
//        catch (Exception e){
//            assert (e == null);
//        }
//        assertNotNull(transaction);
//        assert(transaction.getFineAmount()==10);
//    }
//}
