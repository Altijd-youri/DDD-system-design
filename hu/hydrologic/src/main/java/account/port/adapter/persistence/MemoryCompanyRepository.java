package account.port.adapter.persistence;

import account.domain.*;

import java.util.ArrayList;
import java.util.List;

public class MemoryCompanyRepository implements CompanyRepository {
    private static final List<Company> companies = new ArrayList<>();

    @Override
    public boolean store(Company company) {
        for (Company c : companies) {
            if (c.getID().toString().equals(company.getID().toString())) {
                return false;
            }
        }
        companies.add(company);
        return true;
    }

    @Override
    public boolean update(Company company) {
        for (Company c : companies) {
            if (c.getID().toString().equals(company.getID().toString())) {
                companies.remove(company);
                companies.add(company);
                return true;
            }
        }
        return false;
    }

    @Override
    public Company get(CompanyID id) {
        for (Company c : companies){
            if (c.getID().toString().equals(id.toString())){
                return c;
            }
        }
        return null;
    }
}
