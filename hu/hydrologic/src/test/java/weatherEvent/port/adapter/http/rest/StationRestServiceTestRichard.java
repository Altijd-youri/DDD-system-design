package weatherEvent.port.adapter.http.rest;

import account.domain.*;
import account.port.adapter.persistence.MemoryUserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import weatherEvent.domain.MeasurementStation;
import weatherEvent.domain.MeasurementStationID;
import weatherEvent.domain.MeasurementStationRepository;
import weatherEvent.port.adapter.persistence.MemoryMeasurementStationRepository;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StationRestServiceTestRichard {
    private static StationRestService restService;
    private static MeasurementStationRepository stationRepository;

    @BeforeAll
    void setup() {
        UserRepository repository = new MemoryUserRepository();
        stationRepository = new MemoryMeasurementStationRepository();
        User user = new User(new account.domain.UserID("1"), new CompanyID("1"), new Email("user1@test.com"), Role.EMPLOYEE, "John", "Doe");
        repository.store(user);
        restService = new StationRestService();
    }

    @Test
    @DisplayName("Create a measurement station")
    public void createMeasurementStation() {
        try {
            MeasurementStationID id = restService.create(
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
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);
        calendar.add(Calendar.DATE, 1);

        try {
            MeasurementStationID id = restService.create(
                    "1",
                    calendar.getTime(),
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
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);

        assertThrows(Exception.class, () -> restService.create(
                "2",
                calendar.getTime(),
                52.029421,
                5.201923,
                "Measurement station 1"
        ), "Last calibration time can't be longer than 1 year ago");
    }

    @Test
    @DisplayName("Generates new on every create")
    public void generatesNewIdOnCreate() {
        try {
            MeasurementStationID msId1 = restService.create(
                    "1",
                    new Date(),
                    52.029421,
                    5.201923,
                    "Thermometer"
            );
            MeasurementStationID msId2 = restService.create(
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