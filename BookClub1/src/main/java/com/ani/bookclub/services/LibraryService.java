package com.ani.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ani.bookclub.models.LibraryModel;
import com.ani.bookclub.repository.LibraryRepository;

@Service
public class LibraryService {
	
	@Autowired
	private LibraryRepository libraryRepo;
	
//	READ ALL
	public List<LibraryModel> allLibraries() {
		return libraryRepo.findAll();
	}
	
//	CREATE 
	public LibraryModel createLibrary(LibraryModel l) {
//		b.setAuthor(null);
		return libraryRepo.save(l);
	}
	
//	READ ONE
	public LibraryModel findLibrary(Long id) {
		Optional<LibraryModel> optionalBook = libraryRepo.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
//	UPDATE
	public LibraryModel updateLibrary(LibraryModel l) {
		return libraryRepo.save(l);
	}
	
//	DELETE
	public void deleteLibrary(Long id) {
		libraryRepo.deleteById(id);
	}
	
}