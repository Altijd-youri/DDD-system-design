package account.domain;

public class CompanyID {
    private final String id;

    public CompanyID(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id ;
    }
}