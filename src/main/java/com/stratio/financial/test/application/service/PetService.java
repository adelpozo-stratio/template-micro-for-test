package com.stratio.financial.test.application.service;

import java.util.List;
import java.util.stream.Collectors;

import com.stratio.financial.test.application.repository.PetRepository;
import com.stratio.financial.test.domain.Pet;
import com.stratio.financial.test.domain.Pet.StatusEnum;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PetService {

  private final PetRepository petRepository;

  @SuppressWarnings("unchecked")
  public List<Pet> findAllByStatus(List<String> status) {
    return (List<Pet>) petRepository
        .findAllByStatusIn(status.stream()
            .map(StatusEnum::fromValue)
            .collect(Collectors.toList()));
  }

}
