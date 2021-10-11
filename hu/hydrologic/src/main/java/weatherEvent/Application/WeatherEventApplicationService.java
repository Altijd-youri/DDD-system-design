package weatherEvent.Application;

import weatherEvent.domain.*;
import weatherEvent.port.adapter.persistence.MemoryWeatherEventRepository;

import java.util.Date;
import java.util.List;

public class WeatherEventApplicationService {
    WeatherEventRepository weatherEventRepository = new MemoryWeatherEventRepository();

    // TODO: change to strings
    public WeatherEventID newWeatherEvent(UserID Uid, double longitude, double latitude, List<Measurement> measurements) {
        Date currDate = new Date();
        WeatherEventID eventID = new WeatherEventID(currDate, Uid);
        WeatherEvent event = new WeatherEvent(eventID, Uid, new Location(longitude, latitude), currDate);
        for (Measurement measurement : measurements) {
            event.addMeasurement(measurement);
        }
        if (!weatherEventRepository.store(event)) {
            return null;
        }
        return event.getId();
    }
}