import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TemperatureConverterTest {

    TemperatureConverter converter = new TemperatureConverter();

    @Test
    void checkCelsiusToFahrenheit() {
        double result = converter.celsiusToFahrenheit(0);
        assertEquals(32.0, result, 0.001);
    }

    @Test
    void checkFahrenheitToCelsius() {
        double result = converter.fahrenheitToCelsius(98.6);
        assertEquals(37.0, result, 0.01);
    }

    @Test
    void checkNegativeTemperatureConversion() {
        double result = converter.celsiusToFahrenheit(-40);
        assertEquals(-40.0, result, 0.001);  // -40°C = -40°F
    }
}
