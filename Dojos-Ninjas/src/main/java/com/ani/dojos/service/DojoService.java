package com.ani.dojos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ani.dojos.models.DojoModel;
import com.ani.dojos.repository.DojoRepository;

@Service
public class DojoService {

//	@Autowired
//	DojoRepository dojoRepo;
	private final DojoRepository dojoRepo;

	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo=dojoRepo;
		// TODO Auto-generated constructor stub
	}
	
	 public List<DojoModel> allDojos() {
	        return dojoRepo.findAll();
	    }
	    // creates an expense
	    public DojoModel createDojo(DojoModel d) {
	        return dojoRepo.save(d);
	    }
	    //updates an expenses
	    public DojoModel updateDojo(DojoModel d) {
	    	return dojoRepo.save(d);
	    }
	    
	    //Deletes an expense
	    public void deleteDojo (Long id) {
	    	dojoRepo.deleteById(id);
	    }
	    public DojoModel findDojo(Long id) {
	        Optional<DojoModel> optionalDojo = dojoRepo.findById(id);
	        if(optionalDojo.isPresent()) {
	            return optionalDojo.get();
	        } else {
	            return null;
	        }
	    }
	    public void deleteExpense (Long id) {
	    	dojoRepo.deleteById(id);
	    }
	

}
