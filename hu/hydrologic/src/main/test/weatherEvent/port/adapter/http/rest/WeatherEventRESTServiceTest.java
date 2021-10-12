package weatherEvent.port.adapter.http.rest;

import account.domain.User;
import account.domain.UserRepository;
import account.port.adapter.persistence.MemoryUserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import weatherEvent.domain.UserID;
import weatherEvent.domain.WeatherEvent;
import weatherEvent.domain.WeatherEventID;
import weatherEvent.domain.WeatherEventRepository;
import weatherEvent.port.adapter.persistence.MemoryWeatherEventRepository;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class WeatherEventRESTServiceTest {
    static final UserRepository userRepository = new MemoryUserRepository();
    static final WeatherEventRESTService weatherEventRESTService = new WeatherEventRESTService();
    static final WeatherEventRepository weatherEventRepository = new MemoryWeatherEventRepository();
    static WeatherEventID weatherEventID;

    @BeforeAll
    static void beforeAll() {
        final Date currDate = new Date();
        weatherEventID = new WeatherEventID(currDate, new UserID("1"));
        final WeatherEvent weatherEvent = new WeatherEvent(weatherEventID, null,null, null, currDate);

        userRepository.store(new User(new account.domain.UserID("1"), null, null, null, null, null));
        weatherEventRepository.get(weatherEventID);
        weatherEventRepository.store(weatherEvent);
    }

    @Test
    void addPictureWeatherEventIsNull(){
        assertThrows(Exception.class, () -> weatherEventRESTService.addPicture("1", "hallo", null, new WeatherEventID(null, null)));
    }

    @Test
    void addPictureWeatherEventDoesNotExist(){
        final Date currDate = new Date();
        assertThrows(Exception.class, () -> weatherEventRESTService.addPicture("1", "hallo", null, new WeatherEventID(currDate, new UserID("2"))));
    }

    @Test
    void addPictureUserDoesNotExist(){
        assertThrows(Exception.class, () -> weatherEventRESTService.addPicture("2", "hallo", null, weatherEventID));
    }

    @Test
    void addPictureUserisNull(){
        assertThrows(Exception.class, () -> weatherEventRESTService.addPicture(null, "hallo", null, weatherEventID));
    }

    @Test
    void addPicture(){
        assertDoesNotThrow(() -> weatherEventRESTService.addPicture("1", "hallo", null, weatherEventID));
    }
}