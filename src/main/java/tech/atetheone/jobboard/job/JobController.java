package tech.atetheone.jobboard.job;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
  * This class is a controller that handles HTTP requests for the Job entity.

  * The @RestController annotation tells Spring Boot that this class is a controller.
  *
  * GET /jobs: This method returns a list of Job objects.
  * GET /jobs/{id}: This method returns a specific Job object by its id.
  * POST /jobs: This method creates a new Job object.
  * PUT /jobs/{id}: This method updates an existing Job object by its id.
  * DELETE /jobs/{id}: This method deletes an existing Job object by its id.
  * GET /jobs/{id}/company: This method returns the company of a specific Job object by its id.
  *
 */

@RestController
public class JobController {
  private List<Job> jobs = new ArrayList<>();

  @GetMapping("/jobs")
  public List<Job> getAllJobs() {
    this.jobs = List.of(
      new Job(1L, "Software Engineer", "Develops software applications", "Remote", "100000", "150000"),
      new Job(2L, "Data Analyst", "Analyzes data", "Remote", "80000", "120000"),
      new Job(3L, "Product Manager", "Manages product development", "Remote", "120000", "160000")
    );
    return this.jobs;
  }

  @GetMapping("/jobs/{id}")
  public Job getJobById(Long id) {
    return null;
  }

  @PostMapping("/jobs")
  public Job createJob(Job job) {
    return null;
  }

  @PutMapping("/jobs/{id}")
  public Job updateJob(Long id, Job job) {
    return null;
  }

  @DeleteMapping("/jobs/{id}")
  public void deleteJob(Long id) {
  }

  @GetMapping("/jobs/{id}/company")
  public String getCompanyByJobId(Long id) {
    return null;
  }
}
