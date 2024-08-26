package tech.atetheone.jobboard.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/jobs")
public class JobController {
  private JobService jobService;

  public JobController(JobService jobService) {
    this.jobService = jobService;
  }

  @GetMapping
  public ResponseEntity<List<Job>> getAllJobs() {
    return ResponseEntity.ok(jobService.findAll());
  }


  @PostMapping
  public ResponseEntity<String> createJob(@RequestBody Job job) {
    jobService.create(job);
    return ResponseEntity.ok("Job created successfully");
  }

  @GetMapping("/{id}")
  public ResponseEntity<Job> getJobById(@PathVariable Long id) {
    Job job = jobService.findById(id);
    if (job == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(job);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob) {
    boolean updated = jobService.update(id, updatedJob);
    if (!updated) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok("Job updated successfully");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteJob(@PathVariable Long id) {
    boolean deleted = jobService.delete(id);

    if (!deleted) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok("Job deleted successfully");
  }

  @GetMapping("/{id}/company")
  public String getCompanyByJobId(@PathVariable Long id) {
    return null;
  }
}
