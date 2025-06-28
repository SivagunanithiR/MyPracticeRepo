public class OrderService {
    private final PaymentGateway paymentGateway;

    public OrderService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String placeOrder(String userId, double amount) {
        if (amount <= 0) {
            return "Invalid Amount";
        }

        boolean result = paymentGateway.processPayment(userId, amount);

        return result ? "Order Placed" : "Payment Failed";
    }
}
