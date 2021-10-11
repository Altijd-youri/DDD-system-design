package account.port.adapter.http.rest;

import account.application.UserApplicationService;

public class UserRestService {
    UserApplicationService userApplicationService = new UserApplicationService();

    public void userAddSavedLocation(String latitude, String longitude, String name, String userID) {
        userApplicationService.userAddSavedLocation(latitude,longitude,name,userID);
    }

    public void addUserToCompany(String userID, String companyID) {
        userApplicationService.addUserToCompany(userID, companyID);
    }

    public boolean userExists(String id) {
        return this.userApplicationService.userExists(id);
    }
}

