package tech.atetheone.jobboard.company.impl;

import org.springframework.stereotype.Service;
import tech.atetheone.jobboard.company.CompanyRepository;
import tech.atetheone.jobboard.company.CompanyService;
import tech.atetheone.jobboard.company.Company;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
  private final CompanyRepository companyRepository;

  public CompanyServiceImpl(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  @Override
  public List<Company> findAllCompanies() {
    return companyRepository.findAll();
  }

  @Override
  public Optional<Company> findCompanyById(Long id) {
    return companyRepository.findById(id);
  }

  @Override
  public void createCompany(Company company) {
    companyRepository.save(company);
  }

  @Override
  public boolean updateCompany(Long id, Company company) {
    if (companyRepository.existsById(id)) {
      company.setId(id);
      companyRepository.save(company);
      return true;
    }
    return false;
  }

  @Override
  public boolean deleteCompany(Long id) {
    if (companyRepository.existsById(id)) {
      companyRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
