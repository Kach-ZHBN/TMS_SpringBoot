package by.teachmeskills.kachzhbn.springboot.homework4749.service;

import by.teachmeskills.kachzhbn.springboot.homework4749.model.CreditCard;
import by.teachmeskills.kachzhbn.springboot.homework4749.model.TransactionStatus;
import by.teachmeskills.kachzhbn.springboot.homework4749.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreditCardService {

    private final CreditCardRepository creditCardRepository;

    @Autowired
    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public CreditCard getCreditCardByNumber(long creditCardNumber) {
        return creditCardRepository.findCreditCardByNumber(creditCardNumber);
    }

    @Transactional
    public TransactionStatus transferMoney(long creditCardNumberFrom, long creditCardNumberTo, double money) {

        TransactionStatus transactionStatus;

        CreditCard creditCardFrom = creditCardRepository.findCreditCardByNumber(creditCardNumberFrom);
        CreditCard creditCardTo = creditCardRepository.findCreditCardByNumber(creditCardNumberTo);
        if (creditCardFrom == null) {
            transactionStatus = TransactionStatus.FROM;
        } else if (creditCardTo == null) {
            transactionStatus = TransactionStatus.TO;
        } else if (creditCardFrom.getMoney() < money) {
            transactionStatus = TransactionStatus.MONEY;
        } else {
            creditCardFrom.setMoney(creditCardFrom.getMoney() - money);
            creditCardTo.setMoney(creditCardTo.getMoney() + money);
            transactionStatus = TransactionStatus.OK;
        }
        return transactionStatus;
    }
}
