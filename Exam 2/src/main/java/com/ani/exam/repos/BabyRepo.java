package com.ani.exam.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ani.exam.models.BabyName;

@Repository
public interface BabyRepo extends CrudRepository<BabyName, Long>{
	List<BabyName> findAll();
}