package creditCardTest.jonathan.core;

import java.time.LocalDate;

public class CreditCard {

    private String cardNumber;//num tarjeta
    private String cardHolderName;//titular
    private LocalDate expirationDate;//fecha de expiracion
    private int cvv;//3 digitos detras de la targeta
    private double creditLimit;//limite de credito
    private double balance;//saldo

    public CreditCard(String cardNumber, String cardHolderName, LocalDate expirationDate, int cvv, double creditLimit) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.creditLimit = creditLimit;
        this.balance = 0.0;
    }

    public void isValid() {
        LocalDate currentDate = LocalDate.now();

        if (currentDate.isAfter(expirationDate))
            throw new IllegalArgumentException("La tarjeta ha expirado.");
    }

    public String charge(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Cantidad introducida no valida.");

        if (amount > (creditLimit - balance))
            throw new IllegalArgumentException("Limite de credito superado.");

        balance += amount;
        return ("Cantidad ingresada: $" + amount);
    }

    public String makePayment(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Cantidad introducida no valida.");

        if (amount > balance) 
            throw new IllegalArgumentException("No hay suficiente saldo.");

        balance -= amount;
        return ("Cantidad retirada: $" + amount);
    }

    public String toString() {
        String result = "Cardholder: " + cardHolderName + "\n" + "Card Number: " + cardNumber  + "\n" + "Expiration Date: " + expirationDate  + "\n" + "CVV: " + cvv  + "\n" + "Credit Limit: $" + creditLimit  + "\n" +"Balance: $" + balance;

        return result;
    }
}

