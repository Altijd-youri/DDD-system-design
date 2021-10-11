package weatherEvent.domain;

import java.util.ArrayList;
import java.util.List;

public class MeasurementUnit {
    private final String textRepresentation;
    private final String unitRepresentation;

    public MeasurementUnit(String representation) {
        this.unitRepresentation = representation;
        if (representation.equals("l")) {
            this.textRepresentation = "liter";
        }
        else if (representation.equals("ml")) {
            this.textRepresentation = "milliliter";
        }
        else if (representation.equals("cl")) {
            this.textRepresentation = "centiliter";
        }
        else if (representation.equals("dl")) {
            this.textRepresentation = "deciliter";
        }
        else if (representation.equals("mm")) {
            this.textRepresentation = "millimeter";
        }
        else throw new RuntimeException("That's not a valid measurement unit and can't be converted to the correct representation.");
    }

    public MeasurementUnit(String textRepresentation, String unitRepresentation) {
        this.textRepresentation = textRepresentation;
        this.unitRepresentation = unitRepresentation;
    }
}
