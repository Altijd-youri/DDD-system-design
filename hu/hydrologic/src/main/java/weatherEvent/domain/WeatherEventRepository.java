package weatherEvent.domain;

import account.domain.User;

public interface WeatherEventRepository {
    void store(WeatherEvent weatherEvent);
}
