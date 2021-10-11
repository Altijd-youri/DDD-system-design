package weatherEvent.Application;

import weatherEvent.domain.*;
import weatherEvent.port.adapter.persistence.MemoryMeasurementStationRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StationApplicationService {
    MeasurementStationRepository repository = new MemoryMeasurementStationRepository();
    WeatherEventApplicationService eventApplication = new WeatherEventApplicationService();

    public void weatherEventOnStation(String UidInput, String mStationId, List<List<String>> measurements) throws Exception {
        UserID Uid = new UserID(UidInput);
        MeasurementStation mStation = repository.stationOfUserById(Uid, mStationId);

        Location location = mStation.getLocation();

        WeatherEventID wEventId = eventApplication.newWeatherEvent(Uid, location.getLongitude(), location.getLatitude(), parseMeasurements(measurements));

        mStation.addWeatherEvent(wEventId);

        repository.store(mStation);
    }

    private List<Measurement> parseMeasurements(List<List<String>> measurements) {
        List<Measurement> parsedMeasurements = new ArrayList<>();
        for (List<String> measurement : measurements) {
            parsedMeasurements.add(new Measurement(new MeasurementUnit(measurement.get(1)), Double.parseDouble(measurement.get(0))));
        }
        return parsedMeasurements;
    }

    public boolean createMeasurementStation(String userId, Date lastCalibratedAt, double latitude, double longitude, String name) throws Exception {
        MeasurementStationIdentity stationId = this.repository.nextIdentity();

        MeasurementStation measurementStation = new MeasurementStation(new UserID(userId), stationId, lastCalibratedAt, new Location(latitude, longitude), name);

        return this.repository.store(measurementStation);
    }

}
