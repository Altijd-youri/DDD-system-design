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
}
