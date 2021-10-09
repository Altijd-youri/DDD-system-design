package account.port.adapter.http.rest;

import account.application.UserApplicationService;

public class UserRestService {
    UserApplicationService userApplicationService = new UserApplicationService();

    public void userAddSavedLocation(String langitude, String longitude, String name, String userID) {
        userApplicationService.userAddSavedLocation("0000.00", "0000.00", "Sience Park", "0011");
    }
}
