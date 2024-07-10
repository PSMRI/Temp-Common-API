package com.iemr.common.repo.customization;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.common.data.customization.FieldType;

@Repository
public interface FieldTypeRepo extends CrudRepository<FieldType, Integer> {
	
	@Query("Select f from FieldType f")
	List<FieldType> findFields();

}
