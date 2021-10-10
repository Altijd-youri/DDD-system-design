package account.application;

import account.domain.CompanyID;
import account.domain.User;
import account.domain.UserID;
import account.domain.UserRepository;
import account.port.adapter.persistence.MemoryUserRepository;

public class UserApplicationService {
    private final UserRepository userRepository = new MemoryUserRepository();

    public void userAddSavedLocation(String latitude, String longitude, String name, String userID) {
        User user = userRepository.get(new UserID(userID));
        user.createSavedLocation(latitude,longitude,name);
        userRepository.update(user);
    }

    public void addUserToCompany(String userID, String companyID) {
          User user = userRepository.get(new UserID(userID));
          user.setCompany(new CompanyID(companyID));
          userRepository.update(user);
      }
}
