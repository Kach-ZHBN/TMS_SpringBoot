package by.teachmeskills.kachzhbn.springboot.homework4749.repository;

import by.teachmeskills.kachzhbn.springboot.homework4749.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    CreditCard findCreditCardByNumber(long number);
}
