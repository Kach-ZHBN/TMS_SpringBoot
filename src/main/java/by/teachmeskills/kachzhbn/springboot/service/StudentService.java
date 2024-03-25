package by.teachmeskills.kachzhbn.springboot.service;

import by.teachmeskills.kachzhbn.springboot.model.Student;
import by.teachmeskills.kachzhbn.springboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
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

    //Метод для получения списка студентов из группы (по номеру группы)
    public List<Student> getStudentByGroup(String group){
        return studentRepository.findAllByUniversityGroup(group);
    }

    //Метод для получения студента по имени
    public Student getStudentByFirstName(String firstName){
        return studentRepository.findStudentByFirstName(firstName).orElse(null);
    }

    //Метод для получения студента по фамилии
    public Student getStudentByLastName(String lastName){
        return studentRepository.findStudentByLastName(lastName).orElse(null);
    }

    //Метод для получения студентов не оплативших курс
    public List<Student> getStudentsWherePaidIsFalse(){
        return studentRepository.findByCourseIsPaidIsFalse();
    }

    //Добавление нового студента
    public void createNewStudent(Student newStudent){
        studentRepository.save(newStudent);
    }

    //Метод для изменения информации о студенте
    public void updateStudent(Student student){
        studentRepository.save(student);
    }

    //Метод для перевода студента из одной группы в другую
    public void changeStudentGroup(Long id, String groupTo){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            Student updatedStudent = student.get();
            updatedStudent.setUniversityGroup(groupTo);
            studentRepository.save(updatedStudent);
        }else{
            throw new NoSuchElementException("Student with this id doesn't exist");
        }
    }

    //Метод для удаления студента
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
