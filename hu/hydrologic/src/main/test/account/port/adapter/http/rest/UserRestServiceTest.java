package account.port.adapter.http.rest;

import account.domain.*;
import account.port.adapter.persistence.MemoryCompanyRepository;
import account.port.adapter.persistence.MemoryUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserRestServiceTest {
    final private UserRestService userRestService = new UserRestService();
    final private UserRepository userRepository = new MemoryUserRepository();
    final private CompanyRepository companyRepository = new MemoryCompanyRepository();

    @BeforeEach
    void before() {
        userRepository.clear();
        companyRepository.clear();
    }

    @Test
    void userAddSavedLocation() {
        //assertThrows(Exception.class,()->testMethod());
    }

    @Test
    public void addUserToCompany_isUserNotFound1() {
        companyRepository.store(new Company(new CompanyID("google"), null, null, null));

        assertThrows(UserException.class, () -> userRestService.addUserToCompany("user123", "google"));
    }

    @Test
    public void addUserToCompany_isUserNotFound2() {
        companyRepository.store(new Company(new CompanyID("google"), null, null, null));
        userRepository.store(new User(new UserID("user321"), null, null, null, null, null));

        assertThrows(UserException.class, () -> userRestService.addUserToCompany("user123", "google"));
    }

    @Test
    public void addUserToCompany_isCompanyNotFound1() throws Exception {
        userRepository.store(new User(new UserID("user123"), null, null, null, null, null));

        assertThrows(CompanyException.class, () -> userRestService.addUserToCompany("user123", "google"));
    }

    @Test
    public void addUserToCompany_isCompanyNotFound2() throws Exception {
        userRepository.store(new User(new UserID("user123"), null, null, null, null, null));
        companyRepository.store(new Company(new CompanyID("microsoft"), null, null, null));

        assertThrows(CompanyException.class, () -> userRestService.addUserToCompany("user123", "google"));
    }

    @Test
    public void addUserToCompany_isCompanySet() throws Exception {
        userRepository.store(new User(new UserID("user123"), null, null, null, null, null));
        companyRepository.store(new Company(new CompanyID("google"), null, null, null));
        userRestService.addUserToCompany("user123", "google");

        assertEquals(userRepository.get(new UserID("user123")).getCompany().toString(), "google");
    }
}

