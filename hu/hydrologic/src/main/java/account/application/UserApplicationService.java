package hydrologic.src.main.java.account.application;

import hydrologic.src.main.java.account.domain.User;
import hydrologic.src.main.java.account.domain.UserRepository;
import hydrologic.src.main.java.account.port.adapter.persistence.FileUserRepository;

public class UserApplicationService {
    UserRepository userRepository = new FileUserRepository();

    public void addUserToCompany(String userID, String companyID) {
        User user = userRepository.getUser(userID);
        user.setCompany(companyID);
        userRepository.store(user);
    }
}