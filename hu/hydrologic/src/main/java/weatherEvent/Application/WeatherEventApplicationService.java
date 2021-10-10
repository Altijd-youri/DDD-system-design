package weatherEvent.Application;

import weatherEvent.domain.Measurement;
import weatherEvent.domain.UserID;
import weatherEvent.domain.WeatherEventIdentity;

import java.util.List;

public class WeatherEventApplicationService {

    public WeatherEventIdentity newWeatherEvent(UserID Uid, double longitude, double latitude, List<Measurement> measurements) {
        // Should be implemented by Milan, StationApplicationService (by Youri) depends on this implementation.
        return new WeatherEventIdentity("mocekd id, while not implemented");
    }
}