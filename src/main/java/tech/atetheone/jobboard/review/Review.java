package tech.atetheone.jobboard.review;

import jakarta.persistence.*;
import lombok.Data;
import tech.atetheone.jobboard.company.Company;

@Entity
@Data
public class Review {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String title;
  private String description;
  private double rating;

  @ManyToOne
  private Company company;
}
