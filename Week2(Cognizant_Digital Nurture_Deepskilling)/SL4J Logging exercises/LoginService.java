import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    public boolean login(String username, String password) {
        logger.info("Login attempt for user: {}", username);

        if (username == null || password == null) {
            logger.warn("Username or password is null");
            return false;
        }

        if ("admin".equals(username) && "admin123".equals(password)) {
            logger.info("Login successful for user: {}", username);
            return true;
        } else {
            logger.error("Login failed for user: {}", username);
            return false;
        }
    }
}

