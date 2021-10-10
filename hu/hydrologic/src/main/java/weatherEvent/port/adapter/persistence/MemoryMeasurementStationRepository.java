package weatherEvent.port.adapter.persistence;

import weatherEvent.domain.MeasurementStation;
import weatherEvent.domain.MeasurementStationIdentity;
import weatherEvent.domain.MeasurementStationRepository;

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
    public boolean store(MeasurementStation station) {
        return stations.add(station);
    }
    //TODO - Youri: Implement mock
}
