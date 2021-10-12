package weatherEvent.port.adapter.http.rest;

import weatherEvent.application.WeatherEventApplicationService;
import weatherEvent.domain.*;

import java.util.ArrayList;
import java.util.List;

public class WeatherEventRestService {
    WeatherEventApplicationService weatherEventApplicationService = new WeatherEventApplicationService();

    public WeatherEventID newWeatherEvent(String Uid, String longitude, String latitude, List<List<String>> measurements) {
        return weatherEventApplicationService.newWeatherEvent(Uid, Double.parseDouble(longitude), Double.parseDouble(latitude), measurements);
    }

    public WeatherEventID newWeatherEvent(String Uid, String longitude, String latitude) {
        return newWeatherEvent(Uid, longitude, latitude, new ArrayList<>());
    }

    public void addPicture(String uid, String description, Byte[] image, WeatherEventID weatherEventID) throws Exception{
        weatherEventApplicationService.addPicture(uid, description, image, weatherEventID);
    }
}
