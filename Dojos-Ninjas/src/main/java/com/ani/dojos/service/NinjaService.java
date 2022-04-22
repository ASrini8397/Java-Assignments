package com.ani.dojos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ani.dojos.models.DojoModel;
import com.ani.dojos.models.NinjaModel;
import com.ani.dojos.repository.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	private final NinjaRepository ninjaRepo;

	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo=ninjaRepo;
		// TODO Auto-generated constructor stub
	}
	
	 public NinjaModel findNinja(Long id) {
	        Optional<NinjaModel> optionalNinja = ninjaRepo.findById(id);
	        if(optionalNinja.isPresent()) {
	            return optionalNinja.get();
	        } else {
	            return null;
	        }
	    }
	 public List<NinjaModel> allNinjas() {
	        return ninjaRepo.findAll();
	    }
	
	
	 
	    // creates an expense
	    public NinjaModel createNinja(NinjaModel n) {
	        return ninjaRepo.save(n);
	    }
	    //updates an expenses
	    public NinjaModel updateNinja(NinjaModel n) {
	    	return ninjaRepo.save(n);
	    }
	    
	    //Deletes an expense
	    public void deleteNinja (Long id) {
	    	ninjaRepo.deleteById(id);
	    }

		public List<NinjaModel> findByID(Long dojo_id) {
			// TODO Auto-generated method stub
			return ninjaRepo.findAllById(dojo_id);
		}
		
		  public void deleteExpense (Long id) {
		    	ninjaRepo.deleteById(id);
		    }
		

}
