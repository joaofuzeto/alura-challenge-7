package br.com.challenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.challenge.testimonial.DataListingTestimonials;
import br.com.challenge.testimonial.TestimonialRepository;

@RestController
@RequestMapping("/testimonials-home")
public class TestimonialHomeController {
	
	@Autowired
	private TestimonialRepository repository;
	
	@GetMapping
	public ResponseEntity<List<DataListingTestimonials>> findByOrderByIdRamdonly(){
		var result = repository.findByOrderById().stream().map(DataListingTestimonials::new).toList();
		return ResponseEntity.ok(result);
	}

}
