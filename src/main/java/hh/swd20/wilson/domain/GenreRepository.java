package hh.swd20.wilson.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long>{
	
	List<Genre> findByTitle(String title);

}
