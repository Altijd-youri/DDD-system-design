package account.domain;

public interface SavedLocationRepository {
    boolean store(SavedLocation savedLocation);
    boolean update(SavedLocation savedLocation);
    SavedLocationID nextIdentity();
    SavedLocation get(SavedLocationID id);
}