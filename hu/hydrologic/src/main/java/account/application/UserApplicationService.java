package account.application;

import account.domain.*;
import account.port.adapter.persistence.MemoryCompanyRepository;
import account.port.adapter.persistence.MemoryUserRepository;

public class UserApplicationService {
    private final UserRepository userRepository = new MemoryUserRepository();
    private final CompanyRepository companyRepository = new MemoryCompanyRepository();

    public void userAddSavedLocation(String latitude, String longitude, String name, String userID) {
        User user = userRepository.get(new UserID(userID));
        user.createSavedLocation(latitude,longitude,name);
        userRepository.update(user);
    }
  
    public void addUserToCompany(String userID, String companyID) {
          User user = userRepository.get(new UserID(userID));
          Company company = companyRepository.get(new CompanyID(companyID));

          if(user != null && company != null) {
              user.setCompany(new CompanyID(companyID));
              userRepository.update(user);
          }
      }

    public boolean userExists(String id) {
        return this.userRepository.get(new UserID(id)) != null;
    }
}
