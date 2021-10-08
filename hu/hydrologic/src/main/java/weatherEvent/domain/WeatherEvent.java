package weatherEvent.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class WeatherEvent {
    private Set<Measurement> measurements;
    private Location location;
    private WeatherEventIdentity id;
    private Date timeStamp;

    public WeatherEvent(Set<Measurement> measurements, Location location, WeatherEventIdentity id, Date timeStamp) {
        this.measurements = measurements;
        this.location = location;
        this.id = id;
        this.timeStamp = timeStamp;
    }
}
