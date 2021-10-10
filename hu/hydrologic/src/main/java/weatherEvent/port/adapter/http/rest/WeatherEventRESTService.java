package weatherEvent.port.adapter.http.rest;

import weatherEvent.Application.WeatherEventApplicationService;
import weatherEvent.domain.Measurement;
import weatherEvent.domain.UserID;
import weatherEvent.domain.WeatherEventID;

import java.util.List;

public class WeatherEventRESTService {
    WeatherEventApplicationService weatherEventApplicationService = new WeatherEventApplicationService();

    WeatherEventID newWeatherEvent(String Uid, String longitude, String latitude, List<Measurement> measurements) {
        return weatherEventApplicationService.newWeatherEvent(new UserID(Uid), Double.parseDouble(longitude), Double.parseDouble(latitude), measurements);
    }
}
