package weatherEvent.domain;

public interface WeatherEventRepository {
    WeatherEvent get(WeatherEventID id);
    boolean update(WeatherEvent updateEvent);
    boolean store(WeatherEvent event);
}
