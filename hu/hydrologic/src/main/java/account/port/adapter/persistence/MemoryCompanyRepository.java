package account.port.adapter.persistence;

import account.domain.*;

import java.util.ArrayList;
import java.util.List;

public class MemoryCompanyRepository implements CompanyRepository {
    private static final List<Company> companies = new ArrayList<>();

    @Override
    public boolean store(Company company) {
        for (int i = 0; i < companies.size(); i++){
            if (companies.get(i).getID().equals(company.getID())){
                companies.add(company);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(Company company) {
       for (int i = 0; i < companies.size(); i++){
           if (companies.get(i).getID().equals(company.getID())){
               companies.set(i, company);
               return true;
           }
        }
       return false;
    }

    @Override
    public Company get(CompanyID id) {
        for (Company company : companies){
            if (company.getID().equals(id)){
                return company;
            }
        }
        return null;
    }
}
