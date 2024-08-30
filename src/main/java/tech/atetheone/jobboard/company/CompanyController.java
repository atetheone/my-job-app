package tech.atetheone.jobboard.company;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompanyController {
  private final CompanyService companyService;

  public CompanyController(CompanyService companyService) {
    this.companyService = companyService;
  }

  @GetMapping
  public ResponseEntity<List<Company>> findAllCompanies() {
    return ResponseEntity.ok(companyService.findAllCompanies());
  }

  @PostMapping
  public ResponseEntity<String> createCompany(@RequestBody Company company) {
    companyService.createCompany(company);
    return ResponseEntity.ok("Company created successfully");
  }

  @GetMapping("/{id}")
  public ResponseEntity<Company> findCompanyById(@PathVariable Long id) {
    Company company = companyService.findCompanyById(id);
    if (company == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(company);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company updatedCompany) {
    boolean updated = companyService.updateCompany(id, updatedCompany);
    if (!updated) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok("Company updated successfully");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
    boolean deleted = companyService.deleteCompany(id);
    if (!deleted) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok("Company deleted successfully");
  }
}
