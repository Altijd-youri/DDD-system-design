package weatherEvent.port.adapter.http.rest;

import weatherEvent.application.WeatherEventApplicationService;
import weatherEvent.domain.*;

import java.util.ArrayList;
import java.util.List;

public class WeatherEventRESTService {
    WeatherEventApplicationService weatherEventApplicationService = new WeatherEventApplicationService();

    public WeatherEventID newWeatherEvent(String Uid, String longitude, String latitude, List<List<String>> measurements) {
        List<Measurement> parsedMeasurements = new ArrayList<>();
        for (List<String> measurement : measurements) {
            parsedMeasurements.add(new Measurement(new MeasurementUnit(measurement.get(1)), Double.parseDouble(measurement.get(0))));
        }
        return weatherEventApplicationService.newWeatherEvent(new UserID(Uid), Double.parseDouble(longitude), Double.parseDouble(latitude), parsedMeasurements);
    }

    public void addPicture(String uid, String description, Byte[] image, WeatherEventID weatherEventID) throws Exception{
        weatherEventApplicationService.addPicture(uid, description, image, weatherEventID);
    }
}
