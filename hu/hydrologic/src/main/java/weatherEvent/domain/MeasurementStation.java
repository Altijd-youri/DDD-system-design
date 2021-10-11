package weatherEvent.domain;

import weatherEvent.port.adapter.services.CollaborationService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class MeasurementStation {
    private UserID owner;
    private MeasurementStationIdentity id;
    private List<WeatherEventID> events;
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
    public MeasurementStation(UserID owner, MeasurementStationIdentity id, Date lastCalibratedAt, Location location, String name) throws Exception{
        Date currentDate = new Date();
        final long millisecondsInAYear = 31557600000L;
        if(currentDate.getTime() - lastCalibratedAt.getTime() > millisecondsInAYear) {
            throw new Exception("Last calibration time can't be longer than 1 year ago");
        }

        CollaborationService collaborationService = new CollaborationService();
        if(!collaborationService.userExists(owner)) {
            throw new Exception("User doesn't exist");
        }

        this.id = id;
        this.owner = owner;
        this.location = location;
        this.name = name;
        this.lastCalibratedAt = lastCalibratedAt;
        this.events = new ArrayList<>();
    }

    public void addWeatherEvent(WeatherEventID event) {
        events.add(event);
    }

    public MeasurementStationIdentity getIdentity() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public boolean isOfOwner(UserID uid) {
        return this.owner.equals(uid);
    }
}
