package br.com.challenge.testimonial;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TestimonialRepository extends JpaRepository<Testimonial, Long> {

	Page<Testimonial> findAllByActiveTrue(Pageable page);	
	
	@Query(nativeQuery = true, value = "select * from testimonials order by rand() limit 3")
	List<Testimonial> findByOrderById();
}
