package weatherEvent.domain;

import java.util.Set;

public class MeasurementStation {
    private UserID owner;
    private MeasurementStationIdentity id;
    private Set<WeatherEventIdentity> events;
    private Location location;
    private String name;

    public MeasurementStation(UserID owner, MeasurementStationIdentity id, Location location, String name) {
        this.owner = owner;
        this.id = id;
        this.location = location;
        this.name = name;
    }

    public void AddEvent(WeatherEventIdentity event) {
        events.add(event);
    }

    public MeasurementStationIdentity getIdentity() {
        return id;
    }
}
