package tech.atetheone.jobboard.company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
  List<Company> findAllCompanies();
  Optional<Company> findCompanyById(Long id);
  void createCompany(Company company);
  boolean updateCompany(Long id, Company company);
  boolean deleteCompany(Long id);
}
