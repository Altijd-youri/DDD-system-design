package weatherEvent.port.adapter.http.rest;

import weatherEvent.application.WeatherEventApplicationService;

public class WeatherEventRestService {
    WeatherEventApplicationService weatherEventApplicationService = new WeatherEventApplicationService();

    public void userAddPicture(String userID, Byte[] picture, String description){
        weatherEventApplicationService.userAddPicture(userID, picture, description);
    }
}
