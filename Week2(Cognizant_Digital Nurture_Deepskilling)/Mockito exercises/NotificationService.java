public class NotificationService {
    private final EmailClient emailClient;

    public NotificationService(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    public String notifyUser(String userEmail) {
        boolean status = emailClient.sendEmail(userEmail, "Welcome", "Thanks for signing up!");

        return status ? "Notification Sent" : "Failed to Send Notification";
    }
}
