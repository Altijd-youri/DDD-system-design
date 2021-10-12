package weatherEvent.domain;

import java.util.Objects;

public class MeasurementStationIdentity {
    private final String id;

    public MeasurementStationIdentity(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeasurementStationIdentity that = (MeasurementStationIdentity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
