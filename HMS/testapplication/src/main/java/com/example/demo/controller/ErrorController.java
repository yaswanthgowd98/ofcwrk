package com.example.demo.controller;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class ErrorController {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException
		(HttpServletRequest request, Exception ex){
		ModelAndView mv = new ModelAndView();

		mv.addObject("exception", ex.getLocalizedMessage());
		mv.addObject("url", request.getRequestURL());
		
		mv.setViewName("diagnosis");
		
		return mv;
	}
  
	
	/*
	@ExceptionHandler(UsernameNotFoundException.class)
	public String handleException1
		(HttpServletRequest request, UsernameNotFoundException ex){
		ModelAndView mv = new ModelAndView();

		mv.addObject("exception", ex.getLocalizedMessage());
		//mv.addObject("url", request.getRequestURL());
		
		
		return "redirect:/login";
	}    */
	/*
	@ExceptionHandler(EntityNotFoundException.class)
	public ModelAndView handleException2
		(HttpServletRequest request, Exception ex){
		ModelAndView mv = new ModelAndView();

		mv.addObject("msg", ex.getLocalizedMessage());
		mv.addObject("description",request.getAttribute("description"));
		
		mv.setViewName("diagnosis");
		return mv;
	}  
       */
}
