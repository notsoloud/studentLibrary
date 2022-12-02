//package com.example.library.studentlibrary.services;
//
//import com.example.library.studentlibrary.models.Card;
//import com.example.library.studentlibrary.models.Student;
//import com.example.library.studentlibrary.repositories.CardRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import static com.example.library.studentlibrary.models.CardStatus.*;
//import static org.mockito.Mockito.*;
//
//@RunWith(MockitoJUnitRunner.class)
//public class CardServiceTest {
//    @InjectMocks CardService cardService3;
//
//    @Mock
//    CardRepository cardRepository3;
//
//    Student student9 = new Student();
//    Card card9 = new Card();
//    @Before
//    public void setUp(){
//        student9.setAge(23);
//        student9.setCountry("INDIA");
//        student9.setName("Accio");
//        student9.setEmailId("accio@gmail.com");
//        doAnswer((test) -> {
//            card9.setCardStatus(DEACTIVATED);
//            return null;
//        }).when(cardRepository3).deactivateCard(student9.getId(),
//                DEACTIVATED.toString());
//
//    }
//
//    @Test
//    public void testCreateAndReturn(){
//        Card card = cardService3.createAndReturn(student9);
//        assert(card.getCardStatus() == ACTIVATED);
//        assert(card.getStudent() == student9);
//    }
//
//    @Test
//    public void testDeactivateCard(){
//        cardService3.deactivateCard(student9.getId());
//        assert(card9.getCardStatus() == DEACTIVATED);
//    }
//}
