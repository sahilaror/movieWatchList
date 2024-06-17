package com.example.demo.curds.movieRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.curds.entity.Movie;

@Repository
public interface movieRepository extends JpaRepository<Movie,Integer>{

}
