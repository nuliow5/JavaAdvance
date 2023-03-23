package eu.codeacademy.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.instrument.IllegalClassFormatException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {
    private BankAccount bankAccount = new BankAccount();

    @BeforeEach //kvieciamas prie kiekviena testa
    void setUp(){
        System.out.println("Set up log");
        bankAccount = new BankAccount();
    }

    @Test
    void createEmptyConstructor(){
        Double balanceValue = bankAccount.getBalance();
        assertEquals(balanceValue, 0.0);
    }

    @Test
    void drawAmount() throws IllegalClassFormatException {
        bankAccount.deposit(10.15);
        Double balanceValue = bankAccount.getBalance();
        assertEquals(balanceValue, 10.15);
    }
    @Test
    void drawAmountMinusValue() throws IllegalClassFormatException {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.deposit(-5.5);
        });
    }

    @Test
    void withdraw() throws IllegalClassFormatException {
        bankAccount.deposit(10.0);
        bankAccount.withdraw(7.0);

        assertEquals(bankAccount.getBalance(), 3);


    }



}
