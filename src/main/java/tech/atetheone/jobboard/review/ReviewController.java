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
}
