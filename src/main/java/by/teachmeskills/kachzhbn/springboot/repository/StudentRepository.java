package by.teachmeskills.kachzhbn.springboot.repository;

import by.teachmeskills.kachzhbn.springboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    //Получение списка студентов из группы (по номеру группы)
    List<Student> findAllByUniversityGroup(String universityGroup);

    List<Student> findByCourseIsPaidIsFalse();

    Optional<Student> findStudentByFirstName(String firstName);
    Optional<Student> findStudentByLastName(String lastName);

    void deleteStudentById(Long id);

}
