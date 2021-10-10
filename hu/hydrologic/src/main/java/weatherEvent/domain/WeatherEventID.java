package weatherEvent.domain;

import java.util.Date;

public class WeatherEventID {
    private final String id;

    public WeatherEventID(Date timeStamp, UserID uid) {
        this.id = uid.toString() + '%' + timeStamp.getTime();
    }
    public WeatherEventID(String id) {
        this.id = id;
    }
}
