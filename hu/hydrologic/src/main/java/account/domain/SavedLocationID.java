package account.domain;

public class SavedLocationID {
    private final String id;

    public SavedLocationID(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id ;
    }
}