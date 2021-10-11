package weatherEvent.Application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import weatherEvent.port.adapter.http.rest.WeatherEventRESTService;

import java.util.ArrayList;
import java.util.List;

public class WeatherEventRESTServiceTest {
    static WeatherEventRESTService restService;

    @BeforeEach
    public void weatherEventServiceInit() {
        this.restService = new WeatherEventRESTService();
    }

    @Test
    public void weatherEventSimpleUseCase() {
        List<List<String>> measurements = new ArrayList<>();
        List<String> measurement = new ArrayList<>();
        measurement.add("10");
        measurement.add("mm");
        measurements.add(measurement);

        restService.newWeatherEvent("test1", "20.0", "50.0", measurements);
    }
}
