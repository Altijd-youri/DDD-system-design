package weatherEvent.application;

import account.domain.User;
import account.domain.UserID;
import weatherEvent.domain.Picture;
import weatherEvent.domain.WeatherEvent;
import weatherEvent.domain.WeatherEventRepository;
import weatherEvent.port.adapter.persistence.FileWeatherEventRepository;

public class WeatherEventApplicationService {
    WeatherEventRepository weatherEventRepository;

    public void userAddPicture(String userID, Byte[] picture, String description){
        WeatherEvent weatherEvent = new WeatherEvent();
        weatherEvent.addPicture(picture, description, userID);
        weatherEventRepository.store(weatherEvent);
    }
}
