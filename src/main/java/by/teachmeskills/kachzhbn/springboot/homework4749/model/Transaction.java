package by.teachmeskills.kachzhbn.springboot.homework4749.model;

public class Transaction {
    private long creditCardFrom;
    private long creditCardTo;
    private double money;

    public Transaction() {
    }

    public Transaction(long creditCardFrom, long creditCardTo, double money) {
        this.creditCardFrom = creditCardFrom;
        this.creditCardTo = creditCardTo;
        this.money = money;
    }

    public long getCreditCardFrom() {
        return creditCardFrom;
    }

    public void setCreditCardFrom(long creditCardFrom) {
        this.creditCardFrom = creditCardFrom;
    }

    public long getCreditCardTo() {
        return creditCardTo;
    }

    public void setCreditCardTo(long creditCardTo) {
        this.creditCardTo = creditCardTo;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
