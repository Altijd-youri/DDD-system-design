package weatherEvent.port.adapter.persistence;

import weatherEvent.domain.UserID;
import weatherEvent.domain.WeatherEvent;
import weatherEvent.domain.WeatherEventRepository;

public class WeatherEventRepositoryImpl implements WeatherEventRepository {
    @Override
    public WeatherEvent createNewEventByUserId(UserID Uid) {
        return new WeatherEvent(Uid);
    }
}
