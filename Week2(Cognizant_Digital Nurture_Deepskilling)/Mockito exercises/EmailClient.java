public interface EmailClient {
    boolean sendEmail(String to, String subject, String body);
}
