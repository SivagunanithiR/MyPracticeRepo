import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class NotificationServiceTest {

    @Test
    void testNotifyUserSuccess() {
  
        EmailClient mockEmailClient = mock(EmailClient.class);
        when(mockEmailClient.sendEmail(anyString(), anyString(), anyString())).thenReturn(true);

        NotificationService service = new NotificationService(mockEmailClient);

   
        String result = service.notifyUser("user@example.com");

        // Assert
        assertEquals("Notification Sent", result);
        verify(mockEmailClient, times(1)).sendEmail("user@example.com", "Welcome", "Thanks for signing up!");
    }

    @Test
    void testNotifyUserFailure() {
        // Arrange
        EmailClient mockEmailClient = mock(EmailClient.class);
        when(mockEmailClient.sendEmail(anyString(), anyString(), anyString())).thenReturn(false);

        NotificationService service = new NotificationService(mockEmailClient);

        // Act
        String result = service.notifyUser("user@example.com");

        // Assert
        assertEquals("Failed to Send Notification", result);
        verify(mockEmailClient, times(1)).sendEmail(anyString(), anyString(), anyString());
    }
}
