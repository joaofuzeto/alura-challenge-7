package br.com.challenge.testimonial;

public record DetailedTestimonialData(Long id, String photo, String testimonial, String name) {
	
	public DetailedTestimonialData(Testimonial testimonial) {
		this(testimonial.getId(), testimonial.getPhoto(), testimonial.getTestimonial(), testimonial.getName());
	}
}
