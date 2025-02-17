package com.org.movietracking.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.org.movietracking.entity.Movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieDTO {
	private Long id;
	private String title;
	private String genre;
	private int releaseYear;
	private List<ReviewDTO> reviews;

	public MovieDTO(String title, String genre, int releaseYear, List<ReviewDTO> list) {
		super();
		this.title = title;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.reviews = list;
	}

	public MovieDTO(Movie mv) {
		super();
		this.id = mv.getId();
		this.title = mv.getTitle();
		this.genre = mv.getGenre();
		this.releaseYear = mv.getReleaseYear();
		this.reviews = mv.getReviews().stream()
				.map(review -> new ReviewDTO(review.getReviewerName(), review.getComment(), review.getRating()))
				.collect(Collectors.toList());
	}
}
