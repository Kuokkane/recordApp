package hh.swd20.wilson.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Album, Long> {
	
	List<Album> findByTitle(String title);

}
