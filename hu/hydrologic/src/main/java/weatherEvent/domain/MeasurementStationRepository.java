package weatherEvent.domain;

public interface MeasurementStationRepository {
    MeasurementStation stationOfUserById(UserID Uid, String mStationId);

    String store(MeasurementStation mstation);
}
