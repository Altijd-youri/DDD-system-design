package hydrologic.src.main.java.account.port.adapter.http.rest;

import hydrologic.src.main.java.account.application.UserApplicationService;

public class UserRestService {
    UserApplicationService userApplicationService = new UserApplicationService();

    public void addUserToCompany(String userID, String companyID) {
        userApplicationService.addUserToCompany(userID, companyID);
    }
}