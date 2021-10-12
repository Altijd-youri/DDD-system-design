package account.domain;

import java.util.Date;
import java.util.Objects;

public class UserID {
    private final String id;

    public UserID() {
        this.id = String.valueOf(new Date().getTime());
    }

    public UserID(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.id ;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof UserID) && this.id.equals(obj.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}