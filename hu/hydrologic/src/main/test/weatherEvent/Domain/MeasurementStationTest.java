package weatherEvent.Domain;

import account.domain.*;
import account.port.adapter.persistence.MemoryUserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import weatherEvent.domain.Location;
import weatherEvent.domain.MeasurementStation;
import weatherEvent.domain.MeasurementStationIdentity;
import weatherEvent.domain.UserID;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class MeasurementStationTest {
    @BeforeAll
    static void setup() {
        UserRepository repository = new MemoryUserRepository();
        User user = new User(new account.domain.UserID("1"), new CompanyID("1"), new Email("user1@test.com"), Role.EMPLOYEE, "John", "Doe");
        repository.store(user);
    }

    @Test
    @DisplayName("Create a measurement station")
    public void createMeasurementStation() {
        assertDoesNotThrow(() -> new MeasurementStation(
                new UserID("1"),
                new MeasurementStationIdentity(String.valueOf(1)),
                new Date(),
                new Location(52.029421, 5.201923),
                "Measurement station 1"
        ));
    }

    @Test
    @DisplayName("Create a measurement station which has been calibrated almost a year ago")
    public void createMeasurementStationCalibrationMonthsAgo() {
        final long millisecondsInAYear = 31557600000L;
        final long millisecondsInADay = 1000 * 60 * 60 * 24;
        Date currentDate = new Date();
        Date dateYearAgoMinusADay = new Date(currentDate.getTime() - millisecondsInAYear + millisecondsInADay);


        assertDoesNotThrow(() -> new MeasurementStation(
                new UserID("1"),
                new MeasurementStationIdentity(String.valueOf(1)),
                dateYearAgoMinusADay,
                new Location(52.029421, 5.201923),
                "Measurement station 1"
        ));
    }

    @Test
    @DisplayName("User doesn't exist")
    public void createMeasurementStationUserNotExists() {
        assertThrows(Exception.class, () -> new MeasurementStation(
                new UserID("2"),
                new MeasurementStationIdentity(String.valueOf(1)),
                new Date(),
                new Location(52.029421, 5.201923),
                "Measurement station 1"
        ), "User doesn't exist");
    }

    @Test
    @DisplayName("Collaboration to long ago")
    public void createMeasurementStationCalibrationToLangAgo() {
        final long millisecondsInAYear = 31557600000L;

        Date currentDate = new Date();
        Date dateYearAgo = new Date(currentDate.getTime() - millisecondsInAYear);
        assertThrows(Exception.class, () -> new MeasurementStation(
                new UserID("1"),
                new MeasurementStationIdentity(String.valueOf(1)),
                dateYearAgo,
                new Location(52.029421, 5.201923),
                "Measurement station 1"
        ), "Last calibration time can't be longer than 1 year ago.");
    }
}
