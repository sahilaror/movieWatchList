package com.example.demo.curds.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.curds.entity.Movie;
import com.example.demo.curds.service.databaseService;

import jakarta.validation.Valid;


@RestController
public class MovieController {
	
	
	
	@GetMapping("watchListItemForm")
	public ModelAndView showWatchLisForm(@RequestParam(required = false)Integer id) {
		String view="watchListItemForm";
		Map<String, Object> model=new HashMap<>();
		
//		Movie movie=new Movie();
//		movie.setTitle("danki");
//		movie.setPriority("first");
//		movie.setRating(8);
//		movie.setComment("one time watch movie");
//		model.put("watchListItem",movie);
		if(id==null) {		
		model.put("watchListItem",new Movie());
		}
		else {
			model.put("watchListItem",dataService.getById(id));
		}
		return new ModelAndView(view,model);
	}
	
	@Autowired
	databaseService dataService;
	
	@PostMapping("watchListItemForm")
	public ModelAndView submitMovieListForm(@Valid @ModelAttribute("watchListItem") Movie movie ,BindingResult br)
	{
		
		if (br.hasErrors()) {
			return new ModelAndView("watchListItemForm");
		}
		
		Integer idInteger=movie.getId();
		if (idInteger==null) {
			
		 dataService.create(movie);
		}
		else {
			dataService.updateId(movie,idInteger);
		}
		 RedirectView rd=new RedirectView();
		 rd.setUrl("/watchList");
		 return new ModelAndView(rd);
	}
	
	@GetMapping("/watchList")
	public ModelAndView getWatchList() {
		String viewName="watchList";
		Map<String,Object> model=new HashMap<>();
		List<Movie> movieList=dataService.getAllMovie();
		model.put("watchListRows",movieList);
		model.put("noOfRows", movieList.size());
		return new ModelAndView(viewName,model);
	}
}
