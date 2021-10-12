package weatherEvent.domain;

import weatherEvent.application.WeatherEventApplicationService;
import weatherEvent.port.adapter.services.CollaborationService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeasurementStation {
    WeatherEventApplicationService eventApplication = new WeatherEventApplicationService();
    private UserID owner;
    private MeasurementStationID id;
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
    public MeasurementStation(UserID owner, MeasurementStationID id, Date lastCalibratedAt, Location location, String name) throws Exception{
        checkLastCalibration(lastCalibratedAt);

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

    private void checkLastCalibration(Date lastCalibratedAt) throws Exception {
        Date currentDate = new Date();
        final long millisecondsInAYear = 31557600000L;
        if(currentDate.getTime() - lastCalibratedAt.getTime() > millisecondsInAYear) {
            throw new Exception("Last calibration time can't be longer than 1 year ago");
        }
    }

    public void addWeatherEvent(List<List<String>> measurements) throws Exception {
        checkLastCalibration(lastCalibratedAt);
        WeatherEventID wEventId = eventApplication.newWeatherEvent(owner.getId(), location.getLongitude(), location.getLatitude(), measurements);
        addWeatherEvent(wEventId);
    }

    public void addWeatherEvent(WeatherEventID event) {
        events.add(event);
    }

    public MeasurementStationID getIdentity() {
        return id;
    }

    public boolean isOwnedBy(UserID userID) {
        return owner.equals(userID);
    }
}
