package account.port.adapter.http.rest;

import account.application.UserApplicationService;
import account.domain.UserException;
import account.domain.UserID;

public class UserRestService {
    UserApplicationService userApplicationService = new UserApplicationService();

    public void userAddSavedLocation(String latitude, String longitude, String name, String userID) {
        userApplicationService.userAddSavedLocation(latitude,longitude,name,userID);
    }

    public void addUserToCompany(String userID, String companyID) throws UserException {
        userApplicationService.addUserToCompany(userID, companyID);
    }

    public boolean userExists(String id) {
        return this.userApplicationService.userExists(id);
    }

    public UserID makeUser(String companyId, String firstName, String lastName, String email) {
        return userApplicationService.makeUser(companyId, firstName, lastName, email);
    }
}

