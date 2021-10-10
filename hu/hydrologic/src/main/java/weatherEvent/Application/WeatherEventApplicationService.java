package weatherEvent.Application;

import weatherEvent.domain.Measurement;
import weatherEvent.domain.UserID;

import java.util.List;

public class WeatherEventApplicationService {

    public UserID newWeatherEvent(UserID Uid, double longitude, double latitude, List<Measurement> measurements) {
        // Should be implemented by Milan, StationApplicationService (by Youri) depends on this implementation.
        return new UserID("mocekd id, while not implemented");
    }
}