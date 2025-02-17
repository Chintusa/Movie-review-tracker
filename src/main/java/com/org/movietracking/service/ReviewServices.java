package com.org.movietracking.service;

import com.org.movietracking.dto.ReviewDTO;

public interface ReviewServices {

	/**
	 * Adds a new review for a specific movie.
	 *
	 * @param movieId   the ID of the movie for which the review is being added.
	 * @param reviewDTO the review details.
	 * @return the added ReviewDTO object.
	 */
	ReviewDTO addReview(Long movieId, ReviewDTO reviewDTO);

	/**
	 * Updates an existing review.
	 *
	 * @param reviewId         the ID of the review to update.
	 * @param updatedReviewDTO the updated review details.
	 * @return the updated ReviewDTO object.
	 */
	ReviewDTO updateReview(Long reviewId, ReviewDTO updatedReviewDTO);
}
