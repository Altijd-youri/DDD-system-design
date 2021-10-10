package account.domain;

public class UserID {
    private final String id;

    public UserID(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id ;
    }
}