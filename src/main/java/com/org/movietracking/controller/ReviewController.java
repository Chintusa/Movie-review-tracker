package com.org.movietracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.movietracking.dto.ReviewDTO;
import com.org.movietracking.service.impl.ReviewServicesImpl;

@RestController
@RequestMapping("/movies/reviews")
public class ReviewController {
	@Autowired
	private ReviewServicesImpl reviewServices;

	@PostMapping("/{movieId}")
	public ResponseEntity<ReviewDTO> addReview(@PathVariable Long movieId, @RequestBody ReviewDTO ReviewDto) {
		ReviewDTO review = reviewServices.addReview(movieId, ReviewDto);
		return ResponseEntity.ok(review);
	}

	@PutMapping("/{reviewId}")
	public ResponseEntity<ReviewDTO> updateReview(@PathVariable Long reviewId, @RequestBody ReviewDTO ReviewDto) {
		ReviewDTO updateReviewDTO = reviewServices.updateReview(reviewId, ReviewDto);
		return ResponseEntity.ok(updateReviewDTO);
	}
}
