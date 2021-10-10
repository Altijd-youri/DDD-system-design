package weatherEvent.domain;

public class MeasurementStationIdentity {
    private final String id;

    public MeasurementStationIdentity(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}
