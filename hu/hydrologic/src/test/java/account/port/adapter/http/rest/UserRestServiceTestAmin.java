package account.port.adapter.http.rest;

import account.domain.*;

import account.port.adapter.http.rest.UserRestService;
import account.port.adapter.persistence.MemoryCompanyRepository;
import account.port.adapter.persistence.MemorySavedLocationRepository;
import account.port.adapter.persistence.MemoryUserRepository;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserRestServiceTestAmin {
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
        savedLocation = new SavedLocation("Science Park", savedLocationID, coordinates);
        savedLocationRepository.store(savedLocation);
    }

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
        assertThrows(Exception.class, () -> user.createSavedLocation(savedLocationID, coordinates,"Science Park"), "SavedLocation already exist");
    }
}
