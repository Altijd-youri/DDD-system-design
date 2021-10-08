package weatherEvent.domain;

import java.util.Set;

public class MeasurementStation {
    private MeasurementStationIdentity id;
    private Set<MeasurementStationIdentity> events;
    private Location location;
    private String name;

    public MeasurementStation(MeasurementStationIdentity id, Set<MeasurementStationIdentity> events, Location location, String name) {
        this.id = id;
        this.events = events;
        this.location = location;
        this.name = name;
    }
}
