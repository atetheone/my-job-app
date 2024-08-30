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
  public Review getReviewById(Long id) {
    return null;
  }

  @Override
  public boolean updateReview(Long id, Review review) {
    return false;
  }

  @Override
  public boolean deleteReview(Long id) {
    return false;
  }
}
