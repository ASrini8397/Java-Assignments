package com.ani.dojos.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ani.dojos.models.DojoModel;

@Repository
public interface DojoRepository extends CrudRepository<DojoModel, Long> {
	 List<DojoModel> findAll();

}
