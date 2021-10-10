package account.application;

import account.domain.User;
import account.domain.UserRepository;
import account.port.adapter.persistence.FileUserRepository;

public class UserApplicationService {
    UserRepository userRepository = new FileUserRepository();

    public void addUserToCompany(String userID, String companyID) {
        User user = userRepository.getUser(userID);
        user.setCompany(companyID);
        userRepository.store(user);
    }

    public User getUser(String userID){
        return userRepository.getUser(userID);
    }
}