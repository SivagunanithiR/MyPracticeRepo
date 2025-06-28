public class Main {
    public static void main(String[] args) {
        LoginService service = new LoginService();

        service.login("admin", "admin123");     // Should log INFO
        service.login("admin", "wrongpass");     // Should log ERROR
        service.login(null, null);               // Should log WARN
    }
}
