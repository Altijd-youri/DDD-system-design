package hydrologic.src.main.java.account.domain;

public class Address {
    private final String city;
    private final String postalCode;
    private final String streetName;
    private final String houseNumber;

    public Address(String city, String postalCode, String streetName, String houseNumber) {
        this.city = city;
        this.postalCode = postalCode;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }
}