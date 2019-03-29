package hh.swd20.wilson;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import hh.swd20.wilson.domain.*;
import hh.swd20.wilson.domain.Band;
import hh.swd20.wilson.domain.Album;
import hh.swd20.wilson.domain.Genre;
import hh.swd20.wilson.domain.GenreRepository;
import hh.swd20.wilson.domain.BandRepository;
import hh.swd20.wilson.domain.AlbumRepository;
import hh.swd20.wilson.domain.Song;
import hh.swd20.wilson.domain.SongRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class WilsonApplication {
	private static final Logger log = LoggerFactory.getLogger(WilsonApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WilsonApplication.class, args);
	}

	@Bean
	public CommandLineRunner WilsonDemo (BandRepository brepository, GenreRepository grepository, AlbumRepository arepository, SongRepository srepository, UserRepository urepository){
		return (args) -> {
			
			log.info("Saved bands");
			
			Genre progressiverock = new Genre ("Progressive Rock");
			grepository.save(progressiverock);
			Genre psychedelicrock = new Genre("Psychedelic Rock");
			grepository.save(psychedelicrock);
			Genre progressivemetal = new Genre ("Progressive Metal");
			grepository.save(progressivemetal);
			Genre postprogressive = new Genre ("Post-progressive");
			grepository.save(postprogressive);
			Genre alternativerock = new Genre ("Alternative Rock");
			grepository.save(alternativerock);
			
			brepository.save(new Band("Altamont", 2, 1983, "Acid Tapes", 1984));
			brepository.save(new Band("Porcupine Tree", 5, 1987, "Kscope, Roadrunner Records, Peaceville Records, Atlantic Records", 2010));
			
			arepository.save(new Album("Prayer for the soul", "Simon \"Si\" Vockings "/*, grepository.findByTitle("Psychedelic Rock").get(0)*/));
			arepository.save(new Album("The Incident", "Richard Barbieri, Colin Edwin, Gavin Harrison"));
			
			srepository.save(new Song ("Raven That Refused To Sing", 7.49));
			srepository.save(new Song ("I Drive the Hearse", 6.41));
			
			log.info("Fetch all bands");
			for (Band band : brepository.findAll()) {
				log.info(band.toString());
			}
		};
	

}
}
