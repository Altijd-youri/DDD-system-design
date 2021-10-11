package weatherEvent.port.adapter.persistence;

import weatherEvent.domain.*;

import java.util.List;

public class MemoryMeasurementStationRepository implements MeasurementStationRepository {
    static List<MeasurementStation> savedStations;

    @Override
    public MeasurementStation stationOfUserById(UserID Uid, String mStationId) throws Exception {

        for (MeasurementStation savedStation : savedStations) {
            if (savedStation.getIdentity().toString() == mStationId) {
                if (!savedStation.isOwnedBy(Uid)) throw new Exception("This station is not owned by this user.");
                return savedStation;
            }
        }
        return null;
    }

    @Override
    public MeasurementStationIdentity store(MeasurementStation mStation) {
        MeasurementStationIdentity mStationId = mStation.getIdentity();

        for (MeasurementStation savedStation : savedStations) {
            if (savedStation.getIdentity() == mStationId) {
                return mStationId;
            }
        }
        return null;
    }
}
