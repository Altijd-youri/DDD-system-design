package account.domain;

public interface CompanyRepository {
    void clear();
    boolean store(Company company);
    boolean update(Company company);
    Company get(CompanyID id);
}