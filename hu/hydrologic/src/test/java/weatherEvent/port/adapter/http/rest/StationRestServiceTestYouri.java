package weatherEvent.port.adapter.http.rest;

import account.domain.*;
import account.port.adapter.persistence.MemoryUserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import weatherEvent.domain.Location;
import weatherEvent.domain.MeasurementStation;
import weatherEvent.domain.MeasurementStationID;
import weatherEvent.domain.MeasurementStationRepository;
import weatherEvent.port.adapter.persistence.MemoryMeasurementStationRepository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StationRestServiceTestYouri {
    private static StationRestService restService;
    private static MeasurementStationRepository stationRepository;

    @BeforeAll
    void setup() {
        UserRepository repository = new MemoryUserRepository();
        stationRepository = new MemoryMeasurementStationRepository();

        //Setup test user
        User user = new User(new account.domain.UserID("1"), new CompanyID("1"), new Email("user1@test.com"), Role.EMPLOYEE, "John", "Doe");
        repository.store(user);
        user = new User(new account.domain.UserID("2"), new CompanyID("1"), new Email("user2@test.com"), Role.EMPLOYEE, "Jane", "Doe");
        repository.store(user);

        //Setup
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -2);
        Location location = new Location(52.00,4.0);

        try {
            MeasurementStation station = new MeasurementStation(new weatherEvent.domain.UserID("1"),new MeasurementStationID("sm1"),calendar.getTime(), location, "StationOne");
            stationRepository.store(station);

            station = new MeasurementStation(new weatherEvent.domain.UserID("2"),new MeasurementStationID("sm2"),calendar.getTime(), location, "StationTwo");
            stationRepository.store(station);
        } catch (Exception e) {
            throw new RuntimeException("Test setup failed: Could not create measurementStation");
        }

        restService = new StationRestService();
    }

    @Test
    @DisplayName("Add correct WeatherEvent.")
    public void addWeatherEvent_CorrectWay() {
        List<List<String>> measurements = getMeasurements(2);

        try {
            restService.weatherEventOnStation("1", "sm1", measurements);
        } catch (Exception e) {
            fail("Station could not be added: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Add weatherEvent to Station not owned by user.")
    public void addWeatherEvent_NotOwnedStation() {
        List<List<String>> measurements = getMeasurements(1);

        assertThrows(Exception.class,
                () -> restService.weatherEventOnStation("1", "sm2", measurements),
                "Station doesn't exists.");
    }

    @Test
    @DisplayName("Add weatherEvent to station with invalid user.")
    public void addWeatherEvent_InvalidUserId() {
        List<List<String>> measurements = getMeasurements(1);

        assertThrows(Exception.class,
                () -> restService.weatherEventOnStation("3", "sm1", measurements),
                "User doesn't exist");
    }

    @Test
    @DisplayName("Add weatherEvent to station with invalid stationId.")
    public void addWeatherEvent_InvalidStationId() {
        List<List<String>> measurements = getMeasurements(1);

        assertThrows(Exception.class,
                () -> restService.weatherEventOnStation("1", "sm3_invalid", measurements),
                "Station doesn't exists.");

    }

    @Test
    @DisplayName("Add weatherEvent to badly calibrated station.")
    public void addWeatherEvent_BadlyCalibrated() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);
        Location location = new Location(52.00,4.0);
        try {
            MeasurementStation station = new MeasurementStation(new weatherEvent.domain.UserID("1"),new MeasurementStationID("sm3_old"),calendar.getTime(), location, "StationThree_badlyCalibrated");
            stationRepository.store(station);
        } catch (Exception e) {
            fail("Test setup failed: Could not create measurementStation");
        }

        List<List<String>> measurements = getMeasurements(1);

        assertThrows(Exception.class,
                () -> restService.weatherEventOnStation("1", "sm3_old", measurements),
                "Last calibration time can't be longer than 1 year ago");
    }

    private List<List<String>> getMeasurements(int numberOfMeasurements) {
        List<List<String>> measurements = new ArrayList<>();
        for (int i = 0; i <= numberOfMeasurements; i++) {
            List<String> measurement = new ArrayList<>();
            measurement.add("10");
            measurement.add("mm");
            measurements.add(measurement);
        }
        return measurements;
    }
}
