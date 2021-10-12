package weatherEvent.domain;

import java.util.Date;
import java.util.List;

public class WeatherEvent {
    private WeatherEventID id;
    private List<Measurement> measurements;
    private Location location;
    private Date timeStamp;
    private UserID reportedBy;
    private Picture picture;

    public WeatherEvent(WeatherEventID id, UserID reporter, List<Measurement> measurements, Location location, Date timeStamp) {
        this.id = id;
        this.measurements = measurements;
        this.location = location;
        this.timeStamp = timeStamp;
        this.reportedBy = reporter;
        this.picture = null;
    }

    public WeatherEventID getId() {
        return this.id;
    }

    public void addPicture(Byte[] image, String description) throws Exception {
        if (image!= null && image.length>0) {
            picture = new Picture(image, description);
        }else {
            throw new Exception("image moet gevuld zijn");
        }
    }
}
