package weatherEvent.domain;

public interface MeasurementStationRepository {
    MeasurementStationID nextIdentity();

    MeasurementStation stationOfUserById(UserID Uid, String mStationId) throws Exception;
    boolean store(MeasurementStation mstation) throws Exception;
    boolean delete(String mStationId);
}
