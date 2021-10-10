package weatherEvent.domain;

import java.util.ArrayList;
import java.util.List;

public class MeasurementStation {
    private UserID owner;
    private MeasurementStationIdentity id;
    private List<WeatherEventID> events;
    private Location location;
    private String name;

    public MeasurementStation(UserID owner, MeasurementStationIdentity id, Location location, String name) {
        this.owner = owner;
        this.id = id;
        this.location = location;
        this.name = name;
        this.events = new ArrayList<WeatherEventID>();
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
}
