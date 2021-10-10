package weatherEvent.Application;

import weatherEvent.domain.Measurement;

import java.util.List;
import java.util.UUID;

public class WeatherEventApplicationService {

    public UUID newWeatherEvent(UUID Uid, double longitude, double latitude, List<Measurement> measurements) {
        // Should be implemented by Milan, StationApplicationService (by Youri) depends on this implementation.
        return UUID.fromString("mocked UUID, while not implemented.");
    }
}
