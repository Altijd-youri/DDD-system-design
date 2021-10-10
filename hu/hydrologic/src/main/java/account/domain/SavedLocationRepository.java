package account.domain;

public interface SavedLocationRepository {
    public void store(SavedLocation savedLocation);
    public User getUser(String id);
}
