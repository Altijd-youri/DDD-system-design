package account.port.adapter.persistence;

import account.domain.*;

import java.util.ArrayList;
import java.util.List;

public class MemorySavedLocationRepository implements SavedLocationRepository {
    private static final List<SavedLocation> savedLocations = new ArrayList<>();
    private static long id = 0;

    @Override
    public boolean store(SavedLocation savedLocation) {
        for (SavedLocation location : savedLocations) {
            if (location.getID().equals(savedLocation.getID())) {
                return false;
            }
        }
        return savedLocations.add(savedLocation);
    }

    @Override
    public boolean update(SavedLocation savedLocation) {
        for (int i = 0; i < savedLocations.size(); i++){
            if (savedLocations.get(i).getID().equals(savedLocation.getID())){
                savedLocations.set(i, savedLocation);
                return true;
            }
        }
        return false;
    }

    @Override
    public SavedLocationID nextIdentity() {
        id++;
        return new SavedLocationID(String.valueOf(id));
    }


    @Override
    public SavedLocation get(SavedLocationID id) {
        for (SavedLocation savedLocation : savedLocations){
            if (savedLocation.getID().equals(id)){
                return savedLocation;
            }
        }
        return null;
    }
}