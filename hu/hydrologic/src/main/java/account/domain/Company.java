package account.domain;

public class Company{
    private CompanyID companyID;
    private Address address;
    private String name;
    private String sector;

    public Company(CompanyID companyID, String name, String sector, Address address) {
        this.companyID = companyID;
        this.name = name;
        this.sector = sector;
        this.address = address;
    }

    public CompanyID getID() {
        return this.companyID;
    }
}