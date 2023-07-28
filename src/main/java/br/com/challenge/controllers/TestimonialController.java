package br.com.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.challenge.testimonial.DataListingTestimonials;
import br.com.challenge.testimonial.DetailedTestimonialData;
import br.com.challenge.testimonial.Testimonial;
import br.com.challenge.testimonial.TestimonialData;
import br.com.challenge.testimonial.TestimonialDataUpdate;
import br.com.challenge.testimonial.TestimonialRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/testimonials")
public class TestimonialController {

	@Autowired
	private TestimonialRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity registerTestimonial(@RequestBody @Valid TestimonialData data, UriComponentsBuilder uriBuilder) {
		var testimonial = new Testimonial(data);
		repository.save(testimonial);
		
		var uri = uriBuilder.path("/testimonials/{id}").buildAndExpand(testimonial.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DetailedTestimonialData(testimonial));
	}
		
	@GetMapping	
	public ResponseEntity<Page<DataListingTestimonials>> showTestimonials(Pageable pagination){
		var pages = repository.findAllByActiveTrue(pagination).map(DataListingTestimonials::new);
		return ResponseEntity.ok(pages);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity uptadeTestimonial(@RequestBody @Valid TestimonialDataUpdate data) {
		var testimonial = repository.getReferenceById(data.id());
		testimonial.update(data);
		return ResponseEntity.ok(new DetailedTestimonialData(testimonial));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity deleteTestimonial(@PathVariable Long id) {
		var testimonial = repository.getReferenceById(id);
		testimonial.delete();
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity detailingTestimonial(@PathVariable Long id) {
		var testimonial = repository.getReferenceById(id);
		
		return ResponseEntity.ok(new DetailedTestimonialData(testimonial));
	}
	
}
