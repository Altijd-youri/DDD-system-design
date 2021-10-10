package weatherEvent.port.adapter.http.rest;

import account.domain.User;
import account.port.adapter.http.rest.UserRestService;

public class WeatherEventService {
    UserRestService userRestService = new UserRestService();

    public User getUserOfID(String userID){
        return userRestService.getUserOfID(userID);
    }
}
