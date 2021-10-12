package account.domain;

import java.util.Objects;

public class SavedLocationID {
    private final String id;

    public SavedLocationID(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.id ;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof SavedLocationID) && this.id.equals(obj.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SavedLocationID that = (SavedLocationID) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}