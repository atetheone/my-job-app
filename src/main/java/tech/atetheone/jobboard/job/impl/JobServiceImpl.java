package tech.atetheone.jobboard.job.impl;

import org.springframework.stereotype.Service;
import tech.atetheone.jobboard.job.Job;
import tech.atetheone.jobboard.job.JobService;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
  private List<Job> jobs = new ArrayList<>();

  @Override
  public List<Job> findAll() {
    return this.jobs;
  }

  @Override
  public Job findById(Long id) {
    for (Job j : this.jobs) {
      if (j.getId() == id) {
        return j;
      }
    }
    return null;
  }

  @Override
  public void create(Job job) {
    this.jobs.add(job);
  }

  @Override
  public void update(Long id, Job job) {
    for (Job j : this.jobs) {
      if (j.getId() == id) {
        j.setTitle(job.getTitle());
        j.setDescription(job.getDescription());
        j.setLocation(job.getLocation());
        j.setMinSalary(job.getMinSalary());
        j.setMaxSalary(job.getMaxSalary());
      }
    }
  }

  @Override
  public void delete(Long id) {
    for (Job j : this.jobs) {
      if (j.getId() == id) {
        this.jobs.remove(j);
        break;
      }
    }
  }
}
