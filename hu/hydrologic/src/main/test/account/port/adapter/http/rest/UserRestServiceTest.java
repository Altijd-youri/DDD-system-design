package account.port.adapter.http.rest;

import account.domain.*;
import account.port.adapter.persistence.MemoryCompanyRepository;
import account.port.adapter.persistence.MemoryUserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserRestServiceTest {
    @Test
    void userAddSavedLocation() {
        //assertThrows(Exception.class,()->testMethod());
    }

    @Test
    public void addUserToCompany() throws Exception {
        final UserRestService userRestService = new UserRestService();
        final UserRepository userRepository = new MemoryUserRepository();
        final CompanyRepository companyRepository = new MemoryCompanyRepository();

        userRepository.store(new User(new UserID("user123"), null, null, null, null, null));
        companyRepository.store(new Company(new CompanyID("google"), null, null, null));

        assertThrows(Exception.class, () -> userRestService.addUserToCompany("user123", "microsoft"));
        assertThrows(Exception.class, () -> userRestService.addUserToCompany("user321", "google"));

        userRestService.addUserToCompany("user123", "google");

        assertEquals(userRepository.get(new UserID("user123")).getID().toString(), "user123");
        assertEquals(userRepository.get(new UserID("user123")).getCompany().toString(), "google");
    }
}

