import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    // Singleton instance
    private static Logger instance;

    // Private constructor
    private Logger() {}

    // Thread-safe Singleton with lazy initialization
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Log method with timestamp
    public void log(String message) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("[" + timestamp + "] INFO: " + message);
    }
}
