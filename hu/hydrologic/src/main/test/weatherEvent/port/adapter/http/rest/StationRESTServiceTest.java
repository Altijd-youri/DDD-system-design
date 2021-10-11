package weatherEvent.port.adapter.http.rest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StationRESTServiceTest {

    @Test
    public void weatherEventOnStation() {
       StationRESTService restService = new StationRESTService();

        List<List<String>> measurements = new ArrayList<>();
        List<String> measurement = new ArrayList<>();
        measurement.add("10");
        measurement.add("mm");
        measurements.add(measurement);

        restService.weatherEventOnStation("test1","test1Station", measurements);
    }
}