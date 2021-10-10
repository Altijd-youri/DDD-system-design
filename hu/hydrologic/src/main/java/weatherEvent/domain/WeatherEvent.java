package weatherEvent.domain;

import account.domain.User;
import weatherEvent.port.adapter.http.rest.WeatherEventService;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class WeatherEvent {
    WeatherEventService weatherEventService = new WeatherEventService();
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

    public WeatherEvent() {

    }

    public void addPicture(Byte[] image, String description, String userID){
        User user = weatherEventService.getUserOfID(userID);
        Picture picture = new Picture(image,description);
    }
}
