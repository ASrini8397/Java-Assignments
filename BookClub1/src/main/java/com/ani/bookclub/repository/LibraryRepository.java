package com.ani.bookclub.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ani.bookclub.models.LibraryModel;

@Repository
public interface LibraryRepository extends CrudRepository<LibraryModel, Long> {
	List<LibraryModel> findAll();
}