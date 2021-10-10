package weatherEvent.Application;

import weatherEvent.domain.MeasurementStation;
import weatherEvent.domain.MeasurementStationRepository;
import weatherEvent.domain.UserID;
import weatherEvent.port.adapter.persistence.MeasurementStationRepositoryInMemoryImpl;

import java.util.List;

public class StationApplicationService {
    MeasurementStationRepository repository = new MeasurementStationRepositoryInMemoryImpl();

    public void weatherEventOnStation(String UidInput, String mStationId, List<List<String>> measurements) {
        UserID Uid = new UserID(UidInput);
        MeasurementStation mStation = repository.stationOfUserById(Uid, mStationId);

        //TODO - Youri: Implement step 1.1.2

        //TODO - Youri: Implement step 1.1.3

        //TODO - Youri: Implement step 1.1.4

        repository.store(mStation);
    }

}
