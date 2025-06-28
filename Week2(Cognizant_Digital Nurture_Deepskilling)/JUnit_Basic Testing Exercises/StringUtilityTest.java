import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilityTest {

    StringUtility util = new StringUtility();

    @Test
    void testIsPalindromeWithValidInput() {
        assertTrue(util.isPalindrome("Madam"), "Should return true for palindrome");
        assertFalse(util.isPalindrome("Hello"), "Should return false for non-palindrome");
    }

    @Test
    void testIsPalindromeThrowsExceptionOnNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            util.isPalindrome(null);
        }, "Should throw exception for null input");
    }

    @Test
    void testCountWordsBasic() {
        assertEquals(5, util.countWords("JUnit makes testing in Java simple and effective"));
    }

    @Test
    void testCountWordsWithEmptyString() {
        assertEquals(0, util.countWords("   "));
    }

    @Test
    void testUtilityObjectNotNull() {
        assertNotNull(util, "Utility object should not be null");
    }
}
