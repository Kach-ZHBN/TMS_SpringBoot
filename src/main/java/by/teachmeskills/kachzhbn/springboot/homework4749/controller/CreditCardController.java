package by.teachmeskills.kachzhbn.springboot.homework4749.controller;

import by.teachmeskills.kachzhbn.springboot.homework4749.model.CreditCard;
import by.teachmeskills.kachzhbn.springboot.homework4749.model.Transaction;
import by.teachmeskills.kachzhbn.springboot.homework4749.model.TransactionStatus;
import by.teachmeskills.kachzhbn.springboot.homework4749.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CreditCardController {
    CreditCardService creditCardService;

    @Autowired
    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping("/{number}")
    public ResponseEntity<CreditCard> getCreditCard(@PathVariable long number) {
        ResponseEntity<CreditCard> responseEntity;
        CreditCard creditCard = creditCardService.getCreditCardByNumber(number);
        if (creditCard == null) {
            responseEntity = ResponseEntity.notFound().build();
        } else {
            responseEntity = ResponseEntity.ok(creditCard);
        }
        return responseEntity;
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transferMoneyToCreditCard(@RequestBody Transaction transaction) {
        ResponseEntity<String> responseEntity;

        TransactionStatus transactionStatus = creditCardService.transferMoney(transaction.getCreditCardFrom(),
                transaction.getCreditCardTo(), transaction.getMoney());

        if (transactionStatus == TransactionStatus.FROM) {
            responseEntity = ResponseEntity.badRequest().body("Credit card FROM doesn't exist");
        } else if (transactionStatus == TransactionStatus.TO) {
            responseEntity = ResponseEntity.badRequest().body("Credit card TO doesn't exist");
        } else if (transactionStatus == TransactionStatus.MONEY) {
            responseEntity = ResponseEntity.badRequest().body("Not enough money");
        } else {
            responseEntity = ResponseEntity.ok("Ok");
        }

        return responseEntity;
    }
}
