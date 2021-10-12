package weatherEvent.port.adapter.http.rest;

import account.domain.*;
import account.port.adapter.persistence.MemoryUserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import weatherEvent.domain.Location;
import weatherEvent.domain.MeasurementStation;
import weatherEvent.domain.MeasurementStationIdentity;
import weatherEvent.domain.MeasurementStationRepository;
import weatherEvent.port.adapter.persistence.MemoryMeasurementStationRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StationRESTServiceTest {
    private static StationRESTService restService;
    private static MeasurementStationRepository stationRepository;

    @BeforeAll
    static void setup() {
        UserRepository repository = new MemoryUserRepository();
        stationRepository = new MemoryMeasurementStationRepository();
        User user = new User(new account.domain.UserID("1"), new CompanyID("1"), new Email("user1@test.com"), Role.EMPLOYEE, "John", "Doe");
        repository.store(user);
        restService = new StationRESTService();
    }

    @Test
    @DisplayName("Create a measurement station")
    public void createMeasurementStation() {
        try {
            MeasurementStationIdentity id = restService.create(
                    "1",
                    new Date(),
                    52.029421,
                    5.201923,
                    "Thermometer"
            );

            MeasurementStation ms = stationRepository.stationOfUserById(new weatherEvent.domain.UserID("1"), id.toString());
            assertNotNull(ms);
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    @DisplayName("Create a measurement station which has been calibrated almost a year ago")
    public void createMeasurementStationCalibrationMonthsAgo() {
        final long millisecondsInAYear = 31557600000L;
        final long millisecondsInADay = 1000 * 60 * 60 * 24;
        Date currentDate = new Date();
        Date dateYearAgoMinusADay = new Date(currentDate.getTime() - millisecondsInAYear + millisecondsInADay);

        try {
            MeasurementStationIdentity id = restService.create(
                    "1",
                    dateYearAgoMinusADay,
                    52.029421,
                    5.201923,
                    "Measurement station 1"
            );

            MeasurementStation ms = stationRepository.stationOfUserById(new weatherEvent.domain.UserID("1"), id.toString());
            assertNotNull(ms);
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    @DisplayName("User doesn't exist")
    public void createMeasurementStationUserNotExists() {
        assertThrows(Exception.class, () -> restService.create(
                "2",
                new Date(),
                52.029421,
                5.201923,
                "Measurement station 1"
        ), "User doesn't exist");
    }

    @Test
    @DisplayName("Collaboration to long ago")
    public void createMeasurementStationCalibrationToLangAgo() {
        final long millisecondsInAYear = 31557600000L;

        Date currentDate = new Date();
        Date dateYearAgo = new Date(currentDate.getTime() - millisecondsInAYear);

        assertThrows(Exception.class, () -> restService.create(
                "2",
                dateYearAgo,
                52.029421,
                5.201923,
                "Measurement station 1"
        ), "Last calibration time can't be longer than 1 year ago");
    }

    @Test
    @DisplayName("Generates new on every create")
    public void generatesNewIdOnCreate() {
        try {
            MeasurementStationIdentity msId1 = restService.create(
                    "1",
                    new Date(),
                    52.029421,
                    5.201923,
                    "Thermometer"
            );
            MeasurementStationIdentity msId2 = restService.create(
                    "1",
                    new Date(),
                    52.129421,
                    5.251923,
                    "Thermometer"
            );

            assertNotEquals(msId1, msId2);
        } catch(Exception e) {
            fail(e);
        }
    }
}