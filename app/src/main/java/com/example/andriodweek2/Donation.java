package com.example.andriodweek2;

public class Donation {
    double amount;
    int paymentMethod;//0 for paypal and 1 for credit

    public Donation(double amount, int pmt_method) {
        this.amount = amount;
        this.paymentMethod = pmt_method;
    }
}
