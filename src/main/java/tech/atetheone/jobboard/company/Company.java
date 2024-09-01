package tech.atetheone.jobboard.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import tech.atetheone.jobboard.job.Job;
import tech.atetheone.jobboard.review.Review;

import java.util.List;

@Entity
@Data
public class Company {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String description;

  @JsonIgnore
  @OneToMany(mappedBy = "company")
  private List<Job> jobs;

  @OneToMany(mappedBy = "company")
  private List<Review> reviews;
}
