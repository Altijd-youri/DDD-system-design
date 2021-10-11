package weatherEvent.domain;

public interface MeasurementStationRepository {
    //TODO - Youri: Implement
    MeasurementStationIdentity nextIdentity();
    MeasurementStation stationOfUserById(UserID Uid, String mStationId);
    boolean store(MeasurementStation station);
}
