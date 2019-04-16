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
import hh.swd20.wilson.domain.Band;
import hh.swd20.wilson.domain.BandRepository;
import hh.swd20.wilson.domain.GenreRepository;
import hh.swd20.wilson.domain.UserRepository;

@Controller
public class WilsonController {
	
	@Autowired
	private BandRepository brepository;
	
	@Autowired
	private GenreRepository grepository; 
	
	
	
	
	
	  @RequestMapping(value="/login")
	    public String login() {	
	        return "login";
	    }	
	  
	 @RequestMapping(value="/bandlist")
	    public String bandList(Model model) {	
	    	model.addAttribute("bands", brepository.findAll());
	       return "bandlist"; 
	    }
	 
	// REST Find all bands
	    @RequestMapping(value="/bands", method = RequestMethod.GET)
	    public @ResponseBody List<Band> bandListRest() {	
	        return (List<Band>) brepository.findAll();
	    }    

	    //REST get band by id
	    
	    @RequestMapping(value="/band/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Band> findBandRest(@PathVariable("bandId") Long bandId){
	    	return brepository.findById(bandId);
	    }
	 
	    //REST add new band
	    
	    @RequestMapping (value="/bands", method=RequestMethod.POST)
	    public @ResponseBody Band addNewBandRest(@RequestBody Band band) {
	    	return brepository.save(band);
	    }
	    
	    
	 @RequestMapping(value = "/addband")
	    public String addBand(Model model){
	    	model.addAttribute("band", new Band());
	    	model.addAttribute("genres", grepository.findAll());
	        return "addband";
	    } 
	 
	 
	  @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Band band){
	        brepository.save(band);
	        return "redirect:bandlist";
	    }   
	  
	  @PreAuthorize("hasAuthority('USER')")
	  @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteBand(@PathVariable("bandId") Long bandId, Model model) {
	    	brepository.deleteById(bandId);
	        return "redirect:../bandlist";
	        
	   }
	  
	  //edit band
	  @RequestMapping (value="/editband/{id}")
	  public String editBand (@PathVariable("bandId") Long bandId, Model model) {
	  model.addAttribute("band", brepository.findById(bandId));
	  model.addAttribute("genres", grepository.findAll());
	  return "editband";
	  }
	  
	  

	  
}

