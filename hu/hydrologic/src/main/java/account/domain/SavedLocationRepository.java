package account.domain;

public interface SavedLocationRepository {
    boolean store(SavedLocation savedLocation);
    boolean update(SavedLocation savedLocation);
    SavedLocation get(SavedLocationID id);
}