package br.com.challenge.testimonial;

import jakarta.validation.constraints.NotNull;

public record TestimonialDataUpdate(
		
		@NotNull
		Long id, 
		
		String photo,
		
		String testimonial) {

}
