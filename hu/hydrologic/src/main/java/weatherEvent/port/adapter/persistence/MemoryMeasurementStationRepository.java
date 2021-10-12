package weatherEvent.port.adapter.persistence;

import weatherEvent.domain.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MemoryMeasurementStationRepository implements MeasurementStationRepository {
    static Map<MeasurementStationIdentity, MeasurementStation> savedStations = new HashMap();
    private static long id = 0;

    @Override
    public MeasurementStationIdentity nextIdentity() {
        id++;
        return new MeasurementStationIdentity(String.valueOf(id));
    }

    @Override
    public MeasurementStation stationOfUserById(UserID Uid, String mStationId) throws Exception {
        MeasurementStationIdentity toFind = new MeasurementStationIdentity(mStationId);

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
        MeasurementStationIdentity toFind = new MeasurementStationIdentity(mStationId);

        MeasurementStation previous = savedStations.remove(toFind);
        return previous != null;
    }
}
