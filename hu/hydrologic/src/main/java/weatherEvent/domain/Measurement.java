package weatherEvent.domain;

public class Measurement {
    private final MeasurementUnit unit;
    private final double measurement;

    public Measurement(MeasurementUnit unit, double measurement) {
        if (measurement < 0.0d)
            throw new RuntimeException("Can't give measurements with negative values.");
        this.unit = unit;
        this.measurement = measurement;
    }
}
