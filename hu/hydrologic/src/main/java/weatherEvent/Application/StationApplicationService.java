package weatherEvent.Application;

import weatherEvent.domain.*;
import weatherEvent.port.adapter.persistence.MeasurementStationRepositoryInMemoryImpl;

import java.util.ArrayList;
import java.util.List;

public class StationApplicationService {
    MeasurementStationRepository repository = new MeasurementStationRepositoryInMemoryImpl();
    WeatherEventApplicationService eventApplication = new WeatherEventApplicationService();

    public void weatherEventOnStation(String UidInput, String mStationId, List<List<String>> measurements) {
        UserID Uid = new UserID(UidInput);
        MeasurementStation mStation = repository.stationOfUserById(Uid, mStationId);

        Location location = mStation.getLocation();

        WeatherEventIdentity wEventId = eventApplication.newWeatherEvent(Uid, location.getLongitude(), location.getLatitude(), parseMeasurements(measurements));

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

}
