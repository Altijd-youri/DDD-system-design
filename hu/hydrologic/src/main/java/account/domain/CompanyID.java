package account.domain;

import java.util.Objects;

public class CompanyID {
    private final String id;

    public CompanyID(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.id ;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof CompanyID) && this.id.equals(obj.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}