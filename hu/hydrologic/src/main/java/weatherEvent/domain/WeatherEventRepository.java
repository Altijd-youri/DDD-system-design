package weatherEvent.domain;

public interface WeatherEventRepository {
    WeatherEvent createNewEventByUserId(UserID Uid);
}
