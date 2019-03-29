package hh.swd20.wilson.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {
	
	List<Song> findBySongName(String songName);

}
