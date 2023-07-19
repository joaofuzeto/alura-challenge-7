package br.com.challenge.testimonial;

public record DataListingTestimonials(Long id, String photo, String tesmtimonial, String name) {

	public DataListingTestimonials(Testimonial testimonial) {
		this(testimonial.getId(), testimonial.getPhoto(), testimonial.getTestimonial(), testimonial.getName());
	}
	
}
