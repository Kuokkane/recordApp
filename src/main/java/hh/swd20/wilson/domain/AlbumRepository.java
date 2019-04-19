package hh.swd20.wilson.domain;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Long> {
	
	List<Album> findByTitle(String title);
	
	List<Album> findByBand(Band band);
	
	List<Album> findByAlbumId(Long id);

}
