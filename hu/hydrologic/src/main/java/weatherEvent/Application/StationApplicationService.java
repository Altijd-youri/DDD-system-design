package weatherEvent.Application;

import weatherEvent.domain.*;
import weatherEvent.port.adapter.persistence.MemoryMeasurementStationRepository;

import java.util.Date;
import java.util.List;

public class StationApplicationService {
    MeasurementStationRepository repository = new MemoryMeasurementStationRepository();
    WeatherEventApplicationService eventApplication = new WeatherEventApplicationService();

    public void weatherEventOnStation(String UidInput, String mStationId, List<List<String>> measurements) throws Exception {
        UserID Uid = new UserID(UidInput);
        MeasurementStation mStation = repository.stationOfUserById(Uid, mStationId);

        Location location = mStation.getLocation();

        WeatherEventID wEventId = eventApplication.newWeatherEvent(UidInput, location.getLongitude(), location.getLatitude(), measurements);

        mStation.addWeatherEvent(wEventId);

        repository.store(mStation);
    }

    public MeasurementStationIdentity createMeasurementStation(String userId, Date lastCalibratedAt, double latitude, double longitude, String name) throws Exception {
        MeasurementStationIdentity stationId = this.repository.nextIdentity();
        MeasurementStation measurementStation = new MeasurementStation(new UserID(userId), stationId, lastCalibratedAt, new Location(latitude, longitude), name);

        if(!this.repository.store(measurementStation)) {
            return null;
        }

        return stationId;
    }

}
