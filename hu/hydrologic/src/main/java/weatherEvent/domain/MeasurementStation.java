package weatherEvent.domain;

import java.util.Date;
import java.util.Set;

public class MeasurementStation {
    private MeasurementStationIdentity id;
    private Date lastCalibratedAt;
    private Location location;
    private String name;

    /**
     * Creates a measurement station
     * @param id
     * @param lastCalibratedAt
     * @param location
     * @param name
     * @throws Exception - Throws exception if lastCalibratedAt is longer than 1 year ago.
     */
    public MeasurementStation(MeasurementStationIdentity id, Date lastCalibratedAt, Location location, String name) throws Exception{
        Date currentDate = new Date();
        final long millisecondsInAYear = 31557600000L;

        if(currentDate.getTime() - lastCalibratedAt.getTime() > millisecondsInAYear) {
            throw new Exception("Last calibration time can't be longer than 1 year ago");
        }

        this.id = id;
        this.location = location;
        this.name = name;
    }
}
