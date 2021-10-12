package weatherEvent.port.adapter.http.rest;

import account.domain.UserID;
import account.domain.UserRepository;
import account.port.adapter.http.rest.UserRestService;
import org.junit.jupiter.api.*;
import weatherEvent.domain.WeatherEventID;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WeatherEventRestServiceTest {
    static WeatherEventRESTService weatherService;
    static UserRestService userService;

    static UserID testUser;

    @BeforeAll
    public void testInit() {
        this.weatherService = new WeatherEventRESTService();
        this.userService = new UserRestService();
        testUser = userService.makeUser("test-company", "WeatherEvents", "TestUser", "WeatherEventsTestUser@example.com");
        // TODO: Depending on how the user memory repository and JUnit work, this test user could be getting added multiple times. But this doesn't seem to return null, so probably fine?
    }

    @Test
    public void useCaseMakeSingleEvent() {
        List<List<String>> measurements = new ArrayList<>();
        List<String> firstMeasurement = new ArrayList<>();
        firstMeasurement.add("10");
        firstMeasurement.add("mm");
        measurements.add(firstMeasurement);
        List<String> secondMeasurement = new ArrayList<>();
        secondMeasurement.add("14");
        secondMeasurement.add("ml");
        measurements.add(secondMeasurement);
        WeatherEventID newEventId = weatherService.newWeatherEvent(testUser.toString(), "20.0", "50.0", measurements);
        assertNotNull(newEventId, "Created weather event id is null, likely failed to store it to the database.");
    }

    @Test
    public void useCaseMakeTwoEvents() {
        WeatherEventID firstEventID = weatherService.newWeatherEvent(testUser.toString(), "20.0", "50.0");
        assertNotNull(firstEventID, "Created weather event id is null, likely failed to store it to the database.");
    }

    @Test
    public void invalidUserId() {
        Exception thrownException = assertThrows(RuntimeException.class, () -> {
            WeatherEventID newEventId = weatherService.newWeatherEvent("invalid-user-id", "20.0", "50.0");
        }, "Didn't throw an exception when given an invalid UserId!");

        assertEquals(thrownException.getMessage(), "Given user doesn't exist!");
    }

    @Test
    public void invalidWeatherUnit() {
        List<List<String>> measurements = new ArrayList<>();
        List<String> measurement = new ArrayList<>();
        measurement.add("10");
        measurement.add("invalid-unit");
        measurements.add(measurement);
        Exception thrownException = assertThrows(RuntimeException.class, () -> {
            WeatherEventID newEventId = weatherService.newWeatherEvent(testUser.toString(), "20.0", "50.0", measurements);
        }, "Didn't throw an exception when given an invalid unit!");

        assertEquals(thrownException.getMessage(), "That's not a valid measurement unit and can't be converted to the correct representation.");
    }

    @Test
    public void negativeWeatherMeasurement() {
        List<List<String>> measurements = new ArrayList<>();
        List<String> measurement = new ArrayList<>();
        measurement.add("-10");
        measurement.add("ml");
        measurements.add(measurement);
        Exception thrownException = assertThrows(RuntimeException.class, () -> {
            WeatherEventID newEventId = weatherService.newWeatherEvent(testUser.toString(), "20.0", "50.0", measurements);
        }, "Didn't throw an exception when given a negative measurement!");

        assertEquals(thrownException.getMessage(), "Can't give measurements with negative values.");
    }
}
