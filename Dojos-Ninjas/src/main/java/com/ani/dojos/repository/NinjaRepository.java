package com.ani.dojos.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ani.dojos.models.DojoModel;
import com.ani.dojos.models.NinjaModel;

@Repository
public interface NinjaRepository extends CrudRepository<NinjaModel, Long> {
	 List<NinjaModel> findAll();
	 


	List<NinjaModel> findAllById(Long dojo_id);
	 
	 

}
