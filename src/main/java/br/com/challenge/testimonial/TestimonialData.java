package br.com.challenge.testimonial;

import jakarta.validation.constraints.NotBlank;

public record TestimonialData(
		
		String photo, 
		
		@NotBlank
		String testimonial, 
		
		@NotBlank
		String name) {

}
