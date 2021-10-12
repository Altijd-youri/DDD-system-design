package weatherEvent.port.adapter.http.rest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StationRestServiceTestYouri {
    @Test
    public void weatherEventOnStation() {
        StationRestService restService = new StationRestService();

        List<List<String>> measurements = new ArrayList<>();
        List<String> measurement = new ArrayList<>();
        measurement.add("10");
        measurement.add("mm");
        measurements.add(measurement);

        restService.weatherEventOnStation("test1","test1Station", measurements);
    }
}
