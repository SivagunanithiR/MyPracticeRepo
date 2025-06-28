public interface PaymentGateway {
    boolean processPayment(String userId, double amount);
}
