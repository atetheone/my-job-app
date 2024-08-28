package tech.atetheone.jobboard.job;

import jakarta.persistence.*;
import tech.atetheone.jobboard.company.Company;

@Entity
public class Job {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private String description;
  private String location;
  private String minSalary;
  private String maxSalary;

  @ManyToOne
  private Company company;

  public Job() {
  }

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
  }

  public Job(Long id, String title, String description, String location, String minSalary, String maxSalary) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.location = location;
    this.minSalary = minSalary;
    this.maxSalary = maxSalary;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public String getLocation() {
    return location;
  }

  public String getMinSalary() {
    return minSalary;
  }

  public String getMaxSalary() {
    return maxSalary;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setMinSalary(String minSalary) {
    this.minSalary = minSalary;
  }

  public void setMaxSalary(String maxSalary) {
    this.maxSalary = maxSalary;
  }
}
