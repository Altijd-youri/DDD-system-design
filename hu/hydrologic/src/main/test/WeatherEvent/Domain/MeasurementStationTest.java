package WeatherEvent.Domain;

import org.junit.Test;
import weatherEvent.domain.Location;
import weatherEvent.domain.MeasurementStation;
import weatherEvent.domain.MeasurementStationIdentity;

import java.util.Date;

public class MeasurementStationTest {
    @Test
    public void createMeasurementStation() {
        try {
            MeasurementStation measurementStation = new MeasurementStation(
                    new MeasurementStationIdentity(String.valueOf(1)),
                    new Date(),
                    new Location(52.029421, 5.201923),
                    "Measurement station 1"
            );
            org.junit.Assert.assertTrue(true);
        } catch(Exception ex) {
            org.junit.Assert.assertTrue(false);
        }
    }

    @Test
    public void createMeasurementStationCalibrationToLangAgo() {
        try {
            final long milliseondsInAYear = 31557600000L;

            Date currentDate = new Date();
            Date dateYearAgo = new Date(currentDate.getTime() - milliseondsInAYear);
            MeasurementStation measurementStation = new MeasurementStation(
                    new MeasurementStationIdentity(String.valueOf(1)),
                    dateYearAgo,
                    new Location(52.029421, 5.201923),
                    "Measurement station 1"
            );
            org.junit.Assert.assertTrue(false);
        } catch(Exception ex) {
            org.junit.Assert.assertTrue(true);
        }
    }
}
