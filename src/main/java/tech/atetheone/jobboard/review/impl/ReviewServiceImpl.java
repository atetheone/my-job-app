package tech.atetheone.jobboard.review.impl;

import org.springframework.stereotype.Service;
import tech.atetheone.jobboard.company.Company;
import tech.atetheone.jobboard.company.CompanyService;
import tech.atetheone.jobboard.review.Review;
import tech.atetheone.jobboard.review.ReviewRepository;
import tech.atetheone.jobboard.review.ReviewService;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
  private final ReviewRepository reviewRepository;
  private final CompanyService companyService;

  public ReviewServiceImpl(ReviewRepository reviewRepository,
                           CompanyService companyService) {
    this.reviewRepository = reviewRepository;
    this.companyService = companyService;
  }
  @Override
  public List<Review> getAllReviews(Long companyId) {
    return reviewRepository.findByCompanyId(companyId);
  }

  @Override
  public boolean createReview(Long companyId, Review review) {
    Company company = companyService.findCompanyById(companyId);
    if (company == null)  return false;

    review.setCompany(company);
    reviewRepository.save(review);
    return true;
  }

  @Override
  public Review getReviewById(Long companyId, Long reviewId) {
    List<Review> reviews = reviewRepository.findByCompanyId(companyId);
    return reviews.stream()
            .filter(review -> review.getId().equals(reviewId))
            .findFirst()
            .orElse(null);
  }

  @Override
  public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
    Review existingReview = getReviewById(companyId, reviewId);
    if (existingReview == null) return false;

    updatedReview.setId(existingReview.getId());
    updatedReview.setCompany(existingReview.getCompany());
    reviewRepository.save(updatedReview);
    return true;
  }

  @Override
  public boolean deleteReview(Long companyId, Long reviewId) {
    if (companyService.findCompanyById(companyId) == null && reviewRepository.existsById(reviewId)) {
      Review review = reviewRepository.findById(reviewId).orElse(null);
      Company company = review.getCompany();
      company.getReviews().remove(review);
      companyService.updateCompany(companyId, company);
      reviewRepository.deleteById(reviewId);
      return true;
    }
    return false;
  }
}
