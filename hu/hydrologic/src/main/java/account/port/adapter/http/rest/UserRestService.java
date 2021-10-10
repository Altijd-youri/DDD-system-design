package account.port.adapter.http.rest;

import account.application.UserApplicationService;
import account.domain.User;
import account.domain.UserRepository;
import account.port.adapter.persistence.FileUserRepository;

public class UserRestService {
    UserApplicationService userApplicationService = new UserApplicationService();

    public void addUserToCompany(String userID, String companyID) {
        userApplicationService.addUserToCompany(userID, companyID);
    }

    public User getUserOfID(String userID){
       return userApplicationService.getUser(userID);
    }
}