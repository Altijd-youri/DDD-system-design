package weatherEvent.domain;

public interface MeasurementStationRepository {
    //TODO - Youri: Implement
    MeasurementStationIdentity nextIdentity();
    MeasurementStation get(MeasurementStationIdentity stationId);
    MeasurementStation stationOfUserById(UserID Uid, String mStationId);
    boolean store(MeasurementStation station);
}
