package account.domain;

import account.port.adapter.persistence.MemorySavedLocationRepository;

import java.util.HashSet;
import java.util.Set;

public class User {
    private UserID userID;
    private CompanyID companyID;
    private Email email;
    private Role role;
    private Set<SavedLocationID> savedLocationIDs;
    private String firstName;
    private String lastName;
    private final SavedLocationRepository savedLocationRepository = new MemorySavedLocationRepository();

    public User(UserID userID, CompanyID companyID, Email email, Role role, String firstName, String lastName) {
        this.userID = userID;
        this.companyID = companyID;
        this.email = email;
        this.role = role;
        this.savedLocationIDs = new HashSet<>();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void createSavedLocation(String latitude, String longitude, String name){
        this.savedLocationRepository.store(new SavedLocation(name,latitude,longitude));
    }

    public void setCompany(CompanyID companyID) {
        this.companyID = companyID;
    }

    public UserID getID() {
        return this.userID;
    }

    public void setCompany(String companyID) {
    }
}