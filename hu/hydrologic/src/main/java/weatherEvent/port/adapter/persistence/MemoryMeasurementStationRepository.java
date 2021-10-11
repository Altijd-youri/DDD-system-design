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
    public MeasurementStation stationOfUserById(final UserID Uid, final String mStationId){
        //Mock
        Location mockedLocation = new Location(52.087278, 5.178389);
        String mockedName = "Utrecht Science park";
        //End Mock
        return stations.stream().filter((station) -> station.isOfOwner(Uid)).findFirst().orElseThrow(RuntimeException::new);
//        return new MeasurementStation(Uid, new MeasurementStationIdentity("mStationId"), mockedLocation, mockedName);
    }

    @Override
    public boolean store(MeasurementStation station) {
        return stations.add(station);
    }
    //TODO - Youri: Implement mock
}
