package hh.swd20.wilson.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BandRepository extends CrudRepository<Band, Long> {

	List<Band> findByBandName(String bandName);
}
