package weatherEvent.domain;

import account.domain.*;
import account.port.adapter.persistence.MemoryUserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MeasurementStationTest {
    @BeforeAll
    void setup() {
        UserRepository repository = new MemoryUserRepository();
        User user = new User(new account.domain.UserID("1"), new CompanyID("1"), new Email("user1@test.com"), Role.EMPLOYEE, "John", "Doe");
        repository.store(user);
    }

    @Test
    @DisplayName("Create a measurement station")
    public void createMeasurementStation() {
        assertDoesNotThrow(() -> new MeasurementStation(
                new UserID("1"),
                new MeasurementStationID(String.valueOf(1)),
                new Date(),
                new Location(52.029421, 5.201923),
                "Measurement station 1"
        ));
    }

    @Test
    @DisplayName("Create a measurement station which has been calibrated almost a year ago")
    public void createMeasurementStationCalibrationMonthsAgo() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);
        calendar.add(Calendar.DATE, 1);

        assertDoesNotThrow(() -> new MeasurementStation(
                new UserID("1"),
                new MeasurementStationID(String.valueOf(1)),
                calendar.getTime(),
                new Location(52.029421, 5.201923),
                "Measurement station 1"
        ));
    }

    @Test
    @DisplayName("User doesn't exist")
    public void createMeasurementStationUserNotExists() {
        assertThrows(Exception.class, () -> new MeasurementStation(
                new UserID("2"),
                new MeasurementStationID(String.valueOf(1)),
                new Date(),
                new Location(52.029421, 5.201923),
                "Measurement station 1"
        ), "User doesn't exist");
    }

    @Test
    @DisplayName("Collaboration to long ago")
    public void createMeasurementStationCalibrationToLangAgo() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);
        calendar.add(Calendar.DATE, -1);
        assertThrows(Exception.class, () -> new MeasurementStation(
                new UserID("1"),
                new MeasurementStationID(String.valueOf(1)),
                calendar.getTime(),
                new Location(52.029421, 5.201923),
                "Measurement station 1"
        ), "Last calibration time can't be longer than 1 year ago.");
    }
}
