package com.stratio.financial.test.application.repository;

import java.util.List;

import com.stratio.financial.test.domain.Pet;
import com.stratio.financial.test.domain.Pet.StatusEnum;

public interface PetRepository extends EntityRepository<Pet, Long> {

  <S extends Pet> List<S> findAllByStatusIn(List<StatusEnum> status);
}