package WeatherEvent.port.adapter.http.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import weatherEvent.domain.WeatherEventID;
import weatherEvent.port.adapter.http.rest.WeatherEventRESTService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherEventRestServiceTest {
    static WeatherEventRESTService restService;

    @BeforeEach
    public void weatherEventServiceInit() {
        this.restService = new WeatherEventRESTService();
    }

    @Test
    public void weatherEventSimpleHappyFlow() {
        List<List<String>> measurements = new ArrayList<>();
        List<String> measurement = new ArrayList<>();
        measurement.add("10");
        measurement.add("mm");
        measurements.add(measurement);
        measurement.add("14");
        measurement.add("ml");
        measurements.add(measurement);

        WeatherEventID eventID = restService.newWeatherEvent("test1", "20.0", "50.0", measurements);
        assertNotNull(eventID, "Created weather event is null, so an error has occurred during creation.");
    }

    @Test
    public void weatherEventIdConflict() {
        WeatherEventID eventID = restService.newWeatherEvent("test1", "20.0", "50.0");
        assertNotNull(eventID, "Created weather event is null, so an error has occurred during creation.");
    }
}
