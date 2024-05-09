package by.teachmeskills.kachzhbn.springboot.homework4749.repository;

import by.teachmeskills.kachzhbn.springboot.homework4749.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findClientByName(String name);

}
