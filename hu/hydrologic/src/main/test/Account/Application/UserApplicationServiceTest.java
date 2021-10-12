package Account.Application;

import account.domain.*;
import account.port.adapter.http.rest.UserRestService;
import account.port.adapter.persistence.MemoryCompanyRepository;
import account.port.adapter.persistence.MemorySavedLocationRepository;
import account.port.adapter.persistence.MemoryUserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserApplicationServiceTest {
    private static User user;
    private static SavedLocation savedLocation;
    final private UserRestService userRestService = new UserRestService();
    final private CompanyRepository companyRepository = new MemoryCompanyRepository();
    private static SavedLocationID savedLocationID;
    private static Coordinates coordinates = new Coordinates( 52.029421, 52.029421);

    @BeforeAll
    static void setup() {
        UserRepository repository = new MemoryUserRepository();
        user = new User(new account.domain.UserID("1"), new CompanyID("1"), new Email("user1@test.com"), Role.EMPLOYEE, "John", "Doe");
        repository.store(user);
        SavedLocationRepository savedLocationRepository = new MemorySavedLocationRepository();
        savedLocationID = savedLocationRepository.nextIdentity();
        savedLocation = new SavedLocation("Sience Park", savedLocationID, coordinates);
        savedLocationRepository.store(savedLocation);
    }

//    @BeforeEach
//    void before() {
//        userRepository.clear();
//        companyRepository.clear();
//    }

    @Test
    void userAddSavedLocationSavedLocation() {
        assertDoesNotThrow(() -> userRestService.userAddSavedLocation("52.029421", "5.201923","John","1"));
    }

    @Test
    void userAddSavedLocationUserDoesNotExist() {
        assertThrows(Exception.class, () -> userRestService.userAddSavedLocation("52.029421", "5.201923","amin","2"), "User doesn't exist");
    }

    @Test
    void userAddSavedLocationSavedLocationAlreadyExist() {
        assertThrows(Exception.class, () -> user.createSavedLocation(savedLocationID,coordinates,"Sience Park"), "SavedLocation already exist");
    }

//    @Test
//    public void addUserToCompany_isUserExisting() {
//        assertThrows(UserException.class, () -> userRestService.addUserToCompany("user123", "google"));
//        userRepository.store(new User(new UserID("user321"), null, null, null, null, null));
//        assertThrows(UserException.class, () -> userRestService.addUserToCompany("user123", "google"));
//    }
//
//    @Test
//    public void addUserToCompany_isCompanyExisting() {
//        assertThrows(CompanyException.class, () -> userRestService.addUserToCompany("user123", "google"));
//        companyRepository.store(new Company(new CompanyID("microsoft"), null, null, null));
//        assertThrows(CompanyException.class, () -> userRestService.addUserToCompany("user123", "google"));
//    }
//
//    @Test
//    public void addUserToCompany_isUserAdded() throws Exception {
//        userRestService.addUserToCompany("user123", "google");
//        assertEquals(userRepository.get(new UserID("user123")).getCompany().toString(), "google");
//    }



}