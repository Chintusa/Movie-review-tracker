package com.org.movietracking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewDTO {
	private Long id;
	private String reviewerName;
	private String comment;
	private int rating;
//	private MovieDTO movieDTO;

	public ReviewDTO(String reviewerName, String comment, int rating) {
		super();
		this.reviewerName = reviewerName;
		this.comment = comment;
		this.rating = rating;
//		this.setMovieDTO(mvDto);
	}

//	public ReviewDTO(Long id, String reviewerName, String comment, int rating) {
//		super();
//		this.id = id;
//		this.reviewerName = reviewerName;
//		this.comment = comment;
//		this.rating = rating;
//
//	}

}
