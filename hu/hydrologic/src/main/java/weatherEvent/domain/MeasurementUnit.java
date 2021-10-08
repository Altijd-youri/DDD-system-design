package weatherEvent.domain;

public class MeasurementUnit {
    private final String textRepresentation;
    private final String unitRepresentation;

    public MeasurementUnit(String textRepresentation, String unitRepresentation) {
        this.textRepresentation = textRepresentation;
        this.unitRepresentation = unitRepresentation;
    }
}
