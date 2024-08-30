package tech.atetheone.jobboard.review;

import java.util.List;

public interface ReviewService {
  List<Review> getAllReviews(Long companyId);
  Review getReviewById(Long id);
  boolean createReview(Long companyId, Review review);
  boolean updateReview(Long id, Review review);
  boolean deleteReview(Long id);
}
