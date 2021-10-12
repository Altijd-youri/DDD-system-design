package weatherEvent.domain;

public interface MeasurementStationRepository {
    //TODO - Youri: Implement
    MeasurementStationIdentity nextIdentity();
    MeasurementStation stationOfUserById(UserID Uid, String mStationId) throws Exception;
    boolean store(MeasurementStation station);
    boolean delete(String mStationId);
}
