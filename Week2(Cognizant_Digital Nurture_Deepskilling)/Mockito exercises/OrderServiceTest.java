import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    @Test
    void testPlaceOrderInvokesPaymentGateway() {
        // Arrange
        PaymentGateway mockGateway = mock(PaymentGateway.class);
        when(mockGateway.processPayment("user123", 100.0)).thenReturn(true);

        OrderService service = new OrderService(mockGateway);

        // Act
        String result = service.placeOrder("user123", 100.0);

        // Assert
        assertEquals("Order Placed", result);
        verify(mockGateway, times(1)).processPayment("user123", 100.0);
    }

    @Test
    void testPlaceOrderWithInvalidAmountDoesNotCallPayment() {
        // Arrange
        PaymentGateway mockGateway = mock(PaymentGateway.class);
        OrderService service = new OrderService(mockGateway);

        // Act
        String result = service.placeOrder("user123", -50);

        // Assert
        assertEquals("Invalid Amount", result);
        verify(mockGateway, never()).processPayment(anyString(), anyDouble());
    }
}
