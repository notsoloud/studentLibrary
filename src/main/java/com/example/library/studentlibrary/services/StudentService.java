package com.example.library.studentlibrary.services;

import com.example.library.studentlibrary.models.Card;
import com.example.library.studentlibrary.models.Student;
import com.example.library.studentlibrary.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    CardService cardService4;

    @Autowired
    StudentRepository studentRepository4;

    public Student getDetailsByEmail(String email){
        return studentRepository4.findByEmailId(email);
    }

    public Student getDetailsById(int id){
        return studentRepository4.findById(id).get();
    }

    public void createStudent(Student student){
        Card newCard = cardService4.createAndReturn(student);
    }

    public void updateStudent(Student student){
        studentRepository4.updateStudentDetails(student);
    }

    public void deleteStudent(int id){
        cardService4.deactivateCard(id);
        studentRepository4.deleteCustom(id);
    }
}
