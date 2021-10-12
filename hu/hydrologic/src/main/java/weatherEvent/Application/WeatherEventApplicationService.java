package weatherEvent.Application;

import weatherEvent.domain.*;
import weatherEvent.port.adapter.persistence.MemoryWeatherEventRepository;
import weatherEvent.port.adapter.services.CollaborationService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeatherEventApplicationService {
    CollaborationService collabService = new CollaborationService();
    WeatherEventRepository weatherEventRepository = new MemoryWeatherEventRepository();

    public WeatherEventID newWeatherEvent(String Uid, double longitude, double latitude, List<List<String>> measurements) {
        UserID userID = new UserID(Uid);
        if (!collabService.userExists(userID))
            throw new RuntimeException("Given user doesn't exist!");

        Date currDate = new Date();
        WeatherEventID eventID = new WeatherEventID(currDate, userID);
        WeatherEvent event = new WeatherEvent(eventID, userID, new Location(longitude, latitude), currDate);

        for (List<String> measurement : measurements) {
            Double value = Double.parseDouble(measurement.get(0));
            MeasurementUnit unit = new MeasurementUnit(measurement.get(1));

            Measurement newMeasurement = new Measurement(unit, value);
            event.addMeasurement(newMeasurement);
        }

        if (!weatherEventRepository.store(event)) {
            return null;
        }
        return event.getId();
    }
}