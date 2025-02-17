package com.org.movietracking.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.movietracking.dto.ReviewDTO;
import com.org.movietracking.entity.Movie;
import com.org.movietracking.entity.Review;
import com.org.movietracking.repository.MovieRepository;
import com.org.movietracking.repository.ReviewRepository;
import com.org.movietracking.service.ReviewServices;

@Transactional
@Service
public class ReviewServicesImpl implements ReviewServices {
	private final ReviewRepository reviewRepo;
	private final MovieRepository movieRepo;

	public ReviewServicesImpl(ReviewRepository reviewRepo, MovieRepository movieRepo) {
		this.reviewRepo = reviewRepo;
		this.movieRepo = movieRepo;
	}

	@Override
	public ReviewDTO addReview(Long movieId, ReviewDTO reviewDTO) {
		Movie mv = movieRepo.findById(movieId).orElseThrow(() -> new RuntimeException("Movie not found!"));
		Review rv = new Review();
		rv.setReviewerName(reviewDTO.getReviewerName());
		rv.setComment(reviewDTO.getComment());
		rv.setRating(reviewDTO.getRating());
		rv.setMovie(mv);
		mv.getReviews().add(rv);
		Review savedReview = reviewRepo.save(rv);
		movieRepo.save(mv);
//		MovieDTO mvDto = new MovieDTO(mv);
		return new ReviewDTO(savedReview.getId(), savedReview.getReviewerName(), savedReview.getComment(),
				savedReview.getRating());
	}

	@Override
	public ReviewDTO updateReview(Long reviewId, ReviewDTO updatedReviewDTO) {
		Review review = reviewRepo.findById(reviewId).orElseThrow(() -> new RuntimeException("Review not found!"));
		review.setComment(updatedReviewDTO.getComment());
		review.setRating(updatedReviewDTO.getRating());
		reviewRepo.save(review);
//		MovieDTO mvDto = new MovieDTO(review.getMovie());

		return new ReviewDTO(review.getId(), review.getReviewerName(), review.getComment(), review.getRating());

	}

}
