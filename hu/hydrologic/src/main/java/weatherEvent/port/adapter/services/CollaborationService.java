package weatherEvent.port.adapter.services;

import account.port.adapter.http.rest.UserRestService;
import weatherEvent.domain.UserID;

public class CollaborationService {
    public boolean userExists(UserID userId) {
        //Normally you would make an API call here. For this example, we are just calling it directly.
        UserRestService userRestService = new UserRestService();
        return userRestService.userExists(userId.getId());
    }
}
