import java.util.*;

public class FinancialForecast {

    // Simple Moving Average Forecast
    public static List<Double> simpleMovingAverageForecast(int[] data, int windowSize, int forecastPeriods) {
        List<Double> forecast = new ArrayList<>();

        for (int i = 0; i < forecastPeriods; i++) {
            double sum = 0;
            for (int j = data.length - windowSize + i; j < data.length + i; j++) {
                if (j < data.length) {
                    sum += data[j];
                } else {
                    sum += forecast.get(j - data.length); // use previous forecast
                }
            }
            forecast.add(sum / windowSize);
        }

        return forecast;
    }

    // Exponential Moving Average Forecast
    public static List<Double> exponentialMovingAverage(int[] data, double alpha, int forecastPeriods) {
        List<Double> forecast = new ArrayList<>();
        double ema = data[0]; // Initial EMA is first data point

        // Calculate EMA for historical data
        for (int i = 1; i < data.length; i++) {
            ema = alpha * data[i] + (1 - alpha) * ema;
        }

        // Forecast future values (they will remain constant in basic EMA)
        for (int i = 0; i < forecastPeriods; i++) {
            forecast.add(ema);
        }

        return forecast;
    }

    public static void main(String[] args) {
        int[] revenues = {12000, 12500, 12800, 12700, 13000, 13400, 13600, 14000};
        int windowSize = 3;
        int forecastPeriods = 3;

        System.out.println("📊 Simple Moving Average Forecast:");
        List<Double> smaForecast = simpleMovingAverageForecast(revenues, windowSize, forecastPeriods);
        for (int i = 0; i < smaForecast.size(); i++) {
            System.out.printf("Month %d forecast: %.2f\n", revenues.length + i + 1, smaForecast.get(i));
        }

        System.out.println("\n📈 Exponential Moving Average Forecast (α = 0.3):");
        List<Double> emaForecast = exponentialMovingAverage(revenues, 0.3, forecastPeriods);
        for (int i = 0; i < emaForecast.size(); i++) {
            System.out.printf("Month %d forecast: %.2f\n", revenues.length + i + 1, emaForecast.get(i));
        }
    }
}
