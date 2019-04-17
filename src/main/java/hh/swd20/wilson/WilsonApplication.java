package hh.swd20.wilson;

import org.springframework.boot.CommandLineRunner;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.wilson.domain.User;
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
			
			log.info("Saving data");
			
			Genre krautrock = new Genre ("Krautrock");
			grepository.save(krautrock);
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
			
			brepository.save(new Band("Steven Wilson", 1, 2009, "Kscope, Caroline International", 0));
			brepository.save(new Band("Altamont", 2, 1983, "Acid Tapes", 1984));
			brepository.save(new Band("Porcupine Tree", 5, 1987, "Kscope, Roadrunner Records, Peaceville Records, Atlantic Records", 2010));
			
			arepository.save(new Album("Prayer for the soul", "Simon \"Si\" Vockings ", grepository.findByGenreName("Krautrock").get(0)));
			arepository.save(new Album("The Incident", "Richard Barbieri, Colin Edwin, Gavin Harrison", grepository.findByGenreName("Progressive Rock").get(0)));
			
			srepository.save(new Song ("Raven That Refused To Sing", 7.49, arepository.findByTitle("The Incident").get(0)));
			srepository.save(new Song ("I Drive the Hearse", 6.41, arepository.findByTitle("The Incident").get(0)));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
			log.info("Fetch all bands");
			for (Band band : brepository.findAll()) {
				log.info(band.toString());
			}
		};
	

}
}
