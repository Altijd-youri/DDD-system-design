package weatherEvent.port.adapter.http.rest;

import weatherEvent.Application.WeatherEventApplicationService;
import weatherEvent.domain.Measurement;
import weatherEvent.domain.MeasurementUnit;
import weatherEvent.domain.UserID;
import weatherEvent.domain.WeatherEventID;

import java.util.ArrayList;
import java.util.List;

public class WeatherEventRESTService {
    WeatherEventApplicationService weatherEventApplicationService = new WeatherEventApplicationService();

    public WeatherEventID newWeatherEvent(String Uid, String longitude, String latitude, List<List<String>> measurements) {
        return weatherEventApplicationService.newWeatherEvent(Uid, Double.parseDouble(longitude), Double.parseDouble(latitude), measurements);
    }

    public WeatherEventID newWeatherEvent(String Uid, String longitude, String latitude) {
        return newWeatherEvent(Uid, longitude, latitude, new ArrayList<>());
    }
}
