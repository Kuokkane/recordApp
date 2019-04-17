package hh.swd20.wilson.web;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.wilson.domain.Album;
import hh.swd20.wilson.domain.AlbumRepository;
import hh.swd20.wilson.domain.Band;
import hh.swd20.wilson.domain.BandRepository;
import hh.swd20.wilson.domain.GenreRepository;
import hh.swd20.wilson.domain.Song;
import hh.swd20.wilson.domain.SongRepository;
import hh.swd20.wilson.domain.UserRepository;

@Controller
public class WilsonController {
	
	@Autowired
	private BandRepository brepository;
	
	@Autowired
	private GenreRepository grepository; 
	
	@Autowired
	private AlbumRepository arepository;
	
	@Autowired
	private SongRepository srepository;
	
	
	
	
	  @RequestMapping(value="/login")
	    public String login() {	
	        return "login";
	    }	
	  
	 @RequestMapping(value="/bandlist")
	    public String bandList(Model model) {	
	    	model.addAttribute("bands", brepository.findAll());
	       return "bandlist"; 
	    }
	 
	 @RequestMapping(value="/albumlist")
	 public String albumList(Model model) {
		 model.addAttribute("albums", arepository.findAll());
		 return "albumlist";
	 }
	 
	 @RequestMapping(value="/songlist")
	 public String songList(Model model) {
		 model.addAttribute("songs", srepository.findAll());
		 return "songlist";
	 }
	 
 // REST Find all songs
	 
	 @RequestMapping(value="/songs", method = RequestMethod.GET)
	    public @ResponseBody List<Song> songListRest() {	
	        return (List<Song>) srepository.findAll();
	    } 
	 
	 
 // REST add new song
	 
	 @RequestMapping (value="/addsong", method=RequestMethod.POST)
	    public @ResponseBody Song addNewSongRest(@RequestBody Song song) {
	    	return srepository.save(song);
	    }
	 
	 
	 // add new song
	 @RequestMapping(value = "/addsong")
	    public String addSong(Model model){
	    	model.addAttribute("song", new Song());
	        return "addsong";
	    } 
	 
	// delete song
	 
		 @PreAuthorize("hasAuthority('ADMIN')")
		  @RequestMapping(value = "/delete/{songId}", method = RequestMethod.GET)
		    public String deleteSong(@PathVariable("songId") Long songId, Model model) {
		    	srepository.deleteById(songId);
		        return "redirect:../songlist";
		 }
	 
	 // REST Find all albums
	 
	 @RequestMapping(value="/albums", method = RequestMethod.GET)
	    public @ResponseBody List<Album> albumListRest() {	
	        return (List<Album>) arepository.findAll();
	    } 
	 
	 // REST add new album
	 
	 @RequestMapping (value="/addalbum", method=RequestMethod.POST)
	    public @ResponseBody Album addNewAlbumRest(@RequestBody Album album) {
	    	return arepository.save(album);
	    }
	 
	 // add album
	 
	 @RequestMapping(value = "/addalbum")
	    public String addAlbum(Model model){
	    	model.addAttribute("album", new Album());
	    	model.addAttribute("genres", grepository.findAll());
	        return "addalbum";
	    } 
	 
	 // delete album
	 
	 @PreAuthorize("hasAuthority('ADMIN')")
	  @RequestMapping(value = "/delete/{albumId}", method = RequestMethod.GET)
	    public String deleteAlbum(@PathVariable("albumId") Long albumId, Model model) {
	    	arepository.deleteById(albumId);
	        return "redirect:../albumlist";
	 }
	 
	 // find all bands
	 
	    @RequestMapping(value="/bandlist")
	    public String findAllBands(Model model) {	
	        model.addAttribute("bands", brepository.findAll());
	        return "bandlist"; 
	    }

	 
	// REST Find all bands
	    @RequestMapping(value="/bands", method = RequestMethod.GET)
	    public @ResponseBody List<Band> bandListRest() {	
	        return (List<Band>) brepository.findAll();
	    }    

	    //REST get band by id
	    
	    @RequestMapping(value="/bands/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Band> findBandRest(@PathVariable("id") Long bandId){
	    	return brepository.findById(bandId);
	    }
	 
	    //REST add new band
	    
	    @RequestMapping (value="/addband", method=RequestMethod.POST)
	    public @ResponseBody Band addNewBandRest(@RequestBody Band band) {
	    	return brepository.save(band);
	    }
	    
	    // add band
	 @RequestMapping(value = "/addband")
	    public String addBand(Model model){
	    	model.addAttribute("band", new Band());
	    	model.addAttribute("genres", grepository.findAll());
	        return "addband";
	    } 
	 
	 
	 //save band
	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Band band){
	        brepository.save(band);
	        return "redirect:bandlist";
	    }   
	  
	  //delete band
	  
	  @PreAuthorize("hasAuthority('ADMIN')")
	  @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteBand(@PathVariable("id") Long bandId, Model model) {
	    	brepository.deleteById(bandId);
	        return "redirect:../bandlist";
	        
	   }
	  
	  //edit band
	  @RequestMapping (value="/editband/{id}")
	  public String editBand (@PathVariable("id") Long bandId, Model model) {
	  model.addAttribute("band", brepository.findById(bandId));
	  model.addAttribute("genres", grepository.findAll());
	  return "editband";
	  }
	  
	  

	  
}

