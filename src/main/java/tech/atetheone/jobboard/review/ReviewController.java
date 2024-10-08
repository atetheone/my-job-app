package tech.atetheone.jobboard.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.atetheone.jobboard.company.Company;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}/reviews")
public class ReviewController {
  private final ReviewService reviewService;

  public ReviewController(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @GetMapping
  public List<Review> getReviews(@PathVariable Long companyId) {
    return reviewService.getAllReviews(companyId);
  }

  @PostMapping
  public ResponseEntity<String> createReview(@PathVariable Long companyId, @RequestBody Review review) {
    boolean created = reviewService.createReview(companyId, review);

    if (!created) {
      return new ResponseEntity<>("Company not found, review not saved!", HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok("Review created successfully");
  }

  @GetMapping("/{reviewId}")
  public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
    Review review = reviewService.getReviewById(companyId, reviewId);
    if (review == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok(review);
  }

  @PutMapping("/{reviewId}")
  public ResponseEntity<String> updateReview(
          @PathVariable Long companyId,
          @PathVariable Long reviewId,
          @RequestBody Review review) {
    boolean updated = reviewService.updateReview(companyId, reviewId, review);
    if (!updated) {
      return new ResponseEntity<>("Review not found, review not updated!", HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok("Review updated successfully");
  }

  @DeleteMapping("/{reviewId}")
  public ResponseEntity<String> deleteReview(
          @PathVariable Long companyId,
          @PathVariable Long reviewId) {
    boolean deleted = reviewService.deleteReview(companyId, reviewId);
    if (!deleted) {
      return new ResponseEntity<>("Review not found, review not deleted!", HttpStatus.NOT_FOUND);
    }
    return ResponseEntity.ok("Review deleted successfully");
  }
}
