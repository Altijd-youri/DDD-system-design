package weatherEvent.port.adapter.persistence;

import weatherEvent.domain.*;

public class MeasurementStationRepositoryInMemoryImpl implements MeasurementStationRepository {
    @Override
    public MeasurementStation stationOfUserById(UserID Uid, String mStationId) {
        //Mock
        Location mockedLocation = new Location(52.087278, 5.178389);
        String mockedName = "Utrecht Science park";
        //End Mock

        return new MeasurementStation(Uid, new MeasurementStationIdentity("mStationId"), mockedLocation, mockedName);
    }

    @Override
    public String store(MeasurementStation mstation) {
        //Mock
        String mockedmStationId = mstation.getIdentity().toString();
        //End Mock

        return mockedmStationId;
    }
}
