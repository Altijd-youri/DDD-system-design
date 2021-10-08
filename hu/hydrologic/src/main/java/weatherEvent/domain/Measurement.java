package weatherEvent.domain;

public class Measurement {
    private final MeasurementUnit unit;
    private final double measurement;

    public Measurement(MeasurementUnit unit, double measurement) {
        this.unit = unit;
        this.measurement = measurement;
    }
}
