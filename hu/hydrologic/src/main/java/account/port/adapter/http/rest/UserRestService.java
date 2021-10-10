package account.port.adapter.http.rest;

import account.application.UserApplicationService;

public class UserRestService {
    UserApplicationService userApplicationService = new UserApplicationService();

    public void addUserToCompany(String userID, String companyID) {
        userApplicationService.addUserToCompany(userID, companyID);
    }
}