package weatherEvent.Domain;

import org.junit.jupiter.api.Test;
import weatherEvent.domain.Location;
import weatherEvent.domain.MeasurementStation;
import weatherEvent.domain.MeasurementStationIdentity;
import weatherEvent.domain.UserID;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class MeasurementStationTest {
    @Test
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
