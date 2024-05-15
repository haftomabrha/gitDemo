package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
 @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent(){
        return studentRepository.findAll();

    }

    public void addNewStudent(Student student) {
    Optional<Student> studentOptional=
        studentRepository.findStudentsByEmail(student.getEmail());
    if(studentOptional.isPresent()){
        throw new IllegalStateException("email is taken");
    }
studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
     boolean exist=studentRepository.existsById(studentId);
     if(!exist){
         throw new IllegalStateException(studentId+" does not found");
     }
     studentRepository.deleteById(studentId);
    }
@Transactional
    public void updateStudent(
            Long studentId,
            String name,
            String email) {
     Student student=studentRepository.findById(studentId)
             .orElseThrow(()->new IllegalStateException(
                     studentId+" id for student does not eixst"
             ));
     if(name!=null&& !name.isEmpty() &&!Objects.equals(student.getName(),name)){
         student.setName(name);
     }
     if(email!=null&&!email.isEmpty()&&!Objects.equals(student.getEmail(),email)){
         student.setEmail(email);
     }

    }
}
