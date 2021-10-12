package weatherEvent.port.adapter.persistence;

import weatherEvent.domain.*;

import java.util.HashSet;
import java.util.Set;

// Mocked implementation
public class MemoryMeasurementStationRepository implements MeasurementStationRepository {
    private static final Set<MeasurementStation> stations = new HashSet<>();
    private static long id = 0;

    @Override
    public MeasurementStationIdentity nextIdentity() {
        id++;
        return new MeasurementStationIdentity(String.valueOf(id));
    }

    @Override
    public MeasurementStation get(MeasurementStationIdentity stationId) {
        for(MeasurementStation station : stations) {
            if(station.getIdentity() == stationId) {
                return station;
            }
        }
        return null;
    }

    @Override
    public MeasurementStation stationOfUserById(final UserID Uid, final String mStationId){
        for(MeasurementStation station : stations) {
            if(station.isOfOwner(Uid)) {
                return station;
            }
        }
        return null;
    }

    @Override
    public boolean store(MeasurementStation station) {
        return stations.add(station);
    }
    //TODO - Youri: Implement mock
}
