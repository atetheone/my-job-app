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
  private JobService jobService;

  public JobController(JobService jobService) {
    this.jobService = jobService;
  }

  @GetMapping("/jobs")
  public List<Job> getAllJobs() {
    return jobService.findAll();
  }

  @GetMapping("/jobs/{id}")
  public Job getJobById(Long id) {
    return jobService.findById(id);
  }

  @PostMapping("/jobs")
  public String createJob(@RequestBody Job job) {
    jobService.create(job);
    return "Job created successfully";
  }

  @PutMapping("/jobs/{id}")
  public String updateJob(@PathVariable Long id, Job job) {
    jobService.update(id, job);
    return "Job with id: " + id + " updated successfully";
  }

  @DeleteMapping("/jobs/{id}")
  public void deleteJob(@PathVariable Long id) {
    jobService.delete(id);
  }

  @GetMapping("/jobs/{id}/company")
  public String getCompanyByJobId(@PathVariable Long id) {
    return null;
  }
}
