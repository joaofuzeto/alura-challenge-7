package br.com.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.challenge.testimonial.Testimonial;
import br.com.challenge.testimonial.TestimonialData;
import br.com.challenge.testimonial.TestimonialRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/testimonials")
public class TestimonialController {

	@Autowired
	private TestimonialRepository repository;
	
	@PostMapping
	@Transactional
	public void registerTestimonial(@RequestBody @Valid TestimonialData data) {
		repository.save(new Testimonial(data));
	}
}
