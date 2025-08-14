package service;

public interface PaymentMethod {
    void pay(int amount);
    String getName();
}
