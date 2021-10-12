package weatherEvent.port.adapter.persistence;

import weatherEvent.domain.*;

import java.util.HashMap;
import java.util.Map;

public class MemoryMeasurementStationRepository implements MeasurementStationRepository {
    static Map<MeasurementStationID, MeasurementStation> savedStations = new HashMap();
    private static long id = 0;

    @Override
    public MeasurementStationID nextIdentity() {
        id++;
        return new MeasurementStationID(String.valueOf(id));
    }

    @Override
    public MeasurementStation stationOfUserById(UserID Uid, String mStationId) throws Exception {
        MeasurementStationID toFind = new MeasurementStationID(mStationId);

        MeasurementStation found = savedStations.get(toFind);
        if (found != null) {
            if (!found.isOwnedBy(Uid)) throw new Exception("This station is not owned by this user.");
            return found;
        }
        return null;
    }

    @Override
    public boolean store(MeasurementStation mStation) {
        MeasurementStation previous = savedStations.put(mStation.getIdentity(), mStation);
        return previous == null;
    }

    @Override
    public boolean delete(String mStationId) {
        MeasurementStationID toFind = new MeasurementStationID(mStationId);

        MeasurementStation previous = savedStations.remove(toFind);
        return previous != null;
    }
}
