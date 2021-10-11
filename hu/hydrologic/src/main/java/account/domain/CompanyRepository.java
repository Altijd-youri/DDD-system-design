package account.domain;

public interface CompanyRepository {
    boolean store(Company company);
    boolean update(Company company);
    Company get(CompanyID id);
}