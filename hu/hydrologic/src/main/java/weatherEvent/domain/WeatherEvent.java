package weatherEvent.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class WeatherEvent {
    private List<Measurement> measurements;
    private Location location;
    private WeatherEventIdentity id;
    private Date timeStamp;
    private UserID reportedBy;

    public WeatherEvent(UserID reporter, List<Measurement> measurements, Location location, WeatherEventIdentity id, Date timeStamp) {
        this.measurements = measurements;
        this.location = location;
        this.id = id;
        this.timeStamp = timeStamp;
        this.reportedBy = reporter;
    }
}