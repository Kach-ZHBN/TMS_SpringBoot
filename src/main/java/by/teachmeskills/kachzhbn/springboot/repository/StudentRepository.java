package by.teachmeskills.kachzhbn.springboot.repository;

import by.teachmeskills.kachzhbn.springboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}
