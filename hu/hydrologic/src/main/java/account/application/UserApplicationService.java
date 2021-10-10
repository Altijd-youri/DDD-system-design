package account.application;

import account.domain.User;
import account.domain.UserRepository;

public class UserApplicationService {
    UserRepository userRepository;

    public void userAddSavedLocation(String langitude, String longitude, String name, String userID) {
        User user = userRepository.getUser(userID);
        user.createSavedLocation(langitude,longitude,name);
        userRepository.update(user);
    }
  
    public void addUserToCompany(String userID, String companyID) {
          User user = userRepository.getUser(userID);
//          user.setCompany(companyID);
          userRepository.store(user);
      }
}
