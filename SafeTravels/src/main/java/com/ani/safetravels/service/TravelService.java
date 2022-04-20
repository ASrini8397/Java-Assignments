package com.ani.safetravels.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ani.safetravels.models.Expense;
import com.ani.safetravels.repository.TravelRepository;

@Service
public class TravelService {
	private final TravelRepository travelRepository;
	
    
    public TravelService(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }
    // returns all the expenses
    public List<Expense> allExpenses() {
        return travelRepository.findAll();
    }
    // creates an expense
    public Expense createExpense(Expense exp) {
        return travelRepository.save(exp);
    }
    //updates an expenses
    public Expense updateExpense(Expense exp) {
    	return travelRepository.save(exp);
    }
    
    //Deletes an expense
    public void deleteExpense (Long id) {
    	travelRepository.deleteById(id);
    }
    
    
    // retrieves an expense
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = travelRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
}
