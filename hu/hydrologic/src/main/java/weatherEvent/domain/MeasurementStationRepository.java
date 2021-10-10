package weatherEvent.domain;

public interface MeasurementStationRepository {
    //TODO - Youri: Implement

    MeasurementStationIdentity nextIdentity();
    boolean store(MeasurementStation station);
}
