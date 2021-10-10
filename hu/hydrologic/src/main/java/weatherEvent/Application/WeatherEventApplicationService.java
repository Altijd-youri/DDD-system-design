package weatherEvent.Application;

import weatherEvent.domain.*;
import weatherEvent.port.adapter.persistence.MemoryWeatherEventRepository;

import java.util.Date;
import java.util.List;

public class WeatherEventApplicationService {
    WeatherEventRepository weatherEventRepository = new MemoryWeatherEventRepository();

    public WeatherEventID newWeatherEvent(UserID Uid, double longitude, double latitude, List<Measurement> measurements) {
        Date currDate = new Date();
        WeatherEventID eventID = new WeatherEventID(currDate, Uid);
        WeatherEvent event = new WeatherEvent(eventID, Uid, measurements, new Location(longitude, latitude), currDate);
        weatherEventRepository.store(event);
        return event.getId();
    }
}
