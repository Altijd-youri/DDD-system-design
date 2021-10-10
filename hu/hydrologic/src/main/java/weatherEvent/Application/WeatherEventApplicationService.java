package weatherEvent.Application;

import weatherEvent.domain.*;
import weatherEvent.port.adapter.persistence.WeatherEventRepositoryImpl;

import java.util.List;

public class WeatherEventApplicationService {
    WeatherEventRepository weatherEventRepository = new WeatherEventRepositoryImpl();

    public WeatherEventID newWeatherEvent(UserID Uid, double longitude, double latitude, List<Measurement> measurements) {
        WeatherEvent event = weatherEventRepository.createNewEventByUserId(Uid);

        // Should be implemented by Milan, StationApplicationService (by Youri) depends on this implementation.
        //return UserID.fromString("mocked UUID, while not implemented.");
        return event.getId();
    }
}
