package com.example.demo.curds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.curds.entity.Movie;
import com.example.demo.curds.movieRepo.movieRepository;

@Service
public class databaseService {
	@Autowired
	movieRepository movieRepo;
	
	@Autowired
	ratingService ratingSer;
	
	public void create(Movie movie) {
		String rating=ratingSer.getApi(movie.getTitle());
		if (rating!=null) {
			movie.setRating(Float.parseFloat(rating));
		}
		movieRepo.save(movie);
	}
	
	public List<Movie> getAllMovie(){
		return movieRepo.findAll();
	}
	
	public Movie getById(Integer id) {
		return movieRepo.findById(id).get();
	}

	public void updateId(Movie movie, Integer idInteger) {
		// TODO Auto-generated method stub
		Movie toBeUpdateMovie=getById(idInteger);
		toBeUpdateMovie.setComment(movie.getComment());
		toBeUpdateMovie.setPriority(movie.getPriority());
		toBeUpdateMovie.setRating(movie.getRating());
		toBeUpdateMovie.setTitle(movie.getTitle());
		movieRepo.save(toBeUpdateMovie);
	}
}
