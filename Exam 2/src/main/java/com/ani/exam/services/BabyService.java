package com.ani.exam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ani.exam.models.BabyName;
//import com.ani.exam.models.Library;
import com.ani.exam.repos.BabyRepo;

@Service
public class BabyService {
	
//	CRUD
	@Autowired
	private BabyRepo babyRepo;

//	READ ALL
	public List<BabyName> allBabyNames() {
		return babyRepo.findAll();
	}
	
//	CREATE 
	public BabyName createBaby(BabyName b) {

		return babyRepo.save(b);
	}
	
//	READ ONE
	public BabyName findBaby(Long id) {
		Optional<BabyName> optionalBaby = babyRepo.findById(id);
		if (optionalBaby.isPresent()) {
			return optionalBaby.get();
		} else {
			return null;
		}
	}
	
//	UPDATE
	public BabyName updateBaby(BabyName b) {
		return babyRepo.save(b);
	}
//	public Book updateBookWithLib(Book b, Library l) {
//		b.setLibrary(l);
//		return bookRepo.save(b);
//	}
	
//	DELETE
	public void deleteBaby(Long id) {
		babyRepo.deleteById(id);
	}
	
}
