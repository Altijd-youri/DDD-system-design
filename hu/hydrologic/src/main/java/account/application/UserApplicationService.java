package account.application;

import account.domain.*;
import account.port.adapter.persistence.MemoryCompanyRepository;
import account.port.adapter.persistence.MemorySavedLocationRepository;
import account.port.adapter.persistence.MemoryUserRepository;

public class UserApplicationService {
    private final UserRepository userRepository = new MemoryUserRepository();
    private final CompanyRepository companyRepository = new MemoryCompanyRepository();
    private final SavedLocationRepository savedLocationRepository = new MemorySavedLocationRepository();

    public void userAddSavedLocation(String latitude, String longitude, String name, String userID) {
        User user = userRepository.get(new UserID(userID));

        if (user != null){
            SavedLocationID savedLocationID = this.savedLocationRepository.nextIdentity();
            Coordinates coordinates = new Coordinates( Double.parseDouble(longitude), Double.parseDouble(latitude));
            SavedLocation savedLocation = user.createSavedLocation(savedLocationID, coordinates ,name);
            userRepository.update(user);
            this.savedLocationRepository.store(savedLocation);
        }


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

    public UserID makeUser(String companyId, String firstName, String lastName, String email) {
        UserID userId = new UserID();
        User newUser = new User(userId, new CompanyID(companyId), new Email(email), Role.USER, firstName, lastName);
        if (userRepository.store(newUser)) {
            return userId;
        }
        else {
            return null;
        }
    }
}
