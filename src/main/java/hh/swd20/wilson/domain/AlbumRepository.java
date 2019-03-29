package hh.swd20.wilson.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Band, Long> {
	
	List<Band> findByBandName(String bandName);

}
