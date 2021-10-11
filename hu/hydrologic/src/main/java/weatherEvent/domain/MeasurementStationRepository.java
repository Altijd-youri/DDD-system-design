package weatherEvent.domain;

public interface MeasurementStationRepository {
    MeasurementStation stationOfUserById(UserID Uid, String mStationId) throws Exception;

    MeasurementStationIdentity store(MeasurementStation mstation) throws Exception;
}
