package by.teachmeskills.kachzhbn.springboot.service;

import by.teachmeskills.kachzhbn.springboot.model.Student;
import by.teachmeskills.kachzhbn.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, "id"));
    }

    public Student getStudentById(Long id){
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }

    public void createNewStudent(Student newStudent){
        studentRepository.save(newStudent);
    }

    public void updateStudent(Student student){
        studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
