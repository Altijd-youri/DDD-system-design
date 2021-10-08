package hydrologic.src.main.java.account.domain;

import java.util.HashSet;
import java.util.Set;

public class User {
    private UserID userID;
    private Email email;
    private Role role;
    private Set<SavedLocationID> savedLocationIDs;
    private String firstName;
    private String lastName;

    public User(UserID userID, Email email, Role role, String firstName, String lastName) {
        this.userID = userID;
        this.email = email;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.savedLocationIDs = new HashSet<>();
    }
};