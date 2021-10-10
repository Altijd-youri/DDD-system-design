package weatherEvent.domain;

import java.util.Date;
import java.util.List;

public class WeatherEvent {
    private WeatherEventID id;
    private List<Measurement> measurements;
    private Location location;
    private Date timeStamp;
    private UserID reportedBy;

    public WeatherEvent(WeatherEventID id, UserID reporter, List<Measurement> measurements, Location location, Date timeStamp) {
        this.id = id;
        this.measurements = measurements;
        this.location = location;
        this.timeStamp = timeStamp;
        this.reportedBy = reporter;
    }

    public WeatherEventID getId() {
        return this.id;
    }

    public void updatePicture(Byte[] image, String description, UserID userID){
        Picture picture = new Picture(image,description);
    }
}
