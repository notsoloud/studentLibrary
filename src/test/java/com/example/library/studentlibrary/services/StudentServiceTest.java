//package com.example.library.studentlibrary.services;
//
//import com.example.library.studentlibrary.models.Student;
//import com.example.library.studentlibrary.repositories.StudentRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class StudentServiceTest {
//    @InjectMocks StudentService studentService4;
//    @Mock
//    CardService cardService4;
//    @Mock
//    StudentRepository studentRepository4;
//
//    List<Student> students4 = new ArrayList<>();
//
//    @Before
//    public void setUp(){
//        Student student14 = new Student("1@gmail.com", "1", 1, "India");
//        Student student24 = new Student("2@gmail.com", "2", 2, "USA");
//        Student student34 = new Student("3@gmail.com", "3", 3, "UK");
//        Student student44 = new Student("4@gmail.com", "4", 4, "China");
//
//        students4.add(student14);
//        students4.add(student24);
//        students4.add(student34);
//        students4.add(student44);
//
//        when(studentRepository4.findByEmailId(anyString())).thenReturn(student14);
//        when(studentRepository4.findById(anyInt())).thenReturn(Optional.of(student24));
//    }
//
//    @Test
//    public void testGetDetails(){
//        String email = "1@gmail.com";
//        Student student = studentService4.getDetailsByEmail(email);
//        assert((student.getEmailId()=="1@gmail.com") && (student.getName()=="1") && (student.getAge()==1) && (student.getCountry()=="India"));
//    }
//
//    @Test
//    public void testGetDetailsById(){
//        Integer id = students4.get(1).getId();
//        Student student = studentService4.getDetailsById(id);
//        assert(student.getId()==id);
//    }
//
//    @Test
//    public void testCreateStudent(){
//        Student student = students4.get(3);
//        studentService4.createStudent(student);
//    }
//
//    @Test
//    public void testUpdateStudent(){
//        Student student = students4.get(2);
//        studentService4.updateStudent(student);
//    }
//
//    @Test
//    public void testDeleteStudent(){
//        Integer id = students4.get(0).getId();
//        studentService4.deleteStudent(id);
//    }
//}
