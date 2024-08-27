package tech.atetheone.jobboard.job;

import java.util.List;
import java.util.Optional;

/*
  * This interface defines the methods that the JobService class should implement.
  * findAll: This method returns a list of Job objects.
  * findById: This method returns a specific Job object by its id.
  * create: This method creates a new Job object.
  * update: This method updates an existing Job object by its id.
  * delete: This method deletes an existing Job object by its id.
 */
public interface JobService {
  List<Job> findAll();
  Optional<Job> findById(Long id);
  void create(Job job);
  boolean update(Long id, Job job);
  boolean delete(Long id);
}
