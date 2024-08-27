package tech.atetheone.jobboard.job.impl;

import org.springframework.stereotype.Service;
import tech.atetheone.jobboard.job.Job;
import tech.atetheone.jobboard.job.JobRepository;
import tech.atetheone.jobboard.job.JobService;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
  private JobRepository jobRepository;

  public JobServiceImpl(JobRepository jobRepository) {
    this.jobRepository = jobRepository;
  }

  @Override
  public List<Job> findAll() {
    return jobRepository.findAll();
  }

  @Override
  public Optional<Job> findById(Long id) {
    return jobRepository.findById(id);
  }

  @Override
  public void create(Job job) {
    jobRepository.save(job);
  }

  @Override
  public boolean update(Long id, Job job) {
    Optional<Job> optionalJob = jobRepository.findById(id);

    if (optionalJob.isPresent()) {
      Job newJob = optionalJob.get();
      newJob.setTitle(job.getTitle());
      newJob.setDescription(job.getDescription());
      newJob.setLocation(job.getLocation());
      newJob.setMinSalary(job.getMinSalary());
      newJob.setMaxSalary(job.getMaxSalary());
      jobRepository.save(newJob);
      return true;
    }

    return false;
  }

  @Override
  public boolean delete(Long id) {
    if (jobRepository.existsById(id)) {
      jobRepository.deleteById(id);
      return true;
    }
    return false;
  }

}
