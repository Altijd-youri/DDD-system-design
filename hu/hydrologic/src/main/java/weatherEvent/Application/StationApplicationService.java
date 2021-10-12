package weatherEvent.Application;

import account.domain.UserException;
import weatherEvent.domain.*;
import weatherEvent.domain.services.CollaborationService;
import weatherEvent.port.adapter.persistence.MemoryMeasurementStationRepository;

import java.util.Date;
import java.util.List;

public class StationApplicationService {
    MeasurementStationRepository repository = new MemoryMeasurementStationRepository();

    public void weatherEventOnStation(String UidInput, String mStationId, List<List<String>> measurements) throws Exception {
        UserID Uid = new UserID(UidInput);

        CollaborationService collaborationService = new CollaborationService();
        if(!collaborationService.userExists(Uid)) {
            throw new UserException("User doesn't exist");
        }
        MeasurementStation mStation = repository.stationOfUserById(Uid, mStationId);
        mStation.addWeatherEvent(measurements);

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
