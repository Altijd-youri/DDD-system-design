package weatherEvent.port.adapter.persistence;

import weatherEvent.domain.UserID;
import weatherEvent.domain.WeatherEvent;
import weatherEvent.domain.WeatherEventID;
import weatherEvent.domain.WeatherEventRepository;

import java.util.ArrayList;
import java.util.List;

public class MemoryWeatherEventRepository implements WeatherEventRepository {
    private static final List<WeatherEvent> weatherEvents = new ArrayList<>();

    public WeatherEvent get(WeatherEventID id) {
        for (WeatherEvent event : weatherEvents) {
            if (event.getId().equals(id)) {
                return event;
            }
        }
        return null;
    }

    public boolean update(WeatherEvent updateEvent) {
        for (WeatherEvent event : weatherEvents) {
            if (event.getId().equals(updateEvent.getId())) {
                weatherEvents.remove(event);
                weatherEvents.add(updateEvent);
                return true;
            }
        }
        return false;
    }

    public boolean store(WeatherEvent event) {
        weatherEvents.add(event);
        return true;
    }
}
