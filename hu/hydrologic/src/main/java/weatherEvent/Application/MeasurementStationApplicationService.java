package weatherEvent.Application;

import weatherEvent.domain.*;

import java.util.Date;

public class MeasurementStationApplicationService {
    private MeasurementStationRepository repository;

    public MeasurementStationApplicationService(MeasurementStationRepository repository) {
        this.repository = repository;
    }

    public boolean createMeasurementStation(String userId, Date lastCalibratedAt, double latitude, double longitude, String name) throws Exception {
        MeasurementStationIdentity stationId = this.repository.nextIdentity();


        MeasurementStation measurementStation = new MeasurementStation(new UserID(userId), stationId, lastCalibratedAt, new Location(latitude, longitude), name);

        return this.repository.store(measurementStation);
    }
}
