package weatherEvent.domain;

import java.util.Date;
import java.util.List;

public class WeatherEvent {
    private WeatherEventID id;
    private List<Measurement> measurements;
    private Location location;
    private Date timeStamp;
    private UserID reportedBy;

    public WeatherEvent(UserID reporter) {
        this.reportedBy = reporter;
    }

    public WeatherEvent(UserID reporter, List<Measurement> measurements, Location location, WeatherEventID id, Date timeStamp) {
        this.measurements = measurements;
        this.location = location;
        this.id = id;
        this.timeStamp = timeStamp;
        this.reportedBy = reporter;
    }

    public WeatherEventID getId() {
        return this.id;
    }
}
