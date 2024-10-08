package tech.atetheone.jobboard.job;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;
import tech.atetheone.jobboard.company.Company;

@Entity
@Data
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
}
