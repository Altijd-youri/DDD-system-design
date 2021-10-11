package weatherEvent.application;

import weatherEvent.domain.*;
import weatherEvent.port.adapter.persistence.MemoryWeatherEventRepository;
import weatherEvent.port.adapter.services.CollaborationService;

import java.util.Date;
import java.util.List;

public class WeatherEventApplicationService {
    WeatherEventRepository weatherEventRepository = new MemoryWeatherEventRepository();

    public WeatherEventID newWeatherEvent(UserID Uid, double longitude, double latitude, List<Measurement> measurements) {
        Date currDate = new Date();
        WeatherEventID eventID = new WeatherEventID(currDate, Uid);
        WeatherEvent event = new WeatherEvent(eventID, Uid, measurements, new Location(longitude, latitude), currDate);
        weatherEventRepository.store(event);
        return event.getId();
    }


    public void addPicture(String uid, String description, Byte[] image, WeatherEventID weatherEventID) {
        CollaborationService collaborationService = new CollaborationService();
        if (collaborationService.userExists(new UserID(uid))){
            if (weatherEventRepository.get(weatherEventID)!=null) {
                WeatherEvent event = weatherEventRepository.get(weatherEventID);
                event.addPicture(image, description);
                weatherEventRepository.update(event);
            }
        }
    }
}