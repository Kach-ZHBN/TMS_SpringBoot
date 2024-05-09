package by.teachmeskills.kachzhbn.springboot.homework4749.model;

import jakarta.persistence.*;

@Entity
@Table(name = "credit_card")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private Long number;

    @Column(name = "valid_thru")
    private String validThru;

    @Column(name = "money")
    private double money;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client cardHolder;

    public CreditCard() {
    }

    public CreditCard(Long number, String validThru, int money, Client cardHolder) {
        this.number = number;
        this.validThru = validThru;
        this.money = money;
        this.cardHolder = cardHolder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Client getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(Client cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getValidThru() {
        return validThru;
    }

    public void setValidThru(String validThru) {
        this.validThru = validThru;
    }
}
