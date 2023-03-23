package eu.codeacademy.bank;

import java.lang.instrument.IllegalClassFormatException;

public class BankAccount {
    private Double balance;

    public BankAccount() {
        this.balance = 0.0;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void deposit(Double amount) throws IllegalClassFormatException {
        if (amount > 0) {
            this.balance += amount;
        } else {
            throw new IllegalArgumentException("bad input");
        }

    }

    public void withdraw(Double amount) throws IllegalClassFormatException {
        if (amount < this.balance) {
            this.balance -= amount;
        } else {
            throw new IllegalArgumentException("bad input");
        }

    }
}
