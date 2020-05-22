package com.stratio.financial.test.infrastructure.db.springdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stratio.financial.test.application.repository.PetRepository;
import com.stratio.financial.test.domain.Pet;

@Repository
public interface SpringDataPetRepository extends CrudRepository<Pet, Long>, PetRepository {

}
